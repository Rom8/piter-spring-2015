package quoters;

import lombok.*;

import javax.annotation.PreDestroy;
import java.util.List;

/**
 * Created by Jeka on 14/10/2015.
 */

@DeprecatedClass(T1000.class)
public class TerminatorQuoter implements Quoter {
    private List<String> messages;


    public void setMessages(List<String> messages) {
        this.messages = messages;
    }


    public void killAll(){
        System.out.println("You are terminated");
    }

    @Override
    public void sayQuote() {
        for (String message : messages) {
            System.out.println(message);
        }
    }

}
