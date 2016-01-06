package neveruseswitch.mailgenerators;

import neveruseswitch.mailgenerators.MailGenerator;
import org.springframework.stereotype.Component;

/**
 * Created by Jeka on 15/10/2015.
 */
@Component("3")
public class HappyBirthdayMailGenerator implements MailGenerator {
    @Override
    public String generateHtml() {
        return "happy birthday";
    }
}
