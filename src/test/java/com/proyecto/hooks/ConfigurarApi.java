package com.proyecto.hooks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.Actor;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConfigurarApi implements Task {

    private final String urlApi;

    public ConfigurarApi(String urlApi) {
        this.urlApi = urlApi;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.can(CallAnApi.at(urlApi));
    }

    public static ConfigurarApi conUrl(String urlApi) {
        return instrumented(ConfigurarApi.class, urlApi);
    }
}