package com.herokuapp.testing.tasks;

import com.google.gson.Gson;
import models.BookingModel;
import models.builder.BookingBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;
import java.util.Map;

public class StructurBooking implements Task {
    private List<Map<String, Object>> table;

    public static StructurBooking withData() {
        return Tasks.instrumented(StructurBooking.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Gson gson = new Gson();
        table = actor.recall("table");

        BookingModel booking = new BookingBuilder()
                .withFirstname(table.get(0).get("firstname").toString())
                .withLastname(table.get(0).get("lastname").toString())
                .withTotalprice(Integer.parseInt(table.get(0).get("totalprice").toString()))
                .withDepositpaid(Boolean.parseBoolean(table.get(0).get("depositpaid").toString()))
                .withCheckin(table.get(0).get("checkin").toString())
                .withCheckout(table.get(0).get("checkout").toString())
                .withAdditionalneeds(table.get(0).get("additionalneeds").toString())
                .build();

        String jsonRequest = gson.toJson(booking);
        System.out.println(jsonRequest);
        actor.remember("json", jsonRequest);
    }
}
