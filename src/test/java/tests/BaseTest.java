package tests;

import com.epam.reportportal.annotations.attribute.Attribute;
import com.epam.reportportal.annotations.attribute.Attributes;
import com.epam.reportportal.service.ReportPortal;
import com.epam.reportportal.service.tree.ItemTreeReporter;
import com.epam.reportportal.service.tree.TestItemTree;
import com.epam.reportportal.testng.TestNGService;
import com.epam.reportportal.testng.util.ItemTreeUtils;
import com.epam.ta.reportportal.ws.model.FinishExecutionRQ;
import com.epam.ta.reportportal.ws.model.FinishTestItemRQ;
import com.epam.ta.reportportal.ws.model.attribute.ItemAttributesRQ;
import com.epam.ta.reportportal.ws.model.launch.FinishLaunchRS;
import com.epam.ta.reportportal.ws.model.launch.StartLaunchRQ;
import com.epam.ta.reportportal.ws.model.launch.StartLaunchRS;
import com.google.inject.Guice;
import com.google.inject.Injector;
import extentreports.ExtentTestManager;
import org.testng.collections.Sets;
import rp.com.google.common.base.Optional;
import keywords.Browser;
import keywords.Element;
import keywords.Verification;
import modules.DriverModule;
import modules.TestParameters;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import pages.SignInPage;
import reportportal.Launch;
import reportportal.LaunchHandler;
import reportportal.SessionContext;
import webdriver.DriverFactory;
import webdriver.DriverManager;
import static com.epam.reportportal.testng.TestNGService.ITEM_TREE;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class BaseTest {

	protected WebDriver driver;
	protected Browser browserKeywords;
	protected Element elementKeywords;
	protected Verification verificationKeywords;
	protected HomePage homePage;
	protected SignInPage signInPage;
	protected Launch launch;

	@BeforeTest
	@Parameters({"runWhere", "browserName"})
	@Attributes(attributes = { @Attribute(key = "key", value = "value") })
	public void beforeTest(String runWhere, String browserName) {
		Injector injector = Guice.createInjector(new DriverModule());
		driver = DriverFactory.createInstance(runWhere, browserName, new DesiredCapabilities());
		DriverManager.setDriver(driver);
		homePage = injector.getInstance(HomePage.class);
		signInPage = injector.getInstance(SignInPage.class);
		browserKeywords = injector.getInstance(Browser.class);
		elementKeywords = injector.getInstance(Element.class);
		verificationKeywords = injector.getInstance(Verification.class);
		launch = injector.getInstance(Launch.class);
	}

	@AfterMethod()
	public void afterMethod(ITestResult testResult) {
		if (SessionContext.getRpEnable()) {
			ItemTreeUtils.retrieveLeaf(testResult, ITEM_TREE).ifPresent(testResultLeaf -> {
				sendFinishRequest(testResultLeaf, testResult);
			});
		}
		ExtentTestManager.getTest().assignCategory(DriverManager.getBrowserName());
	}

	@AfterTest
	public void afterTest() {
		DriverManager.quit();
	}

	private void sendFinishRequest(TestItemTree.TestItemLeaf testResultLeaf, ITestResult testResult) {
		FinishTestItemRQ finishTestItemRQ = new FinishTestItemRQ();
		Set<ItemAttributesRQ> attributes = Optional.fromNullable(finishTestItemRQ.getAttributes())
				.or(Sets.newHashSet(new ItemAttributesRQ("browser", DriverManager.getBrowserName())));
		finishTestItemRQ.setAttributes(attributes);
		finishTestItemRQ.setStatus(testResult.isSuccess() ? "PASSED" : "FAILED");
		finishTestItemRQ.setDescription(testResult.getMethod().getDescription());
		finishTestItemRQ.setEndTime(Calendar.getInstance().getTime());
		ItemTreeReporter.finishItem(TestNGService.getReportPortal().getClient(), finishTestItemRQ, ITEM_TREE.getLaunchId(), testResultLeaf)
				.cache()
				.blockingGet();
	}
}
