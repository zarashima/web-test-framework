package ensure;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebElement;
import java.lang.reflect.Proxy;

class ElementGuard {

  private ElementGuard() {
    throw new IllegalArgumentException("Element Guard class");
  }

  @NotNull
  protected static WebElement guard(WebElement element) {
    ElementProxy proxy = new ElementProxy(element);
    return (WebElement) Proxy.newProxyInstance(ElementProxy.class.getClassLoader(),
        new Class[]{WebElement.class}, proxy);
  }
}