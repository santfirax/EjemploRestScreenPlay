package ejemploscreenplayrest.interactions;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumirServicio implements Interaction {
    private String path;
    private Object body;

    public ConsumirServicio(Object request, String path) {
        this.body = request;
        this.path = path;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(path).with(request -> request.contentType(ContentType.JSON)
                .body(body).log().all().relaxedHTTPSValidation()));
     }

    public static ConsumirServicio conRequest(Object request, String path) {
        return instrumented(ConsumirServicio.class, request, path);
    }
}
