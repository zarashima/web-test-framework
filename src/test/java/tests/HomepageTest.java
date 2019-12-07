package tests;

import com.google.inject.Inject;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomepageTest extends BaseTest {

  @Inject
  HomePage homePage;

  @Test(description = "Sample Test")
  public void verifyPurchaseText() {
    browserActions.goTo("https://katalon.com");
    elementActions.click(homePage.addToCartButton);
  }
}