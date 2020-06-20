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

	/**
	 * Navigate to a page and wait for page to be loaded
	 * @param url Page URL e,g. https://www.google.com
	 */
	public void goTo(String url) {
		LogUtils.info("Navigate to: " + url);
		driver.get(url);
		wait.waitForPageLoad();
	}

	/**
	 * Maximize current window
	 */
	public void maximizeWindow() {
		LogUtils.info("Maximize browser");
		driver.manage().window().maximize();
	}

	/**
	 * Clear all cookies
	 */
	public void clearCookies() {
		LogUtils.info("Clear all browser cookies");
		driver.manage().deleteAllCookies();
	}

	/**
	 * Get cookies
	 * @return current browser cookies
	 */
	public Set<Cookie> getCookies() {
		LogUtils.info("Get browser cookies");
		return driver.manage().getCookies();
	}

	/**
	 * Set window size
	 * @param width desired window width
	 * @param height desired window height
	 */
	public void setWindowsSize(int width, int height) {
		LogUtils.info("Set windows size");
		if (width == 0 || height == 0) {
			LogUtils.fail("Either width or height is set to 0 which is invalid");
		}
		else {
			driver.manage().window().setSize(new Dimension(width, height));
		}
	}

	/**
	 * Set browser window to full screen
	 */
	public void setFullScreen() {
		LogUtils.info("Set browser window to full screen");
		driver.manage().window().fullscreen();
	}


	/**
	 * Get window position
	 * @return current window position
	 */
	public Point getPosition() {
		LogUtils.info("Get window position");
		return driver.manage().window().getPosition();
	}

	/**
	 * Switch to new window
	 */
	public void switchToNewWindow() {
		LogUtils.info("Switch to new window");
		String parentHandle = driver.getWindowHandle();
		Set<String> allHandles = driver.getWindowHandles();
		for (String handle : allHandles) {
			if (!handle.equals(parentHandle))
				driver.switchTo().window(handle);
		}
	}

	/**
	 * Switch back to default window
	 */
	public void switchBackToDefaultContent() {
		LogUtils.info("Switch back to default content");
		driver.switchTo().defaultContent();
	}

	/**
	 * Refresh the current page
	 */
	public void refresh() {
		LogUtils.info("Refresh window");
		driver.navigate().refresh();
	}

	/**
	 * Pressing the browser’s back button:
	 */
	public void back() {
		LogUtils.info("Press back button on browser");
		driver.navigate().back();
	}

	/**
	 * Pressing the browser’s forward button:
	 */
	public void forward() {
		LogUtils.info("Press back button on browser");
		driver.navigate().forward();
	}

	/**
	 * Get the current page title of the browser
	 * @return page title
	 */
	public String getTitle() {
		LogUtils.info("Get window title");
		return driver.getTitle();
	}
}
