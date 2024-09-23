package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EmailPage {

    public static final Target FIELD_PARA = Target.the("Campo destinatario").locatedBy("//*[@aria-label='Destinatarios en Para']");
    public static final Target FIELD_ASUNTO = Target.the("Campo asunto").locatedBy("//*[@placeholder='Asunto']");
    public static final Target DRIVE = Target.the("Drive").locatedBy("//*[contains(@aria-label,'Drive') and @role='button']");
    public static final Target SELECT_DOC = Target.the("Select {0}").locatedBy("//*[@role='option']//*[contains(text(),'{0}')]");
    public static final Target FRAME = Target.the("iFrame").locatedBy("//iframe[contains(@allow,'https://docs.google.com')]");
    public static final Target ATTACHMENT = Target.the("attachment").locatedBy("//button[contains(@aria-label,'Insertar') and contains(@aria-label,'elemento') ]");
    public static final Target SEND_EMAIL = Target.the("Send email").locatedBy("//*[@role='button' and contains(@aria-label,'Enviar ')]");
    public static final Target BODY_EMAIL = Target.the("Body email").locatedBy("//*[@aria-label='Cuerpo del mensaje' and contains(@class,'editable')]");

}
