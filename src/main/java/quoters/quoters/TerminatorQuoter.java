package quoters.quoters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import quoters.annotations.Transactional;
import quoters.quoters.Quoter;

import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jeka on 14/10/2015.
 */

@Component
@Transactional
public class TerminatorQuoter implements Quoter {

    private List<String> messages;

    @Value("${terminator}")
    public void setMessages(String[] messages) {
        this.messages = Arrays.asList(messages);
    }

    @PreDestroy
    public void killAll() {
        System.out.println("You are terminated");
    }

    @Override
    public void sayQuote() {
        for (String message : messages) {
            System.out.println(message);
        }
    }

}
