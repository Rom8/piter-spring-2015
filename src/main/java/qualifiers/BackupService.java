package qualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Jeka on 15/10/2015.
 */
@Service
public class BackupService {
    @Db(DBType.SYBASE)
    private Dao dao;

    @Scheduled(cron = "1/3 * * * * ?")
    public void doBackup() throws InterruptedException {
        System.out.println("Backuping...");
        dao.save();

    }
}
