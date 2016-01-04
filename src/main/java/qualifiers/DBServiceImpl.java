package qualifiers;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Jeka on 15/10/2015.
 */
@Service
@EnableScheduling
public class DBServiceImpl implements DBService {
    @Db(DBType.MONGO)
    private Dao dao;

    @Override
    @Scheduled(cron = "${scheduling}")
    public void doStuff() throws InterruptedException {
        System.out.println("Working...");
        dao.save();
    }
}





