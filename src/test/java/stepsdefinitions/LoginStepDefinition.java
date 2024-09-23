package stepsdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import tasks.LogIn;
import tasks.SendEmail;
import userinterface.EmailPage;
import userinterface.HomePage;

public class LoginStepDefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Usuario QA");
    }
    @Given("the user is on the main page")
    public void theUserIsOnTheMainPage() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url("https://www.google.com/intl/es-419/gmail/about/")
        );
    }

    @Given("the user logged in with {string} and {string}")
    public void theUserLoggedInWithAnd(String username, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LogIn.successfully(username, password)
        );
    }

    @When("he creates a new email to {string} and attaches the file {string}")
    public void heCreatesANewEmailToAndAttachesTheFile(String user, String doc) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SendEmail.withAttachment(user, doc)
        );
    }

    @Then("he can see the success message")
    public void heCanSeeTheSuccessMessage() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(HomePage.MESSAGE_SUCCESS).isEnabled()
        );
    }

}
