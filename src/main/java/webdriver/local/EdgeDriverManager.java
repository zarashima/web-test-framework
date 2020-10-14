package webdriver.local;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class EdgeDriverManager {

	public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
		return new EdgeDriver();
	}
}
