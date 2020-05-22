package pages;

import com.google.inject.Inject;
import keywords.Browser;
import keywords.Element;
import org.openqa.selenium.WebDriver;

public class BasePage {

	@Inject
	protected Browser browserKeywords;

	@Inject
	protected Element elementKeywords;

	@Inject
	protected WebDriver driver;

	@Inject
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
}
