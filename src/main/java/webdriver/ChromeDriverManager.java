package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeDriverManager extends DriverManager {

	public void createDriver(DesiredCapabilities desiredCapabilities) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		String runWhere = System.getenv("RUNWHERE");
		switch (runWhere) {
			case "pipeline":
				chromeOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
				desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				driver = new ChromeDriver(desiredCapabilities);
				break;
			case "container":
				String seleniumHubUrl = System.getenv("HUB_HOST") == null ? "http://localhost:4444/wd/hub" : System.getenv("HUB_HOST");
				chromeOptions.addArguments("--whitelisted-ips");
				chromeOptions.addArguments("--no-sandbox");
				try {
					driver = new RemoteWebDriver(new URL(seleniumHubUrl), chromeOptions);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				break;
			default:
				driver = new ChromeDriver();
				break;
		}
	}
}
