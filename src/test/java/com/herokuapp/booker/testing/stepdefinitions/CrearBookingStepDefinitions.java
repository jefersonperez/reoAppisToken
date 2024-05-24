package com.herokuapp.booker.testing.stepdefinitions;

import com.herokuapp.testing.interactions.SendBookingRequest;
import com.herokuapp.testing.tasks.StructurBooking;
import io.cucumber.java.*;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

import static com.herokuapp.testing.utils.ConstatsStringsCreate.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CrearBookingStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^Que se requiere crear una reserva con la siguiente informacion$")
    public void queSeRequiereCrearUnaReservaConLaSiguienteInformacion(List<Map<String, Object>> table) {
        theActorCalled("userAutomation").remember("table", table);
    }

    @Cuando("^Se hace la solicitud para crear una reserva$")
    public void seHaceLaSolicitudParaCrearUnaReserva() {
        theActorInTheSpotlight().attemptsTo(StructurBooking.withData());
        theActorInTheSpotlight().attemptsTo(SendBookingRequest.toApiGateway(END_POINT, SERVICE_BOOKING, theActorInTheSpotlight().recall("json")));
    }

}
