package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import userinterface.EmailPage;
import userinterface.HomePage;

public class SendEmail implements Task {
    private String user;
    private String attachment;

    public SendEmail(String user, String attachment) {
        this.user = user;
        this.attachment = attachment;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        actor.attemptsTo(
                Click.on(HomePage.BUTTON_REDACTAR),
                SendKeys.of(user).into(EmailPage.FIELD_PARA).thenHit(Keys.ENTER),
                SendKeys.of("Prueba 01").into(EmailPage.FIELD_ASUNTO),
                Click.on(EmailPage.DRIVE)
        );

        driver.switchTo().frame(EmailPage.FRAME.resolveFor(actor));

        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(EmailPage.SELECT_DOC.of(attachment)),
                Click.on(EmailPage.ATTACHMENT)
        );

        driver.switchTo().defaultContent();

        OnStage.theActorInTheSpotlight().attemptsTo(
                SendKeys.of("Cordial Saludo, adjunto: " + attachment).into(EmailPage.BODY_EMAIL),
                Click.on(EmailPage.SEND_EMAIL)
        );
    }

    public static SendEmail withAttachment(String user, String attachment){
        return Tasks.instrumented(SendEmail.class, user, attachment);
    }

}
