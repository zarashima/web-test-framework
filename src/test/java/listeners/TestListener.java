package listeners;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.google.inject.Inject;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import javax.imageio.ImageIO;

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
      String base64Src = screenshot.getScreenshotAs(OutputType.BASE64);
      byte[] base64Decoded = Base64.getDecoder().decode(base64Src);
      String storedImg = String.format("%s.png", System.getProperty("user.dir") + File.separator + "failed-screenshots" + File.separator + createImageName(result));
      File targetFile = new File(storedImg);
      BufferedImage image = ImageIO.read(new ByteArrayInputStream(base64Decoded));
      ImageIO.write(image, "png", targetFile);
      ExtentTestManager.getTest(result).addScreenCaptureFromPath(targetFile.getAbsolutePath());
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
