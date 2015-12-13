package mySpring;

import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by Jeka on 14/10/2015.
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private List<ObjectConfigurer> configurers = new ArrayList<>();
    private Reflections reflections = new Reflections("mySpring");


    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {
        Set<Class<? extends ObjectConfigurer>> classes = reflections.getSubTypesOf(ObjectConfigurer.class);
        for (Class<? extends ObjectConfigurer> configurerClass : classes) {
            if (!Modifier.isAbstract(configurerClass.getModifiers())) {
                try {
                    configurers.add(configurerClass.newInstance());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }

    public <T> T createObject(Class<T> type) throws IllegalAccessException, InstantiationException {
        type = resolveImpl(type);
        T t = type.newInstance();
        configure(t);
        return t;
    }















    private <T> Class<T> resolveImpl(Class<T> type) {
        if (type.isInterface()) {
            type = config.getImpl(type);
        }
        return type;
    }

    private <T> void configure(T t) throws IllegalAccessException, InstantiationException {
        for (ObjectConfigurer configurer : configurers) {
            configurer.configure(t);
        }
    }


}
