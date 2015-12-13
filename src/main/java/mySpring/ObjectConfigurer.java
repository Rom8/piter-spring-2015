package mySpring;

/**
 * Created by Jeka on 14/10/2015.
 */
public interface ObjectConfigurer {
    void configure(Object t) throws IllegalAccessException, InstantiationException;
}
