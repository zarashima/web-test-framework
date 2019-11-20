package ensure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;

public class InternalPageFactory {
  public static <T> void initElements(WebDriver driver, T pageObject)
      throws IllegalAccessException {
    org.openqa.selenium.support.PageFactory.initElements(driver, pageObject);
    for (Field f : pageObject.getClass().getDeclaredFields()) {
      if (f.getType().equals(WebElement.class)) {
        boolean accessible = f.isAccessible();
        f.setAccessible(true);
        f.set(pageObject, ElementGuard.guard((WebElement) f.get(pageObject), driver));
        f.setAccessible(accessible);
      }
    }
  }
}
