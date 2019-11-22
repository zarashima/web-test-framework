package pages;

import com.google.inject.Inject;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyUtils;
import core.driver.WebDriverWrapper;

class BasePage {

  private final WebDriverWait wait;

  @Inject
  WebDriverWrapper webDriverWrapper;

  @Inject
  BasePage(WebDriverWrapper driver) {
    this.wait = new WebDriverWait(driver, PropertyUtils.getInstance().getWebTimeout());
    this.webDriverWrapper = driver;
  }
}