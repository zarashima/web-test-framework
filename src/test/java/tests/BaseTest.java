package tests;

import com.aventstack.extentreports.service.ExtentTestManager;
import keywords.Browser;
import keywords.Element;
import managers.DriverManager;
import modules.Chrome;
import modules.DriverModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Guice;
import javax.inject.Inject;
import utils.ReportUtils;

@Guice(modules = {
    DriverModule.class
})

public class BaseTest {

  @Inject
  @Chrome
  DriverManager driverManager;
  @Inject
  WebDriver driver;
  @Inject
  DevTools devTools;
  @Inject
  Browser browserKeywords;
  @Inject
  Element elementKeywords;

  static {
    System.setProperty("extent.reporter.html.out", ReportUtils.getReportFileLocation());
    System.setProperty("extent.reporter.html.start", "true");
    System.setProperty("extent.reporter.html.config", "src/test/resources/html-config.xml");
  }

  @BeforeClass
  public void beforeClass(ITestContext context) {
    context.setAttribute("Webdriver", driver);
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod() {
    ExtentTestManager.getTest().assignCategory(((RemoteWebDriver) driver).getCapabilities().getBrowserName());
    driverManager.quitDriver();
  }
}
