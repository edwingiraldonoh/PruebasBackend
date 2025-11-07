package com.proyecto.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.rest.SerenityRest;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUsuarioApi implements Task {

    private final String username;

    public GetUsuarioApi(String username) {
        this.username = username;
    }

    public static GetUsuarioApi conUsername(String username) {
        return instrumented(GetUsuarioApi.class, username);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.given()
                .pathParam("username", username)
                .when()
                .get("/user/{username}");  // Solo el endpoint relativo
    }
}