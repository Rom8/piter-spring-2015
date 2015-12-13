package mySpring;

/**
 * Created by Jeka on 14/10/2015.
 */
public class IRobot {

    @Inject
    private Speaker speaker;
    @Inject
    private Cleaner cleaner;

    public IRobot() {
        System.out.println(speaker.getClass());
    }

    public void cleanRoom(){
        speaker.speak("I started my work");
        cleaner.clean();
        speaker.speak("I finished my work");
    }
}
