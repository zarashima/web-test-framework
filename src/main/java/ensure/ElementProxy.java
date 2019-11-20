package ensure;

import modules.DriverModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Guice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Guice(modules = {
        DriverModule.class
})

class ElementProxy implements InvocationHandler {

  private final WebElement element;

  private final WebDriver driver;

  Ensure ensure;

  ElementProxy(WebElement element, WebDriver driver) {
    this.element = element;
    this.driver = driver;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    ensure = new Ensure(driver);
    ensure.with(element)
            .shouldVisible().inView();
    return method.invoke(element, args);
  }
}
