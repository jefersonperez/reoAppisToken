package com.herokuapp.booker.testing.stepdefinitions;

import com.herokuapp.testing.interactions.SendRequestGetBooking;
import com.herokuapp.testing.utils.ConstantsString;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;


import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.junit.Assert.assertEquals;

public class GetBookingStepDefinitions {

    @Then("El estado de la solicitud debe ser {int}")
    public void elEstadoDeLaSolicitudDebeSer(int expectedStatusCode) {
        assertEquals(expectedStatusCode, SerenityRest.lastResponse().statusCode());
    }

    @Then("El valor del campo firstname debe coincidir con el enviado en el request del paso anterior")
    public void elValorDelCampoFirstnameDebeCoincidirConElEnviadoEnElRequestDelPasoAnterior() {

    }
}
