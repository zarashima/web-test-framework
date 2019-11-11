import managers.DriverManager;
import modules.Chrome;
import modules.DriverModule;
import org.openqa.selenium.WebDriver;
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

    @Inject
    DevTools devTools;

    @BeforeMethod
    public void beforeMethod() {
        devTools.createSession();
    }

    @AfterMethod
    public void afterMethod() {
        driverManager.quitDriver();
    }
}
