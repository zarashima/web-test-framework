package keywords;

import com.google.inject.Inject;
import ensure.Wait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.LogUtils;

import static utils.WebElementUtils.*;

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
		LogUtils.info("Get text from: " + getElementXpathInfo(element));
		wait.waitForElementDisplay(element);
		return element.getText();
	}

	public void setText(WebElement element, String inputText) {
		LogUtils.info("Set text to: " + getElementXpathInfo(element));
		wait.waitForElementDisplay(element);
		element.clear();
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + inputText + "')", element);
	}

	public void click(WebElement element) {
		LogUtils.info("Click on: " + getElementXpathInfo(element));
		wait.waitForElementDisplay(element);
		wait.waitForElementClickable(element);
		scrollIntoView(element);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public void doubleClick(WebElement element) {
		LogUtils.info("Double click on element: " + getElementXpathInfo(element));
		new Actions(driver).doubleClick(element).perform();
	}

	public void moveToElement(WebElement element) {
		LogUtils.info("Move to element: " + getElementXpathInfo(element));
		new Actions(driver).moveToElement(element).perform();
	}

	public void dragAndDrop(WebElement sourceElement, WebElement destElement) {
		LogUtils.info("Drag and drop from: "
				+ getElementXpathInfo(sourceElement) + "to: " + getElementXpathInfo(destElement));
		new Actions(driver).dragAndDrop(sourceElement, destElement).perform();
	}

	public void scrollIntoView(WebElement element) {
		LogUtils.info("Scroll into view of element: " + getElementXpathInfo(element));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block:'center', inline: 'center'});", element);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -250);");
	}

	public boolean verifyElementDisplayed(WebElement element) {
		LogUtils.info("Verify " + getElementXpathInfo(element) + " is displayed");
		return element.isDisplayed();
	}

}
