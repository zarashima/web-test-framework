package webdriver.local;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ExecutionUtils;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxDriverManager {

	public WebDriver createDriver() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		WebDriver driver = null;
		Object runWhere = ExecutionUtils.getEnv("RUNWHERE");
		if ("pipeline".equals(runWhere)) {
			firefoxOptions.setHeadless(true);
			desiredCapabilities.merge(firefoxOptions);
			driver = new FirefoxDriver(desiredCapabilities);
		} else if ("container".equals(runWhere)) {
			String seleniumHubUrl = ExecutionUtils.getParameter("HUB_HOST");
			try {
				driver = new RemoteWebDriver(new URL("http://" + seleniumHubUrl + ":4444/wd/hub"), firefoxOptions);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else {
			driver = new FirefoxDriver();
		}
		return driver;
	}
}
