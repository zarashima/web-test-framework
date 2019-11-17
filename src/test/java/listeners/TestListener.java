package listeners;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.google.inject.Inject;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {


  @Inject
  WebDriver driver;

  @Override
  public synchronized void onTestStart(ITestResult result) {
  }

  @Override
  public synchronized void onTestSuccess(ITestResult result) {

  }

  @Override
  public synchronized void onTestFailure(ITestResult result) {
    ITestContext context = result.getTestContext();
    driver = (WebDriver) context.getAttribute("Webdriver");
    try {
      TakesScreenshot screenshot = (TakesScreenshot) driver;
      String storedImg = String.format("%s.png", System.getProperty("user.dir") + File.separator + "failed-screenshots" + File.separator + createImageName(result));
      File capturedImg = screenshot.getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(capturedImg, new File(storedImg));
      ExtentTestManager.getTest(result).addScreenCaptureFromPath(storedImg);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public synchronized void onTestSkipped(ITestResult result) {

  }

  @Override
  public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {

  }

  @Override
  public synchronized void onTestFailedWithTimeout(ITestResult result) {

  }

  @Override
  public synchronized void onStart(ITestContext context) {

  }

  @Override
  public synchronized void onFinish(ITestContext context) {
    //extent.flush();
  }

  private String createImageName(ITestResult result) {
    return result.getTestClass().getRealClass().getSimpleName()
        + "_"
        + result.getName();
  }
}
