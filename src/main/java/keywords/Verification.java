package keywords;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LogUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class Verification {

	@Inject
	WebDriver driver;

	@Inject
	public Verification(WebDriver driver) {
		this.driver = driver;
	}

	protected WebElement element;

	public void verifyEqual(Object actual, Object expect) {
		LogUtils.info("Verify " + actual + " equal to " + expect);
		assertThat(actual).isEqualTo(expect);
	}

}
