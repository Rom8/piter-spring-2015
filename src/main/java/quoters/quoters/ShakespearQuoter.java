package quoters.quoters;

import mySpring.InjectRandomInt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import quoters.quoters.Quoter;

/**
 * Created by Jeka on 14/10/2015.
 */
@Component
public class ShakespearQuoter implements Quoter {

    @InjectRandomInt(min = 3, max = 6)
    private int repeat;

    @Value("${shakespear}")
    private String message;



    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }

}
