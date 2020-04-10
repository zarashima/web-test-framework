package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverManager extends DriverManager {

  public void createDriver(DesiredCapabilities desiredCapabilities) {
    WebDriverManager.chromedriver().setup();
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--no-sandbox");
    chromeOptions.addArguments("--headless");
    chromeOptions.addArguments("--disable-dev-shm-usage");
    desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
    driver = new ChromeDriver(desiredCapabilities);
  }
}
