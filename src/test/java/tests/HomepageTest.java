package tests;

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

  @Test(description = "Sample Test")
  public void verifyPurchaseText() {
    browserActions.goTo("https://katalon.com");
    elementActions.click(homePage.addToCartButton);
  }
}