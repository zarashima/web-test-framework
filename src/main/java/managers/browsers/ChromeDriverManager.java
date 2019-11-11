package managers.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import managers.DriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {
    public void createDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
}
