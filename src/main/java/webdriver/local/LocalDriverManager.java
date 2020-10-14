package webdriver.local;

import org.openqa.selenium.remote.DesiredCapabilities;
import webdriver.IDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

public class LocalDriverManager implements IDriver {
	@Override
	public WebDriver createInstance(String browser, DesiredCapabilities desiredCapabilities) {
		WebDriver driver;
		DriverManagerType driverManagerType = DriverManagerType.valueOf(browser.toUpperCase());
		WebDriverManager.getInstance(driverManagerType).setup();
		switch(driverManagerType) {
			case CHROME:
				driver = new ChromeDriverManager().createDriver(desiredCapabilities);
				break;
			case FIREFOX:
				driver = new FirefoxDriverManager().createDriver(desiredCapabilities);
				break;
			case EDGE:
				driver = new EdgeDriverManager().createDriver(desiredCapabilities);
				break;
			default:
				throw new IllegalArgumentException("Not supported browser");
		}
		return driver;
	}

}
