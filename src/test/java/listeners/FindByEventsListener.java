package listeners;

import com.google.inject.Inject;
import integration.PercyIntegrationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class FindByEventsListener extends AbstractWebDriverEventListener {

	PercyIntegrationManager percyIntegrationManager = new PercyIntegrationManager();

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		if (percyIntegrationManager.isIntegrated())
			percyIntegrationManager.getPercy().snapshot("Before Find By");
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		if (percyIntegrationManager.isIntegrated())
			percyIntegrationManager.getPercy().snapshot("After Find By");
	}
}
