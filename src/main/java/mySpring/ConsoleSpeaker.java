package mySpring;

/**
 * Created by Jeka on 14/10/2015.
 */
public class ConsoleSpeaker implements Speaker {
    public void speak(String message) {
        System.out.println(message);
    }
}
