package tests;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.google.inject.Guice;
import com.google.inject.Injector;
import webdriver.DriverManager;
import keywords.Browser;
import keywords.Element;
import keywords.Verification;
import modules.DriverModule;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import pages.SignInPage;
import reportportal.Launch;
import reportportal.LaunchHandler;
import reportportal.SessionContext;
import utils.ReportUtils;

import java.io.File;

public class BaseTest {

	WebDriver driver;
	Browser browserKeywords;
	Element elementKeywords;
	Verification verificationKeywords;
	HomePage homePage;
	SignInPage signInPage;
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

	@BeforeTest
	@Parameters({"browserName"})
	public void beforeTest(String browserName) {
		Injector injector = Guice.createInjector(new DriverModule());
		driver = webdriver.DriverFactory.createInstance(browserName);
		DriverManager.setDriver(driver);
		homePage = injector.getInstance(HomePage.class);
		signInPage = injector.getInstance(SignInPage.class);
		browserKeywords = injector.getInstance(Browser.class);
		elementKeywords = injector.getInstance(Element.class);
		verificationKeywords = injector.getInstance(Verification.class);
		launch = injector.getInstance(Launch.class);
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult iTestResult) {
		System.out.println(DriverManager.getInfo());
		launch.setAttributes("browser", DriverManager.getInfo());
		if (SessionContext.getRpEnable())
			LaunchHandler.updateLaunch(launch.getAttributes(), iTestResult.getMethod().getDescription());
		ExtentTestManager.getTest().assignCategory(DriverManager.getInfo());
	}

	@AfterTest
	public void afterTest() {
		DriverManager.quit();
	}
}
