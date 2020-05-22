package keywords;

import org.openqa.selenium.WebElement;
import utils.LogUtils;
import utils.WebElementUtils;

public class Verification {

	protected WebElement element;

	public boolean verifyElementDisplayed(WebElement element) {
		LogUtils.info("Verify " + WebElementUtils.getElementXpathInfo(element) + " is displayed");
		return element.isDisplayed();
	}

}
