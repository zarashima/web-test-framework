package pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

class BasePage {

  @Inject
  private final WebDriver driver;
  private final WebDriverWait wait;

  BasePage(WebDriver driver) {
    this.wait = new WebDriverWait(driver, 30);
    this.driver = driver;
  }
}