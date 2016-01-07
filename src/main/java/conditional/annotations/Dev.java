package conditional.annotations;

import conditional.condition.OnDevCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnDevCondition.class)
public @interface Dev {
}
