package listeners;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import webdriver.DriverManager;
import webdriver.local.MyEventFiringWebDriver;

import static annotations.TestIntegration.Event;

public class ListenersManager {

	private WebDriver driver;

	@Inject
	public ListenersManager(WebDriver driver) {
		this.driver = driver;
	}

	public void registerEvent(Event event) {
		MyEventFiringWebDriver eventDriver = new MyEventFiringWebDriver((RemoteWebDriver) driver);
		switch (event) {
			case NAVIGATION:
				eventDriver.register(new NavigateEventsListener());
				break;
			default:
				break;
		}
		DriverManager.setDriver(eventDriver);
	}
}
