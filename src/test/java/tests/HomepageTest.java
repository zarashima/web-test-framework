package tests;

import capabilities.AndroidCapabilities;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.google.inject.Inject;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

@Listeners({ExtentITestListenerClassAdapter.class, TestListener.class})
public class HomepageTest extends BaseTest {

  @Inject
  HomePage homePage;

  @Test(description = "Test")
  public void verifyPurchaseText() {
    browserKeywords.goTo("https://google.com/");
    elementKeywords.click(homePage.addToCartButton);
  }
}