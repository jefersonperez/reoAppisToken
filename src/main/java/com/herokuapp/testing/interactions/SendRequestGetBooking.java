package com.herokuapp.testing.interactions;

import com.herokuapp.testing.utils.ConstantsString;
import com.herokuapp.testing.utils.constantsGetBook;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SendRequestGetBooking  implements Task {
    private String id;

    public SendRequestGetBooking(String id) {
        this.id = id;
    }

    public static SendRequestGetBooking toService(String id) {
        return Tasks.instrumented(SendRequestGetBooking.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Response response = SerenityRest.given()
                .relaxedHTTPSValidation()
                .contentType(constantsGetBook.APP_JSON)
                .get(constantsGetBook.SERVICE_ENDPOINT + id);
        actor.remember("response", response);
    }

}
