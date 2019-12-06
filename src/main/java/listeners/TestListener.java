package listeners;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.google.inject.Inject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import core.driver.WebDriverWrapper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Base64;

import static core.log.Log.log;
import static core.log.Type.*;

public class TestListener implements ITestListener {

  @Inject
  WebDriverWrapper webDriverWrapper;

  @Override
  public synchronized void onTestStart(ITestResult result) {
    log(INFO,"Starting test: " + result.getTestClass().getRealClass().getSimpleName());
  }

  @Override
  public synchronized void onTestSuccess(ITestResult result) {
    log(INFO,"Test is success");
  }

  @Override
  public synchronized void onTestFailure(ITestResult result) {
    log(FAIL, "Failed tests");
    try {
      TakesScreenshot screenshot = (TakesScreenshot) result.getTestContext().getAttribute("WebDriver");
      String base64Src = screenshot.getScreenshotAs(OutputType.BASE64);
      byte[] base64Decoded = Base64.getDecoder().decode(base64Src);
      String storedImg = String.format("%s.png", System.getProperty("user.dir") + File.separator + "failed-screenshots" + File.separator + createImageName(result));
      File targetFile = new File(storedImg);
      BufferedImage image = ImageIO.read(new ByteArrayInputStream(base64Decoded));
      ImageIO.write(image, "png", targetFile);
      ExtentTestManager.getTest(result).addScreenCaptureFromPath(targetFile.getAbsolutePath());
    } catch (IOException e) {
      log(ERROR, e.getMessage());
    }
  }

  @Override
  public synchronized void onTestSkipped(ITestResult result) {
    log(SKIPPED, "Skipped tests");
  }

  @Override
  public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {

  }

  @Override
  public synchronized void onTestFailedWithTimeout(ITestResult result) {
  }

  @Override
  public synchronized void onStart(ITestContext context) {
    log(INFO,"Start tests");
  }

  @Override
  public synchronized void onFinish(ITestContext context) {
    log(INFO,"All tests are finished");
  }

  private String createImageName(ITestResult result) {
    return result.getTestClass().getRealClass().getSimpleName()
        + "_" + result.getName() + "_" + LocalDateTime.now();
  }
}
