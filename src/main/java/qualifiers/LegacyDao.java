package qualifiers;

import org.springframework.stereotype.Repository;

/**
 * Created by Jeka on 15/10/2015.
 */
@Sybase
public class LegacyDao implements Dao {
    @Override
    public void save() throws InterruptedException {
        System.out.println("saving to Sybase");
        Thread.sleep(50);
    }
}
