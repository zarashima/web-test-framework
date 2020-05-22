package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

class HighlighterEventListener extends AbstractWebDriverEventListener {

	private WebElement lastElement;

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.print("before find by");
		if (lastElement != null) {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].style.border='none'", lastElement);
		}
		lastElement = null;
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		lastElement = element;
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].style.border='pink'", lastElement);
		System.out.print("after find by");
	}
}
