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

	public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		WebDriver driver = null;
		Object runWhere = ExecutionUtils.getEnv("RUNWHERE");
		if ("pipeline".equals(runWhere)) {
			firefoxOptions.addArguments("--headless");
			firefoxOptions.merge(desiredCapabilities);
			driver = new FirefoxDriver(firefoxOptions);
		} else if ("container".equals(runWhere)) {
			String seleniumHubUrl = ExecutionUtils.getParameter("HUB_HOST");
			firefoxOptions.merge(desiredCapabilities);
			try {
				driver = new RemoteWebDriver(new URL("http://" + seleniumHubUrl + ":4444/wd/hub"), desiredCapabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else {
			driver = new FirefoxDriver(desiredCapabilities);
		}
		return driver;
	}
}
