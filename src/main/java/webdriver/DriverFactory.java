package webdriver;

import org.openqa.selenium.WebDriver;
import webdriver.local.LocalDriverManager;

public class DriverFactory {

    private DriverFactory() {}

    public static WebDriver createInstance(String browser) {
        WebDriver driver;
		driver = new LocalDriverManager().createInstance(browser);
        return driver;
    }
}
