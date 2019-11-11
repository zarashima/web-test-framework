package managers;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    WebDriver driver;
    public abstract void createDriver();
    public WebDriver getDriver() {
        if (null == driver) {
            createDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }
}
