package screenSaver;

import javafx.util.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jeka on 15/10/2015.
 */
public class TwoSecondsScopeProvider implements Scope {
    private Map<String, Pair<Date, Object>> map = new HashMap<>();


    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (!map.containsKey(name) || new Date().getTime() - map.get(name).getKey().getTime() > 2000) {
            map.put(name, new Pair<>(new Date(), objectFactory.getObject()));
        }

        return map.get(name).getValue();
    }















    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
