package quoters;

import lombok.*;

import java.util.List;

/**
 * Created by Jeka on 14/10/2015.
 */

public class TerminatorQuoter implements Quoter {
    private List<String> messages;


    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @Override
    @Benchmark
    public void sayQuote() {
        for (String message : messages) {
            System.out.println(message);
        }
    }

}
