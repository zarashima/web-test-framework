package ensure;

import com.google.inject.Inject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LogUtils;
import utils.PropertyUtils;
import utils.WebElementUtils;

import java.util.List;

public class Wait {

	final WebDriverWait webDriverWait;
	private final String waitPrefix = "Wait for ";

	@Inject
	WebDriver driver;

	@Inject
	public Wait(WebDriver driver) {
		this.webDriverWait = new WebDriverWait(driver, PropertyUtils.getInstance().getWebTimeout());
		this.driver = driver;
	}

	public void waitForElementDisplay(WebElement element) {
		LogUtils.info(waitPrefix + WebElementUtils.getElementXpathInfo(element) + " to display");
		webDriverWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementsDisplay(List<WebElement> elements) {
		LogUtils.info(waitPrefix + WebElementUtils.getElementXpathInfo(elements) + " to display");
		webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	public void waitForElementEnabled(WebElement element) {
		LogUtils.info(waitPrefix + WebElementUtils.getElementXpathInfo(element) + " to be enabled");
		webDriverWait.until(ExpectedConditions.visibilityOf(element)).isEnabled();
	}

	public void waitForElementClickable(WebElement element) {
		LogUtils.info(waitPrefix + WebElementUtils.getElementXpathInfo(element) + " to be clickable");
		webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForPageLoad() {
		LogUtils.info("Wait for page load");
		ExpectedCondition<Boolean> javaScriptLoad = webDriver ->
				((JavascriptExecutor) (webDriver)).executeScript("return document.readyState").equals("complete");
		webDriverWait.until(javaScriptLoad);
	}

	public void waitUntilDisplayIsNone(WebElement element) {
		LogUtils.info("Wait until display is none");
		webDriverWait.until(ExpectedConditions.attributeContains(element, "style", "display: none;"));
	}
}
