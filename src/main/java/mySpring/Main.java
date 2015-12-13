package mySpring;

/**
 * Created by Jeka on 14/10/2015.
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        iRobot.cleanRoom();
    }
}
