package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEDriverManager extends DriverManager {

	public void createDriver(DesiredCapabilities desiredCapabilities) {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
	}
}
