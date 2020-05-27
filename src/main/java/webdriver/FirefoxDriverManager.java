package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ExecutionUtils;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxDriverManager extends DriverManager {

	public void createDriver(DesiredCapabilities desiredCapabilities) {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		String runWhere = System.getenv("RUNWHERE");
		switch (runWhere) {
			case "pipeline":
				firefoxOptions.setHeadless(true);
				desiredCapabilities.merge(firefoxOptions);
				driver = new FirefoxDriver(desiredCapabilities);
				break;
			case "container":
				String seleniumHubUrl = ExecutionUtils.getParameter("HUB_HOST");
				try {
					driver = new RemoteWebDriver(new URL("http://" + seleniumHubUrl + ":4444/wd/hub"), firefoxOptions);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				break;
			default:
				driver = new FirefoxDriver();
				break;
		}
	}
}
