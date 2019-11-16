package abstractions;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

class ElementProxy implements InvocationHandler {

  private final WebElement element;
  @Inject
  private WebDriverWait wait;
  @Inject
  WebDriver driver;

  ElementProxy(WebElement element) {
    this.element = element;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    this.waitForElementDisplay();
    return method.invoke(element, args);
  }

  private void waitForElementDisplay() {
    await().atMost(30, SECONDS).until(element::isDisplayed);
  }

}
