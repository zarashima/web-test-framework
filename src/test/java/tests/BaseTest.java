package tests;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.google.inject.Inject;
import core.keywords.BrowserActions;
import core.keywords.ElementActions;
import core.driver.DriverModule;
import listeners.TestListener;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Guice;
import org.testng.annotations.Listeners;
import utils.ReportUtils;
import core.driver.DriverFactory;
import core.driver.WebDriverWrapper;

import static utils.StringConstants.SRC_TEST_RESOURCES_HTML_CONFIG_XML;

@Guice(modules = {
        DriverModule.class
})

@Listeners({ExtentITestListenerClassAdapter.class, TestListener.class})
public class BaseTest {

  @Inject
  WebDriverWrapper webDriverWrapper;

  @Inject
  BrowserActions browserActions;

  @Inject
  ElementActions elementActions;

  static {
    System.setProperty("extent.reporter.html.config", SRC_TEST_RESOURCES_HTML_CONFIG_XML);
    System.setProperty("extent.reporter.html.out", ReportUtils.getReportFileLocation());
    System.setProperty("extent.reporter.html.start", "true");
  }

  @BeforeClass()
  public void beforeClass(ITestContext context) {
    context.setAttribute("WebDriver", webDriverWrapper);
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod() {
    ExtentTestManager.getTest().assignCategory(webDriverWrapper.getCapabilities().getBrowserName());
    DriverFactory.getInstance().removeDriver();
  }
}
