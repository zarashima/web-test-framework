package webdriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import webdriver.local.LocalDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private DriverFactory() {}

    public static WebDriver createInstance(String browser, DesiredCapabilities desiredCapabilities) {
        WebDriver webdriver;
        webdriver = new LocalDriverManager().createInstance(browser, desiredCapabilities);
        return webdriver;
    }
}
