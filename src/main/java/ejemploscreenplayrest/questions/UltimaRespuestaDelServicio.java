package ejemploscreenplayrest.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

@Subject("{0} el texto del campo #campo")
public class UltimaRespuestaDelServicio implements Question<String> {
    private final String campo;

    private UltimaRespuestaDelServicio(String campo) {
        this.campo = campo;
    }

    @Override
    public String answeredBy(Actor actor) {
        return LastResponse.received().answeredBy(actor).getBody().jsonPath().getString(campo);
    }

    public static UltimaRespuestaDelServicio obtenerCampo(String campo) {
        return new UltimaRespuestaDelServicio(campo);
    }
}
