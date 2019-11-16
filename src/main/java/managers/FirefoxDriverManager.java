package managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import managers.DriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {

  public void createDriver() {
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
  }
}
