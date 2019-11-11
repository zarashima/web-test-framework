package managers;

import managers.browsers.ChromeDriverManager;
import managers.browsers.FirefoxDriverManager;
import managers.browsers.IEDriverManager;

public class DriverManagerFactory {
    public static DriverManager getManager(DriverType type) {
        DriverManager driverManager;
        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            default:
                driverManager = new IEDriverManager();
                break;
        }
        return driverManager;
    }
}
