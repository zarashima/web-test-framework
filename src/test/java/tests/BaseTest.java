package tests;

import com.google.inject.Guice;
import com.google.inject.Injector;
import extentreports.ExtentTestManager;
import keywords.Browser;
import keywords.Element;
import keywords.Verification;
import listeners.ListenersManager;
import modules.DriverModule;
import modules.TestParameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.HomePage;
import pages.SignInPage;
import properties.ConfigurationManager;
import reportportal.Launch;
import reportportal.LaunchHandler;
import webdriver.DriverFactory;
import webdriver.DriverManager;
import webdriver.local.MyEventFiringWebDriver;

import static annotations.TestIntegration.Event;

public class BaseTest {

	protected WebDriver driver;
	protected Browser browserKeywords;
	protected Element elementKeywords;
	protected Verification verificationKeywords;
	protected HomePage homePage;
	protected SignInPage signInPage;
	protected Launch launch;
	protected static String browsers = "";
	ListenersManager listenersManager;

	@BeforeMethod
	@Parameters({"browserName"})
	public void beforeMethod(String browserName, ITestResult iTestResult) {
		Injector injector = Guice.createInjector(new DriverModule());
		driver = DriverFactory.createInstance(browserName);
		listenersManager = new ListenersManager(driver);
		listenersManager.registerEvent(Event.NAVIGATION);
		homePage = injector.getInstance(HomePage.class);
		signInPage = injector.getInstance(SignInPage.class);
		browserKeywords = injector.getInstance(Browser.class);
		elementKeywords = injector.getInstance(Element.class);
		verificationKeywords = injector.getInstance(Verification.class);
		launch = injector.getInstance(Launch.class);
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult iTestResult) {
		browsers = browsers + DriverManager.getBrowserName() + "_";
		Class<?> clazz = iTestResult.getTestClass().getRealClass();
		if (ConfigurationManager.loadConfiguration().rpIntegration())
		{
			launch.setAttributes("browser", browsers);
			launch.setAttributes("module", TestParameters.getModule(clazz));
			launch.setAttributes("priority", TestParameters.getPriority(clazz).name());
			launch.setAttributes("createdBy", TestParameters.getCreatedBy(clazz));
			LaunchHandler.updateLaunch(launch.getAttributes(), iTestResult.getMethod().getDescription());
		}
		ExtentTestManager.getTest().assignCategory(DriverManager.getBrowserName());
		DriverManager.quit();
	}
}
