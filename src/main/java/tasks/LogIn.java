package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import userinterface.HomePage;

public class LogIn implements Task {

    private String username;
    private String password;

    public LogIn(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.ACCEDER_GMAIL),
                SendKeys.of(username).into(HomePage.LOGIN_USER),
                Click.on(HomePage.NEXT_USER),
                SendKeys.of(password).into(HomePage.LOGIN_PASS),
                Click.on(HomePage.LOGIN_BUTTON)
        );
    }

    public static LogIn successfully(String username, String password){
        return Tasks.instrumented(LogIn.class, username, password);
    }

}
