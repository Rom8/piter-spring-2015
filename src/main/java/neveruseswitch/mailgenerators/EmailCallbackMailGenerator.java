package neveruseswitch.mailgenerators;

import neveruseswitch.MailCode;
import neveruseswitch.mailgenerators.MailGenerator;
import org.springframework.stereotype.Component;

/**
 * Created by Jeka on 15/10/2015.
 */
@MailCode("2")
public class EmailCallbackMailGenerator implements MailGenerator {
    @Override
    public String generateHtml() {
        return "don't call us we call you";
    }
}
