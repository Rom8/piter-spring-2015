package qualifiers;

import org.springframework.stereotype.Repository;

/**
 * Created by Jeka on 15/10/2015.
 */
@Mongo
public class DaoImpl implements Dao {
    @Override
    public void save() throws InterruptedException {
        System.out.println("saving to Mongo very fast");
    }
}
