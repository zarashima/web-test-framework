import factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Guice;

import javax.inject.Inject;

@Guice(modules = {
        DriverModule.class
})

public class BaseTest {

    @Inject @Chrome
    DriverManager driverManager;

    @Inject
    WebDriver driver;

    protected DevTools chromeDevTools;

    @BeforeMethod
    public void beforeMethod() {
        chromeDevTools = ((ChromeDriver)driver).getDevTools();
        chromeDevTools.createSession();
    }


    @AfterMethod
    public void afterMethod() {
        driverManager.quitDriver();
    }

}
