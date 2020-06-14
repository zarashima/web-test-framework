package webdriver.local;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager {

	public WebDriver createDriver() {
		return new EdgeDriver();
	}
}
