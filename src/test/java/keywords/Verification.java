package keywords;

import org.openqa.selenium.WebElement;

public class Verification {

  WebElement element;

  public boolean verifyElementPresent(WebElement element) {
    return element != null;
  }

  public boolean verifyElementDisplayed(WebElement element) {
    return element.isDisplayed();
  }

}