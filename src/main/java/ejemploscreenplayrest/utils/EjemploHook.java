package ejemploscreenplayrest.utils;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class EjemploHook {
    @Before
    public void configuracionInicial() {
        setTheStage(new OnlineCast());
        theActorCalled("Leonardo").whoCan(CallAnApi.at("https://reqres.in/api"));

    }

    @After
    public void finalizarConfiguracionInicial() {
        drawTheCurtain();
    }
}
