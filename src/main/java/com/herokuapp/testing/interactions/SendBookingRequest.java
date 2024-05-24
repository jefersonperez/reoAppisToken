package com.herokuapp.testing.interactions;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import static com.herokuapp.testing.utils.ConstatsStringsCreate.*;

public class SendBookingRequest implements Interaction {

    private final String endpoint;
    private final String service;
    private final String jsonRequest;

    public SendBookingRequest(String endpoint, String service, String jsonRequest) {
        this.endpoint = endpoint;
        this.service = service;
        this.jsonRequest = jsonRequest;
    }

    public static SendBookingRequest toApiGateway(String endpoint, String service, String jsonRequest) {
        return Tasks.instrumented(SendBookingRequest.class, endpoint, service, jsonRequest);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            System.out.println("Sending request to " + endpoint + service);
            System.out.println("Request body: " + jsonRequest);

            try {
                Response response = SerenityRest.given()
                        .relaxedHTTPSValidation()
                        .contentType(CONTENT_TYPE_VALUE)
                        .body(jsonRequest)
                        .baseUri(endpoint)
                        .basePath(service)
                        .when().post();

            // Verificar si la respuesta no es nula
            if (response != null) {
                // Imprimir el JSON de la respuesta en consola
                String jsonResponse = response.asString();
                System.out.println("JSON Response: " + jsonResponse);

                int status = response.statusCode();
                System.out.println("HTTP Status: " + status);

                JsonPath result = response.jsonPath();
                actor.remember(SERVICE_STATUS, status);
                actor.remember(RESPONSE_JSON_REQUEST, result);

                String firstnameSent = new JsonPath(jsonRequest).getString("firstname");
                String firstnameReceived = result.getString("booking.firstname");

                // Aserción del código de estado HTTP
                if (status != 200) {
                    throw new AssertionError("Expected HTTP status 200, but got " + status);
                }

                // Aserción del campo "firstname"
                if (!firstnameSent.equals(firstnameReceived)) {
                    throw new AssertionError("Expected firstname " + firstnameSent + ", but got " + firstnameReceived);
                }
            } else {
                System.err.println("Response is null");
            }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.err.println("An error occurred during the request:");
            e.printStackTrace();
        }
    }
}
