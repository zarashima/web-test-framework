package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE, METHOD})
public @interface TestIntegration {

	public enum Integration {
		PERCY, NONE
	}

	public enum Event {
		NAVIGATION, CLICK, FINDELEMENT
	}

	Integration integration() default Integration.NONE;

	Event event() default Event.NAVIGATION;

}
