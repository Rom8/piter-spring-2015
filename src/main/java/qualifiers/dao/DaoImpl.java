package qualifiers.dao;

import qualifiers.DBType;
import qualifiers.Db;
import qualifiers.dao.Dao;

/**
 * Created by Jeka on 15/10/2015.
 */
@Db(DBType.MONGO)
public class DaoImpl implements Dao {
    @Override
    public void save() throws InterruptedException {
        System.out.println("saving to Mongo very fast");
    }
}
