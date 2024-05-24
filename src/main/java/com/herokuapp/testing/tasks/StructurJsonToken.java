package com.herokuapp.testing.tasks;

import com.google.gson.Gson;
import models.AuthModel;
import models.JsonTokenModel;
import models.builder.AuthBuilder;
import models.builder.JsonTokenBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;
import java.util.Map;

public class StructurJsonToken implements Task {
 /*   private List<Map<String, Object>> table;

    public static StructurJsonToken withData() {
        return Tasks.instrumented(StructurJsonToken.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Gson gson = new Gson();
        table = actor.recall("table");




        JsonTokenModel jsonTokenModel = new JsonTokenBuilder()
                .withPassword(table.get(0).get("password").toString())
                .withUserName(table.get(0).get("userName").toString())

                .build();


        String xcVariable = gson.toJson(jsonTokenModel);
        System.out.println(xcVariable);
        actor.remember("json", xcVariable);
    }*/

    private List<Map<String, Object>> table;

    public static StructurJsonToken withData() {
        return Tasks.instrumented(StructurJsonToken.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Gson gson = new Gson();
        table = actor.recall("table");

        JsonTokenModel jsonTokenModel = new JsonTokenBuilder()
                .withPassword(table.get(0).get("password").toString())
                .withUserName(table.get(0).get("userName").toString())
                .build();

        String xcVariable = gson.toJson(jsonTokenModel);
        System.out.println(xcVariable);
        actor.remember("json", xcVariable);
    }
}
