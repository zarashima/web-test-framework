package tests;

import annotations.TestInfo;
import annotations.TestIntegration;
import org.testng.annotations.Test;
import utils.PropertyUtils;

import static annotations.TestIntegration.Event;
import static annotations.TestIntegration.Integration;

@TestInfo(module = "signin",
		priority = TestInfo.Priority.MEDIUM,
		createdBy = "vinh.nguyen")
@TestIntegration(integration = Integration.PERCY, event = Event.NAVIGATION)
public class SignInTest extends BaseTest {
	@Test(description = "Verify invalid message is displayed when using invalid email and password")
	public void verifySignIn_invalidEmail_shouldPromptInvalidMessage() {
		browserKeywords.goTo(PropertyUtils.getInstance().getAutHomepage());
		homePage.goToSignInPage();
		signInPage.signIn("admin", "password");
		verificationKeywords.verifyEqual(signInPage.getErrorMessage(), "Invalid email");
	}
}
