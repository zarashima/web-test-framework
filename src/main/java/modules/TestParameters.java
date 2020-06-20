package modules;

import annotations.TestInfo;
import annotations.TestInfo.Priority;

public class TestParameters {

  private static synchronized void checkTestInfoAnnotation(Class T) {
    if (!T.isAnnotationPresent(TestInfo.class)) {
      throw new RuntimeException("The class "
          + T.getSimpleName()
          + " is not annotated with TestInfo");
    }
  }

  public static synchronized String getModule(Class T) {
  	checkTestInfoAnnotation(T);
    return ((TestInfo) T.getAnnotation(TestInfo.class)).module();
  }

  public static synchronized Priority getPriority(Class T) {
	  checkTestInfoAnnotation(T);
	  return ((TestInfo) T.getAnnotation(TestInfo.class)).priority();
  }

  public static synchronized String getCreatedBy(Class T) {
	  checkTestInfoAnnotation(T);
	  return ((TestInfo) T.getAnnotation(TestInfo.class)).createdBy();
  }

}
