package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverManager extends DriverManager {

  public void createDriver() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions chromeOptions = new ChromeOptions();
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    chromeOptions.addArguments("--ignore-certificate-errors");
    desiredCapabilities.setCapability(CapabilityType.PROXY, ClientUtil.createSeleniumProxy(BrowserModProxyManager.getInstance().getProxy()));
    desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
    driver = new ChromeDriver(desiredCapabilities);
  }
}
