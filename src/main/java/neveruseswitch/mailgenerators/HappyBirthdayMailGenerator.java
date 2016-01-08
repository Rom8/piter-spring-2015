package neveruseswitch.mailgenerators;

import neveruseswitch.MailCode;
import neveruseswitch.mailgenerators.MailGenerator;
import org.springframework.stereotype.Component;

/**
 * Created by Jeka on 15/10/2015.
 */
@MailCode("3")
public class HappyBirthdayMailGenerator implements MailGenerator {
    @Override
    public String generateHtml() {
        return "happy birthday";
    }
}
