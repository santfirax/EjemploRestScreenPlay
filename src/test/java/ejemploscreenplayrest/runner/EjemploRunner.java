package ejemploscreenplayrest.runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static cucumber.api.SnippetType.CAMELCASE;

@CucumberOptions(
        features = "src//test//resources//features//ejemplo_rest.feature",
        glue = {"ejemploscreenplayrest.stepdefinitions", "ejemploscreenplayrest.utils"},
        snippets = CAMELCASE
)
@RunWith(CucumberWithSerenity.class)
public class EjemploRunner {
}
