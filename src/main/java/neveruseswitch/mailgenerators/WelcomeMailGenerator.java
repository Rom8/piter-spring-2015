package neveruseswitch.mailgenerators;

import neveruseswitch.mailgenerators.MailGenerator;
import org.springframework.stereotype.Component;

/**
 * Created by Jeka on 15/10/2015.
 */
@Component("1")
public class WelcomeMailGenerator implements MailGenerator {
    @Override
    public String generateHtml() {
        //20 lines code
        return "WELCOME CLIENT";
    }
}
