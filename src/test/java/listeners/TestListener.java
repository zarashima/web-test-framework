package listeners;

import com.aventstack.extentreports.service.ExtentTestManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.LogUtils;
import webdriver.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class TestListener implements ITestListener {

	@Override
	public synchronized void onTestStart(ITestResult result) {
		LogUtils.info("Test is starting");
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		LogUtils.pass("Test is completed and no failure");
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		try {
			String base64StringOfScreenshots;
			TakesScreenshot screenshot = (TakesScreenshot) DriverFactory.getInstance().getDriver();
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(src);
			base64StringOfScreenshots = "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
			ExtentTestManager.getTest(result).addScreenCaptureFromBase64String(base64StringOfScreenshots);
			LogUtils.info("RP_MESSAGE#FILE#{}#{}", src.getAbsoluteFile(), "Screenshot on Failure");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		LogUtils.warn("Test is skipped");
	}

	@Override
	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public synchronized void onStart(ITestContext context) {
	}

	@Override
	public synchronized void onFinish(ITestContext context) {
	}
}
