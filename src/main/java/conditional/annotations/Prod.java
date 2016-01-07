package conditional.annotations;

import conditional.condition.OnProdCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnProdCondition.class)
public @interface Prod {

}
