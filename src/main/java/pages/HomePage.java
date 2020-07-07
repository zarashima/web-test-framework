package pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	@FindBy(css = "a[href='/user/signin']")
	private WebElement signInButton;

	@FindBy(css = "div[id='bs-example-navbar-collapse-1'] > ul > li a[href='#']")
	private WebElement userMenuButton;

	@Inject
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public HomePage goToSignInPage() {
		elementKeywords.click(userMenuButton);
		elementKeywords.click(signInButton);
		return this;
	}

}
