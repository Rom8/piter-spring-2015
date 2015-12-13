package mySpring;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by Jeka on 14/10/2015.
 */
public class InjectAnnotationObjectConfigurer implements ObjectConfigurer {
    @Override
    public void configure(Object t) throws IllegalAccessException, InstantiationException {
        Class<?> type = t.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                field.set(t,ObjectFactory.getInstance().createObject(field.getType()));
            }
        }
    }
}
