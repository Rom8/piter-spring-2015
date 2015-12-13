package mySpring;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by Jeka on 14/10/2015.
 */
public class InjectRandomIntAnnotationObjectConfigurer implements ObjectConfigurer {
    @Override
    public void configure(Object t) throws IllegalAccessException {
        Class<?> type = t.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                Random random = new Random();
                int randomInt = min + random.nextInt(max - min + 1);
                field.setAccessible(true);
                field.set(t, randomInt);
            }
        }
    }
}
