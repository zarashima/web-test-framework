package webdriver.local;

import webdriver.IDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

public class LocalDriverManager implements IDriver {
    @Override
    public WebDriver createInstance(String browser) {
        WebDriver driver = null;
		String runWhere = System.getenv("RUNWHERE");
		DriverManagerType driverManagerType = DriverManagerType.valueOf(browser.toUpperCase());
		WebDriverManager.getInstance(driverManagerType).setup();
		switch(driverManagerType) {
			case CHROME:
				driver = new ChromeDriverManager().createDriver();
				break;
			case FIREFOX:
				driver = new FirefoxDriverManager().createDriver();
				break;
			default:
				throw new IllegalArgumentException("Not supported browser");
		}

		//driver = (WebDriver) driverClass.getDeclaredConstructor().newInstance();
			/*ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
			driver = new ChromeDriver(chromeOptions);*/
		return driver;
    }
}
