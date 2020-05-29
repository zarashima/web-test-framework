package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.ExecutionUtils;

public class DriverFactory {

	private static final DriverFactory instance = new DriverFactory();

	private DriverFactory() {

	}

	private final ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> {
		DriverManager driverManager;
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		switch (ExecutionUtils.getParameter("browserName")) {
			case "firefox":
				driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
				break;
			case "chrome":
				driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
				break;
			default:
				throw new IllegalArgumentException("Not supported browser");
		}
		return driverManager.getDriver(desiredCapabilities);
	});

	public static DriverFactory getInstance() {
		return instance;
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	public void removeDriver() {
		driver.get().quit();
		driver.remove();
	}
}
