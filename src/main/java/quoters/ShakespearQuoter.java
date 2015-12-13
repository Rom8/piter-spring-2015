package quoters;

/**
 * Created by Jeka on 14/10/2015.
 */
public class ShakespearQuoter implements Quoter {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {
        System.out.println(message);
    }

}
