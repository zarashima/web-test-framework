package keywords;

import com.google.inject.Inject;
import ensure.Wait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LogUtils;
import utils.WebElementUtils;

public class Element {

	@Inject
	Wait wait;

	@Inject
	WebDriver driver;

	@Inject
	public Element(WebDriver driver) {
		this.driver = driver;
		wait = new Wait(driver);
	}

	public String getText(WebElement element) {
		wait.waitForElementDisplay(element);
		return element.getText();
	}

	public void setText(WebElement element, String inputText) {
		wait.waitForElementDisplay(element);
		element.clear();
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + inputText + "')", element);
	}

	public void click(WebElement element) {
		LogUtils.info("Click on element: " + WebElementUtils.getElementXpathInfo(element));
		wait.waitForElementDisplay(element);
		wait.waitForElementClickable(element);
		scrollIntoView(element);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public void scrollIntoView(WebElement element) {
		LogUtils.info("Scroll into view of element: " + WebElementUtils.getElementXpathInfo(element));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block:'center', inline: 'center'});", element);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -250);");
	}

	public boolean verifyElementDisplayed(WebElement element) {
		LogUtils.info("Verify " + WebElementUtils.getElementXpathInfo(element) + " is displayed");
		return element.isDisplayed();
	}

}
