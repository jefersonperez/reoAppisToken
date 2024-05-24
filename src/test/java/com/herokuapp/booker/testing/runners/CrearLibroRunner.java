package com.herokuapp.booker.testing.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com.herokuapp.booker/crearLibro.feature",
        glue = {"com.herokuapp.booker.testing.stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)


public class CrearLibroRunner {
}
