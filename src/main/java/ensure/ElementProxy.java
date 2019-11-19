package ensure;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class ElementProxy implements InvocationHandler {

  private final WebElement element;

  @Inject
  WebDriver driver;

  ElementProxy(WebElement element, WebDriver driver) {
    this.element = element;
    this.driver = driver;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    ElementEnsure.ensureElementVisible(element, driver);
    ElementEnsure.ensureElementInView(element, driver);
    return method.invoke(element, args);
  }
}
