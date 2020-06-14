package webdriver.local;

import org.openqa.selenium.edge.EdgeDriver;
import webdriver.IDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

public class LocalDriverManager implements IDriver {
    @Override
    public WebDriver createInstance(String browser) {
        WebDriver driver = null;
		DriverManagerType driverManagerType = DriverManagerType.valueOf(browser.toUpperCase());
		WebDriverManager.getInstance(driverManagerType).setup();
		switch(driverManagerType) {
			case CHROME:
				driver = new ChromeDriverManager().createDriver();
				break;
			case FIREFOX:
				driver = new FirefoxDriverManager().createDriver();
				break;
			case EDGE:
				driver = new EdgeDriverManager().createDriver();
				break;
			default:
				throw new IllegalArgumentException("Not supported browser");
		}
		return driver;
    }
}
