package tests;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.google.inject.Inject;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import webdriver.BrowserModProxyManager;

import java.io.FileOutputStream;
import java.io.IOException;

@Listeners({ExtentITestListenerClassAdapter.class})
public class HomepageTest extends BaseTest {

  @Inject
  HomePage homePage;

  @Test(description = "Test")
  public void testNavigation() throws IOException {
    BrowserModProxyManager.getInstance().getProxy().newHar();
    browserKeywords.goTo("http://katalon.com");
    BrowserModProxyManager.getInstance().getProxy().getHar().writeTo(new FileOutputStream("./test.har"));
    BrowserModProxyManager.getInstance().getProxy().stop();
    verificationKeywords.verifyElementPresent(homePage.addToCartButton);
  }
}