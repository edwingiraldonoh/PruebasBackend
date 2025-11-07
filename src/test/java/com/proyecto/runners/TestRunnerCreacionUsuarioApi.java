package com.proyecto.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/gestion_usuario.feature",
        glue = {"com.proyecto.stepdefinicions", "com.proyecto.hooks"},
        tags = "@CreacionUsuario"
)
public class TestRunnerCreacionUsuarioApi {
}