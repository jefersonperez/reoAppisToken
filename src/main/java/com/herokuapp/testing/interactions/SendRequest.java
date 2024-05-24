package com.herokuapp.testing.interactions;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.util.concurrent.TimeUnit;

import static com.herokuapp.testing.utils.ConstantsString.*;


public class SendRequest implements Interaction {

/*
    private final String endpoint;
    private final String service;
    private final String jsonRequest;

    public SendRequest(String endpoint, String service, String jsonRequest) {
        this.endpoint = endpoint;
        this.service = service;
        this.jsonRequest = jsonRequest;
    }

    public static SendRequest toApiGateway(String endpoint, String service, String jsonRequest) {
        return Tasks.instrumented(SendRequest.class, endpoint, service, jsonRequest);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int status;
        int maxWaitTimeSeconds = 50;
        long startTime = System.currentTimeMillis();
        String statusDetail = null;
        JsonPath result;

      // while (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime) < maxWaitTimeSeconds) {
            SerenityRest.given().relaxedHTTPSValidation().contentType(CONTENT_TYPE_VALUE)
                    .body(jsonRequest)
                    .baseUri(endpoint)
                    .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
                    .header(CONNECTION, CONNECTION_VALUE)
                    .header(ACCEPT_ENCODING, ACCEPT_ENCODING_VALUE)
                    .header(ACCEPT, ACCEPT_VALUE)
                    .header(USER_AGENT, USER_AGENT_VALUE)
                    .header(HOST, HOST_VALUE)
                    .header(CONTENT_LENGTH, CONTENT_LENGTH_VALUE)
                    .basePath(service)
                    .when().post();
            status = SerenityRest.lastResponse().statusCode();
            System.out.println(status);

            result = SerenityRest.lastResponse().jsonPath();
            actor.remember(SERVICE_STATUS, status);
            actor.remember(RESPONSE_JSON_REQUEST, result);
        System.out.println(result);


        //}
    }*/

    private final String endpoint;
    private final String service;
    private final String jsonRequest;

    public SendRequest(String endpoint, String service, String jsonRequest) {
        this.endpoint = endpoint;
        this.service = service;
        this.jsonRequest = jsonRequest;
    }

    public static SendRequest toApiGateway(String endpoint, String service, String jsonRequest) {
        return Tasks.instrumented(SendRequest.class, endpoint, service, jsonRequest);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.given().relaxedHTTPSValidation().contentType(CONTENT_TYPE_VALUE)
                .body(jsonRequest)
                .baseUri(endpoint)
                .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
                .header(CONNECTION, CONNECTION_VALUE)
                .header(ACCEPT_ENCODING, ACCEPT_ENCODING_VALUE)
                .header(ACCEPT, ACCEPT_VALUE)
                .header(USER_AGENT, USER_AGENT_VALUE)
                .header(HOST, HOST_VALUE)
                .header(CONTENT_LENGTH, CONTENT_LENGTH_VALUE)
                .basePath(service)
                .when().post();

        int status = SerenityRest.lastResponse().statusCode();
        System.out.println(status);

        JsonPath result = SerenityRest.lastResponse().jsonPath();
        actor.remember(SERVICE_STATUS, status);
        actor.remember(RESPONSE_JSON_REQUEST, result);
        System.out.println(result);
    }


}
