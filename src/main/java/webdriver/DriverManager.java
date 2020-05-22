package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public abstract class DriverManager {

	protected WebDriver driver;

	protected abstract void createDriver(DesiredCapabilities desiredCapabilities);

	public WebDriver getDriver(DesiredCapabilities desiredCapabilities) {
		if (null == driver) {
			createDriver(desiredCapabilities);
		}
		return driver;
	}

	public void quitDriver() {
		if (null != driver) {
			driver.quit();
			driver = null;
		}
	}
}
