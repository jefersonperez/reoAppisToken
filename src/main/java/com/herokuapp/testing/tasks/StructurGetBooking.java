package com.herokuapp.testing.tasks;

import com.google.gson.Gson;
import models.GetBookingModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class StructurGetBooking  implements Task {
    private GetBookingModel getBookingModel;

    public StructurGetBooking(GetBookingModel getBookingModel) {
        this.getBookingModel = getBookingModel;
    }

    public static StructurGetBooking withData(GetBookingModel getBookingModel) {
        return Tasks.instrumented(StructurGetBooking.class, getBookingModel);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Gson gson = new Gson();
        String jsonBooking = gson.toJson(getBookingModel);
        System.out.println(jsonBooking);
        actor.remember("json", jsonBooking);
    }
}
