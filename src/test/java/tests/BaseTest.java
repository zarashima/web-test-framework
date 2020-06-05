package tests;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.google.inject.Inject;
import ensure.Wait;
import keywords.Browser;
import keywords.Element;
import keywords.Verification;
import modules.DriverModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import pages.SignInPage;
import reportportal.Launch;
import reportportal.LaunchHandler;
import reportportal.SessionContext;
import utils.ExecutionUtils;
import utils.ReportUtils;
import webdriver.DriverFactory;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Inject
	HomePage homePage;

	@Inject
	SignInPage signInPage;

	@Inject
	Wait wait;

	@Inject
	Launch launch;

	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("extent.reporter.html.out", ReportUtils.getReportFileLocation());
		System.setProperty("extent.reporter.html.start", "true");
		System.setProperty("extent.reporter.html.config", "src"
				+ File.separator + "test"
				+ File.separator + "resources"
				+ File.separator + "html-config.xml");
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult iTestResult) {
		String browserDetails = ((RemoteWebDriver) driver).getCapabilities().getBrowserName() + "_" +
				((RemoteWebDriver) driver).getCapabilities().getVersion();
		launch.setAttributes("browser", browserDetails);
		if (SessionContext.getRpEnable())
			LaunchHandler.updateLaunch(launch.getAttributes(), iTestResult.getMethod().getDescription());
		ExtentTestManager.getTest().assignCategory(browserDetails);
	}

	@AfterTest
	public void afterTest() {
		DriverFactory.getInstance().removeDriver();
	}
}
