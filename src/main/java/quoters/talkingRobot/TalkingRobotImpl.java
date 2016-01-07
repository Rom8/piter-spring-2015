package quoters.talkingRobot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import quoters.quoters.Quoter;
import quoters.annotations.PostInit;
import quoters.annotations.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jeka on 14/10/2015.
 */
@Transactional
@Component
public class TalkingRobotImpl implements TalkingRobot {
    @Autowired(required = false)
    private List<Quoter> quoters = Arrays.asList(new Quoter() {
        @Override
        public void sayQuote() {
            System.out.println("This is default quote");
        }
    });

    @Override
    @PostInit
    public void talk() {
        for (Quoter quoter : quoters) {
            quoter.sayQuote();
        }
    }
}
