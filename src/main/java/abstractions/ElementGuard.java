package abstractions;

import org.openqa.selenium.WebElement;
import java.lang.reflect.Proxy;

class ElementGuard {

  static WebElement guard(WebElement element) {
    ElementProxy proxy = new ElementProxy(element);
    return (WebElement) Proxy.newProxyInstance(ElementProxy.class.getClassLoader(),
        new Class[]{WebElement.class}, proxy);
  }
}
