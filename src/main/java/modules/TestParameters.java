package modules;

import com.google.inject.Inject;
import modules.TestInfo.Priority;

public class TestParameters {
  @Inject
  public TestParameters(Class T) {
    checkTestInfoAnnotation(T);
  }

  private void checkTestInfoAnnotation(Class T)  {
    if (!T.isAnnotationPresent(TestInfo.class)) {
      throw new RuntimeException("The class "
          + T.getSimpleName()
          + " is not annotated with TestInfo");
    }
  }

  public static synchronized String getModule(Class T) {
    return ((TestInfo) T.getAnnotation(TestInfo.class)).module();
  }

  public static synchronized Priority getPriority(Class T) {
    return ((TestInfo) T.getAnnotation(TestInfo.class)).priority();
  }

  public static synchronized String getCreatedBy(Class T) {
    return ((TestInfo) T.getAnnotation(TestInfo.class)).createdBy();
  }

}
