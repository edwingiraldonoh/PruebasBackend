package com.proyecto.stepdefinicions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.proyecto.utils.Constantes;
import com.proyecto.models.Usuario;
import com.proyecto.questions.CodigoRespuesta;
import com.proyecto.tasks.ActualizarUsuarioApi;
import com.proyecto.tasks.CrearUsuarioApi;
import com.proyecto.tasks.EliminarUsuarioApi;
import com.proyecto.tasks.GetUsuarioApi;
import net.serenitybdd.screenplay.actors.OnStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.apache.http.HttpStatus.SC_OK;

public class GestionUsuarioStepDefinicions {

    private Usuario usuario;

    @Given("creo un nuevo usuario con username {string}, nombre {string}, apellido {string} y email {string}")
    public void creoUnNuevoUsuario(String username, String firstName, String lastName, String email) {
        usuario = new Usuario(username, firstName, lastName, email);

        // Solo crear el actor - la URL base ya está configurada en el Hook
        OnStage.theActorCalled(Constantes.ACTOR);

        OnStage.theActorInTheSpotlight().attemptsTo(
                CrearUsuarioApi.conDatos(usuario)
        );

        // Verificar que la creación fue exitosa
        theActorInTheSpotlight().should(
                seeThat(CodigoRespuesta.obtenido(), equalTo(SC_OK))
        );
    }

    @When("consulto el usuario creado")
    public void consultoUsuarioCreado() {
        theActorInTheSpotlight().attemptsTo(
                GetUsuarioApi.conUsername(usuario.getUsername())
        );
    }

    @Then("el sistema debe mostrar el usuario con código 200")
    public void sistemaMuestraUsuarioCodigo200() {
        theActorInTheSpotlight().should(
                seeThat(CodigoRespuesta.obtenido(), equalTo(SC_OK))
        );
    }

    @When("actualizo el usuario con nuevo nombre {string} y email {string}")
    public void actualizoUsuario(String nuevoNombre, String nuevoEmail) {
        usuario.setFirstName(nuevoNombre);
        usuario.setEmail(nuevoEmail);

        theActorInTheSpotlight().attemptsTo(
                ActualizarUsuarioApi.conDatos(usuario)
        );
    }

    @Then("la actualización debe ser exitosa con código 200")
    public void actualizacionExitosaCodigo200() {
        theActorInTheSpotlight().should(
                seeThat(CodigoRespuesta.obtenido(), equalTo(SC_OK))
        );
    }

    @And("elimino el usuario")
    public void eliminoUsuario() {
        theActorInTheSpotlight().attemptsTo(
                EliminarUsuarioApi.conUsername(usuario.getUsername())
        );
    }

    @Then("la eliminación debe ser exitosa con código 200")
    public void eliminacionExitosaCodigo200() {
        theActorInTheSpotlight().should(
                seeThat(CodigoRespuesta.obtenido(), equalTo(SC_OK))
        );
    }
}