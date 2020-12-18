package tests;

import com.epam.reportportal.service.tree.ItemTreeReporter;
import com.epam.reportportal.service.tree.TestItemTree;
import com.epam.reportportal.testng.TestNGService;
import com.epam.reportportal.testng.util.ItemTreeUtils;
import com.epam.ta.reportportal.ws.model.FinishTestItemRQ;
import com.epam.ta.reportportal.ws.model.attribute.ItemAttributesRQ;
import com.google.inject.Guice;
import com.google.inject.Injector;
import extentreports.ExtentTestManager;
import keywords.Browser;
import keywords.Element;
import keywords.Verification;
import modules.DriverModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.collections.Sets;
import pages.HomePage;
import pages.SignInPage;
import reportportal.Launch;
import reportportal.SessionContext;
import rp.com.google.common.base.Optional;
import webdriver.DriverFactory;
import webdriver.DriverManager;

import java.util.Calendar;
import java.util.Set;

import static com.epam.reportportal.testng.TestNGService.ITEM_TREE;

public class BaseTest {

	protected WebDriver driver;
	protected Browser browserKeywords;
	protected Element elementKeywords;
	protected Verification verificationKeywords;
	protected HomePage homePage;
	protected SignInPage signInPage;
	protected Launch launch;

	@BeforeTest
	@Parameters({"browserName"})
	public void beforeTest(String browserName) {
		Injector injector = Guice.createInjector(new DriverModule());
		driver = DriverFactory.createInstance(browserName, new DesiredCapabilities());
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
