package com.herokuapp.booker.testing.stepdefinitions;

import com.herokuapp.testing.interactions.SendRequest;
import com.herokuapp.testing.questions.ElUsuarioRecibeUnTokenDeAutenticacionValido;
import com.herokuapp.testing.tasks.GenerarTokenDeAutenticacion;


import com.herokuapp.testing.tasks.StructurJsonToken;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;


import java.util.List;
import java.util.Map;

import static com.herokuapp.testing.utils.ConstantsString.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import net.serenitybdd.screenplay.actors.OnlineCast;



public class CrearTokenStepDefinitions {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^Que se requiere conocer la informacion detallada de las solicitud$")
    public void queSeRequiereConocerLaInformacionDetalladaDeLasSolicitud(List<Map<String, Object>> table) {
        theActorCalled("userAutomation").remember("table", table);
    }

    @Cuando("^Se hace la busqueda del estado de solicitud con un solo filtro$")
    public void seHaceLaBusquedaDelEstadoDeSolicitudConUnSoloFiltro() {
        theActorInTheSpotlight().attemptsTo(StructurJsonToken.withData());
        theActorInTheSpotlight().attemptsTo(SendRequest.toApiGateway(END_POINT, SERVICE, theActorInTheSpotlight().recall("json")));
    }

}


