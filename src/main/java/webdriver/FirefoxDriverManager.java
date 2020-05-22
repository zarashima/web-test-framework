package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxDriverManager extends DriverManager {

	public void createDriver(DesiredCapabilities desiredCapabilities) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
}
