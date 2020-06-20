package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface TestInfo {

  public enum Priority {
    LOW, MEDIUM, HIGH
  }

  String module() default "";

  Priority priority() default Priority.MEDIUM;

  String createdBy() default "vinh.nguyen";
}
