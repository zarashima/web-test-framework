package listeners;

import integration.PercyIntegrationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class NavigateEventsListener extends AbstractWebDriverEventListener {

	PercyIntegrationManager percyIntegrationManager = new PercyIntegrationManager();

	@Override
	public void beforeNavigateTo(String s, WebDriver driver) {
		if (percyIntegrationManager.isIntegrated())
			percyIntegrationManager.getPercy().snapshot("Before navigate to");
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		if (percyIntegrationManager.isIntegrated())
			percyIntegrationManager.getPercy().snapshot("After navigate to");
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		if (percyIntegrationManager.isIntegrated())
			percyIntegrationManager.getPercy().snapshot("Before navigate back");
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		if (percyIntegrationManager.isIntegrated())
			percyIntegrationManager.getPercy().snapshot("After navigate back");
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		if (percyIntegrationManager.isIntegrated())
			percyIntegrationManager.getPercy().snapshot("Before navigate forward");
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		if (percyIntegrationManager.isIntegrated())
			percyIntegrationManager.getPercy().snapshot("After navigate forward");
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		if (percyIntegrationManager.isIntegrated())
			percyIntegrationManager.getPercy().snapshot("Before navigate refresh");
	}

	@Override
	public void afterNavigateRefresh(WebDriver webDriver) {
		if (percyIntegrationManager.isIntegrated())
			percyIntegrationManager.getPercy().snapshot("Before navigate refresh");
	}
}
