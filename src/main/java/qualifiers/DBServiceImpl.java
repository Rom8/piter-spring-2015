package qualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Jeka on 15/10/2015.
 */
@Service
@EnableScheduling
public class DBServiceImpl implements DBService {
    @Mongo
    private Dao dao;

    @Override
    @Scheduled(cron = "1/2 * * * * ?")
    public void doStuff() throws InterruptedException {
        System.out.println("Working...");
        dao.save();
    }
}





