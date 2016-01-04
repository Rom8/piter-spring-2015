package quoters;

import java.util.Random;

/**
 * Created by Jeka on 15/10/2015.
 */
public class IntegerFactory2 {
    public int getInt(){
        Random random = new Random();
        return 100+ random.nextInt(100);
    }
}
