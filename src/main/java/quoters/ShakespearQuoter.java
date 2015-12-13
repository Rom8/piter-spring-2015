package quoters;

import mySpring.InjectRandomInt;

/**
 * Created by Jeka on 14/10/2015.
 */
public class ShakespearQuoter implements Quoter {

    @InjectRandomInt(min = 3, max = 6)
    private int repeat;

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }

}
