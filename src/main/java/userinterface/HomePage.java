package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static final Target ACCEDER_GMAIL = Target.the("Gmail").locatedBy("//*[contains(@class,'button') and text()='Acceder']");
    public static final Target LOGIN_USER = Target.the("Username input").located(By.id("identifierId"));
    public static final Target NEXT_USER = Target.the("Next button").located(By.id("identifierNext"));
    public static final Target LOGIN_PASS = Target.the("Password input").located(By.name("Passwd"));
    public static final Target LOGIN_BUTTON = Target.the("LogIn button").located(By.id("passwordNext"));
    public static final Target BUTTON_REDACTAR = Target.the("Redactar nuevo correo").locatedBy("//*[@class='T-I T-I-KE L3']");
    public static final Target MESSAGE_SUCCESS = Target.the("Message success").locatedBy("//*[contains(text(),'Ver mensaje')]");


}
