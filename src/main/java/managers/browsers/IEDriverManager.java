package managers.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import managers.DriverManager;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverManager extends DriverManager {
    public void createDriver() {
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
    }
}
