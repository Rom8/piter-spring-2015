package quoters;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Jeka on 14/10/2015.
 */
@Transactional
public class TalkingRobotImpl implements TalkingRobot {
    private List<Quoter> quoters;



    public void setQuoters(List<Quoter> quoters) {
        this.quoters = quoters;
    }

    @Override
    @PostInit
    public void talk() {
        for (Quoter quoter : quoters) {
            quoter.sayQuote();
        }
    }
}
