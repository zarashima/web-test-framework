package listeners;

import com.google.inject.Inject;
import integration.PercyIntegrationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class ClickEventsListener extends AbstractWebDriverEventListener {

	PercyIntegrationManager percyIntegrationManager = new PercyIntegrationManager();

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("before click on");
		if (percyIntegrationManager.isIntegrated())
			percyIntegrationManager.getPercy().snapshot("Before click on");
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("after click on");
		if (percyIntegrationManager.isIntegrated())
			percyIntegrationManager.getPercy().snapshot("After click on");
	}
}
