package ejemploscreenplayrest.stepdefinitions;

import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Entonces;
import ejemploscreenplayrest.model.User;
import ejemploscreenplayrest.questions.UltimaRespuestaDelServicio;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.questions.TheResponse;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

public class EjemploStepDefinitions {
    @Cuando("^creo un usuario con nombre \"([^\"]*)\" y trabajo \"([^\"]*)\"$")
    public void creoUnUsuarioConNombreYTrabajo(String nombre, String trabajo) {
        User user = User.createUserWithName(nombre).withJob(trabajo);
        theActorInTheSpotlight().attemptsTo(Post.to("/users").with(requestSpecification -> requestSpecification.contentType(ContentType.JSON)
                .body(user).log().all().relaxedHTTPSValidation()));

    }


    @Entonces("^la creacion de leonardo fue exitosa$")
    public void laCreacionDeLeonardoFueExitosa() {
        theActorInTheSpotlight().should(seeThat(TheResponse.statusCode(), is(equalTo(201))),
                seeThat(UltimaRespuestaDelServicio.obtenerCampo("name"), is(equalTo("leonardo"))),
                seeThat(UltimaRespuestaDelServicio.obtenerCampo("job"), is(equalTo("automatizador"))));
    }
}
