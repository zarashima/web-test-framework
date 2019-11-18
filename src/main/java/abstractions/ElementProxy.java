package abstractions;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static org.awaitility.Awaitility.await;

class ElementProxy implements InvocationHandler {

  private final WebElement element;

  @Inject
  WebDriver driver;

  @Inject
  ElementEnsure elementEnsure;

  ElementProxy(WebElement element) {
    this.element = element;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    ElementEnsure.ensureElementVisible(element);
    return method.invoke(element, args);
  }

}
