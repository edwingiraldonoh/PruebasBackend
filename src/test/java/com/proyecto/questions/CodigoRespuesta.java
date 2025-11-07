package com.proyecto.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CodigoRespuesta implements Question<Integer> {

    public CodigoRespuesta() {}

    public static CodigoRespuesta obtenido() {
        return new CodigoRespuesta();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }
}