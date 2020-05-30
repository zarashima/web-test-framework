package listeners;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.google.inject.Inject;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import status.ResultsSender;
import status.TestStatus;
import utils.ExecutionUtils;
import utils.PropertyUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Objects;

public class TestListener implements ITestListener {

	@Inject
	WebDriver driver;

	TestStatus testStatus;

	@Override
	public synchronized void onTestStart(ITestResult result) {
		this.testStatus = new TestStatus();
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		this.sendStatus(result,"PASS");
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		this.sendStatus(result,"FAIL");
		ITestContext context = Objects.requireNonNull(result).getTestContext();
		driver = (WebDriver) context.getAttribute("driver");
		try {
			String base64StringOfScreenshots;
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(src);
			base64StringOfScreenshots = "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
			ExtentTestManager.getTest(result).addScreenCaptureFromBase64String(base64StringOfScreenshots);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		this.sendStatus(result,"SKIPPED");
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

	private void sendStatus(ITestResult iTestResult, String status) {
		this.testStatus.setTestClass(iTestResult.getTestClass().getTestName());
		this.testStatus.setDescription(iTestResult.getMethod().getDescription());
		this.testStatus.setStatus(status);
		this.testStatus.setExecutionDate(LocalDateTime.now().toString());
		if (!status.equals("PASSED"))
			this.testStatus.setStatusMessage(iTestResult.getThrowable().getMessage());
		if (ExecutionUtils.getParameter("kibana.integration").equals("true"))
			ResultsSender.send(this.testStatus);
	}
}
