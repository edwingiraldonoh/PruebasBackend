package com.proyecto.tasks;

import com.proyecto.models.Usuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.rest.SerenityRest;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ActualizarUsuarioApi implements Task {

    private final Usuario usuario;

    public ActualizarUsuarioApi(Usuario usuario) {
        this.usuario = usuario;
    }

    public static ActualizarUsuarioApi conDatos(Usuario usuario) {
        return instrumented(ActualizarUsuarioApi.class, usuario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.given()
                .contentType("application/json")
                .pathParam("username", usuario.getUsername())
                .body(usuario)
                .when()
                .put("/user/{username}");  // Solo el endpoint relativo
    }
}
