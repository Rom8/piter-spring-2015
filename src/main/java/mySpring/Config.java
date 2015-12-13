package mySpring;

/**
 * Created by Jeka on 14/10/2015.
 */
public interface Config {

    <T> Class<T> getImpl(Class<T> type);
}
