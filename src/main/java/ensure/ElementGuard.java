package ensure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.lang.reflect.Proxy;

class ElementGuard {
  protected static WebElement guard(WebElement element, WebDriver driver) {
    ElementProxy proxy = new ElementProxy(element, driver);
    return (WebElement) Proxy.newProxyInstance(ElementProxy.class.getClassLoader(),
        new Class[]{WebElement.class}, proxy);
  }
}