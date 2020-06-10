package webdriver;

import webdriver.local.LocalDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private DriverFactory() {}

    public static WebDriver createInstance(String browser) {
        WebDriver webdriver;
        webdriver = new LocalDriverManager().createInstance(browser);
        return webdriver;
    }
}
