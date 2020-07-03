package pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage {

	@FindBy(css = "input[id='email']")
	private WebElement emailField;

	@FindBy(css = "input[id='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signInButton;

	@FindBy(css = "div[class='alert alert-danger']")
	private WebElement errorMessageDiv;

	@Inject
	public SignInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public SignInPage signInWith(String email, String password) {
		elementKeywords.setText(emailField, email);
		elementKeywords.setText(passwordField, password);
		elementKeywords.click(signInButton);
		return this;
	}

	public String getErrorMessage() {
		return elementKeywords.getText(errorMessageDiv);
	}
}
