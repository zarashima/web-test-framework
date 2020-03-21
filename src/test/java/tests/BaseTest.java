package tests;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.google.inject.Inject;
import keywords.Browser;
import keywords.Element;
import keywords.Verification;
import modules.DriverModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Guice;
import utils.ReportUtils;
import webdriver.DriverFactory;

@Guice(modules = {
        DriverModule.class
})

public class BaseTest {

  @Inject
  WebDriver driver;

  @Inject
  Browser browserKeywords;

  @Inject
  Element elementKeywords;

  @Inject
  Verification verificationKeywords;

  static {
    System.setProperty("extent.reporter.html.out", ReportUtils.getReportFileLocation());
    System.setProperty("extent.reporter.html.start", "true");
    System.setProperty("extent.reporter.html.config", "src/test/resources/html-config.xml");
  }

  @BeforeClass
  public void beforeClass(ITestContext context) {
    context.setAttribute("driver", driver);
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod() {
    ExtentTestManager.getTest().assignCategory(((RemoteWebDriver) driver).getCapabilities().getBrowserName());
    DriverFactory.getInstance().removeDriver();
  }
}
