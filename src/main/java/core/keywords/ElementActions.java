package core.keywords;

import com.google.inject.Inject;
import org.openqa.selenium.WebElement;
import core.driver.WebDriverWrapper;

public class ElementActions {

  @Inject
  WebDriverWrapper webDriverWrapper;

  public String getText(WebElement element) {
    return element.getText();
  }

  public void click(WebElement element) {
    element.click();
  }
}