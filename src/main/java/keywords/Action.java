package keywords;

import com.google.inject.Inject;
import ensure.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action {

	@Inject
	WebDriver driver;

	@Inject
	Wait wait;

	Actions builder;

	@Inject
	public Action(WebDriver driver) {
		this.driver = driver;
		wait = new Wait(driver);
		this.builder = new Actions(driver);
	}

	public void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
		builder.dragAndDrop(sourceElement, targetElement).build().perform();
	}

	public void doubleClick() {
		builder.doubleClick().build().perform();
	}

	public void doubleClick(WebElement element) {
		builder.doubleClick(element).build().perform();
	}

	public void moveToElement(WebElement element) {
		builder.moveToElement(element).build().perform();
	}

	public void rightClick() {
		builder.contextClick().perform();
	}
}
