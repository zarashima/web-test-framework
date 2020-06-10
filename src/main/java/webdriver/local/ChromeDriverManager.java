package webdriver.local;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ExecutionUtils;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeDriverManager {

	public WebDriver createDriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		WebDriver driver = null;
		Object runWhere = ExecutionUtils.getEnv("RUNWHERE");
		if ("pipeline".equals(runWhere)) {
			chromeOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
			desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			driver = new ChromeDriver(desiredCapabilities);
		} else if ("container".equals(runWhere)) {
			String seleniumHubUrl = ExecutionUtils.getParameter("HUB_HOST");
			chromeOptions.addArguments("--whitelisted-ips", "--no-sandbox");
			try {
				driver = new RemoteWebDriver(new URL("http://" + seleniumHubUrl + ":4444/wd/hub"), chromeOptions);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else {
			driver = new ChromeDriver();
		}
		return driver;
	}
}
