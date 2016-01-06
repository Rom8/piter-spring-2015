package neveruseswitch;

import neveruseswitch.mailgenerators.MailGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Jeka on 15/10/2015.
 */
@Component
@EnableScheduling
public class MailSender {

    @Autowired
    private Map<String, MailGenerator> map;






    @Scheduled(cron = "1/2 * * * * ?")
    public void sendMail() {
        String mailCode = String.valueOf(DBUtils.getMailCode());

        MailGenerator mailGenerator = map.get(mailCode);
        if (mailGenerator == null) {
            throw new RuntimeException(mailCode + " not binded");
        }
        String html = mailGenerator.generateHtml();
        send(html);









    }

    private void send(String html) {
        System.out.println("Sending... "+html);
    }
}






