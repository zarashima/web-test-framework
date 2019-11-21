package ensure;

import com.google.inject.Inject;
import modules.DriverModule;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Guice;
import webdriver.DriverFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Guice(modules = {
        DriverModule.class
})

class ElementProxy implements InvocationHandler {

  private final WebElement element;

  @Inject
  private Ensure ensure;

  ElementProxy(WebElement element) {
    this.element = element;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    ensure = new Ensure(DriverFactory.getInstance().getDriver());
    ensure.with(element)
            .shouldVisible().inView();
    return method.invoke(element, args);
  }
}
