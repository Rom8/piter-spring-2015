package quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collection;

/**
 * Created by Jeka on 14/10/2015.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        SapService sapService = context.getBean(SapService.class);
        while (true) {
            sapService.doWork();
            sapService.drinkBeer();
            Thread.sleep(1000);
        }
    }
}
