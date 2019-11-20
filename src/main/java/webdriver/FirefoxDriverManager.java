package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {

  public void createDriver() {
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
  }
}
