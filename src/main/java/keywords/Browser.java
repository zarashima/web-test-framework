package keywords;

import com.google.inject.Inject;
import ensure.Wait;
import org.openqa.selenium.Cookie;
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

}
