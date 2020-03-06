package webdriver;

import org.openqa.selenium.WebDriver;
import utils.ExecutionUtils;

public class DriverFactory {

    private static final DriverFactory instance = new DriverFactory();

    private final ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> {
        DriverManager driverManager;
        switch (ExecutionUtils.getParameter("browserName")) {
            case "firefox":
                driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
                break;
            case "chrome":
                driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
                break;
            case "IE":
                driverManager = DriverManagerFactory.getManager(DriverType.IE);
                break;
            default:
                throw new IllegalArgumentException("Not supported browser");
        }
        return driverManager.getDriver();
    });

    private DriverFactory() {

    }

    public static DriverFactory getInstance() {
        return instance;
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void removeDriver() {
        driver.get().quit();
        driver.remove();
    }
}
