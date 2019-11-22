package pages;

import com.google.inject.Inject;
import ensure.CustomPageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import core.driver.WebDriverWrapper;

public class HomePage extends BasePage {

  @FindBy(xpath = "//*[text()='Get Started']")
  public WebElement addToCartButton;

  @Inject
  public HomePage(WebDriverWrapper driver) throws IllegalAccessException {
    super(driver);
    CustomPageFactory.initElements(driver, this);
  }
}
