package keywords;

import com.google.inject.Inject;
import ensure.Wait;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import utils.LogUtils;

import java.util.Set;

public class Browser {

	@Inject
	WebDriver driver;

	@Inject
	Wait wait;

	@Inject
	public Browser(WebDriver driver) {
		this.driver = driver;
		wait = new Wait(driver);
	}

	public void goTo(String url) {
		LogUtils.info("Navigate to: " + url);
		driver.get(url);
		wait.waitForPageLoad();
	}

	public void maximizeWindow() {
		LogUtils.info("Maximize browser");
		driver.manage().window().maximize();
	}

	public void clearCookies() {
		LogUtils.info("Clear all browser cookies");
		driver.manage().deleteAllCookies();
	}

	public Set<Cookie> getCookies() {
		LogUtils.info("Get browser cookies");
		return driver.manage().getCookies();
	}

	public void setWindowsSize(int width, int height) {
		LogUtils.info("Set windows size");
		if (width == 0 || height == 0) {
			LogUtils.fail("Either width or height is set to 0 which is invalid");
		}
		else {
			driver.manage().window().setSize(new Dimension(width, height));
		}
	}

	public void setFullScreen() {
		LogUtils.info("Set browser windows to full screen");
		driver.manage().window().fullscreen();
	}

	public Point getPosition() {
		LogUtils.info("Set windows size");
		return driver.manage().window().getPosition();
	}

	public void switchToNewWindow() {
		LogUtils.info("Switch to new window");
		String parentHandle = driver.getWindowHandle();
		Set<String> allHandles = driver.getWindowHandles();
		for (String handle : allHandles) {
			if (!handle.equals(parentHandle))
				driver.switchTo().window(handle);
		}
	}

	public void switchBackToDefaultContent() {
		LogUtils.info("Switch back to default content");
		driver.switchTo().defaultContent();
	}
}
