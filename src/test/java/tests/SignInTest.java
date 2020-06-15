package tests;

import modules.TestInfo;
import modules.TestInfo.Priority;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.PropertyUtils;

@TestInfo(module = "signin",
		priority = Priority.MEDIUM,
		createdBy = "vinh.nguyen")
public class SignInTest extends BaseTest {
	@Test(dataProvider = "sampleData", description = "Verify invalid message is displayed when using invalid email and password")
	public void verifySignIn_invalidEmailPassword_shouldPromptInvalidMessage(String sampleData) {
		browserKeywords.goTo(PropertyUtils.getInstance().getAutHomepage());
		Assert.assertEquals(1,2);
		homePage.goToSignInPage();
		signInPage.signIn("admin", "password");
		verificationKeywords.verifyEqual(signInPage.getErrorMessage(), "Invalid email");
	}

	@DataProvider(name = "sampleData")
	public static Object[][] getSampledata() {
		return new Object[][] {
				{"aaaa"}
		};
	}
}
