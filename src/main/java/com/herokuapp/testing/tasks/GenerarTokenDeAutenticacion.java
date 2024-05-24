package com.herokuapp.testing.tasks;


import net.serenitybdd.screenplay.Task;

import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.questions.RestQueryFunction;




public class GenerarTokenDeAutenticacion {

    public static Task laURLDeLaAPIEs(String url) {
        return (Task) Task.where("{0} define la URL de la API como " + url,
                actor -> actor.remember("api.url", url)
        );
    }


    public static Task enviarSolicitudDeAutenticacion() {
        return (Task) Task.where("{0} envía una solicitud para generar un token de autenticación a la URL de la API",
                actor -> actor.attemptsTo(
                        Post.to("/auth")
                                .with(request -> request.header("Content-Type", "application/json")
                                        .body("{\"username\": \"admin\", \"password\": \"password123\"}")
                                )
                                .with((RestQueryFunction) CallAnApi.at(actor.recall("api.url")))
                )
        );
    }

}
