package com.herokuapp.testing.questions;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.Question;

import static org.hamcrest.Matchers.equalTo;

public class ElUsuarioRecibeUnTokenDeAutenticacionValido implements Question<Boolean>{


    @Override
    public Boolean answeredBy(Actor actor) {
        ValidatableResponse validatableResponse = actor.recall("validatableResponse");
        return validatableResponse.statusCode(200)
                .body("token", equalTo("abc123"))
                .extract()
                .response()
                .statusCode() == 200;
    }

    public static Question<Boolean> esValido() {
        return new ElUsuarioRecibeUnTokenDeAutenticacionValido();
    }
}
