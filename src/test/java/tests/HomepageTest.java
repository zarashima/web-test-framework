package tests;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.google.inject.Inject;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

import static com.google.common.truth.Truth.assertThat;

@Listeners({ExtentITestListenerClassAdapter.class, TestListener.class})
public class HomepageTest extends BaseTest {

  @Inject
  HomePage homePage;

  @Test(description = "Test")
  public void verifyPurchaseText() {
    driver.get("https://katalon.com");
    //assertThat(elementKeywords.getText(homePage.addToCartButton)).isEqualTo("Add to cart");
    //HomePage homePage = new HomePage(driver);
    homePage.addToCartButton.click();
  }
}