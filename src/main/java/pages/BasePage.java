package pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyUtils;

class BasePage {

  private final WebDriver driver;
  private final WebDriverWait wait;

  @Inject
  BasePage(WebDriver driver) {
    this.wait = new WebDriverWait(driver, PropertyUtils.getInstance().getWebTimeout());
    this.driver = driver;
  }
}