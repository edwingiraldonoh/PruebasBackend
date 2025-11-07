package com.proyecto.tasks;

import com.proyecto.models.Usuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.rest.SerenityRest;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CrearUsuarioApi implements Task {

    private final Usuario usuario;

    public CrearUsuarioApi(Usuario usuario) {
        this.usuario = usuario;
    }

    public static CrearUsuarioApi conDatos(Usuario usuario) {
        return instrumented(CrearUsuarioApi.class, usuario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.given()
                .contentType("application/json")
                .body(usuario)
                .when()
                .post("/user");  // Solo el endpoint relativo
    }
}