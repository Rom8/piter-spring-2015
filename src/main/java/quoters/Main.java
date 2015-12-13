package quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collection;

/**
 * Created by Jeka on 14/10/2015.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        System.out.println("---------------");
        Quoter quoter = context.getBean(ShakespearQuoter.class);
        quoter.sayQuote();
    }
}
