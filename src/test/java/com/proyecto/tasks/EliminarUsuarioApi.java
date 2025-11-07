package com.proyecto.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.rest.SerenityRest;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EliminarUsuarioApi implements Task {

    private final String username;

    public EliminarUsuarioApi(String username) {
        this.username = username;
    }

    public static EliminarUsuarioApi conUsername(String username) {
        return instrumented(EliminarUsuarioApi.class, username);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.given()
                .pathParam("username", username)
                .when()
                .delete("/user/{username}");  // Solo el endpoint relativo
    }
}
