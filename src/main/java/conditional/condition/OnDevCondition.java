package conditional.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by Jeka on 15/10/2015.
 */
public class OnDevCondition implements Condition{
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//        return System.getenv().get("COMP_TYPE").equalsIgnoreCase("DEV");
        return false;
    }
}
