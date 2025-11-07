package com.proyecto.hooks;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import io.restassured.RestAssured;
import com.proyecto.utils.Constantes;

public class Hook {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());

        // Configurar RestAssured directamente
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "/v2";
    }
}