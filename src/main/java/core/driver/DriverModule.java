package core.driver;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import listeners.EventsListener;
import org.openqa.selenium.WebDriver;

public class DriverModule extends AbstractModule {

  @Provides
  public WebDriver getDriver() {
    return DriverFactory.getInstance().getDriver();
  }

  @Provides
  public ExtentTestManager getExtentTestManager() {
    return new ExtentTestManager();
  }

  @Provides
  public WebDriverWrapper getDriverWrapper() {
    return (WebDriverWrapper) new WebDriverWrapper(DriverFactory.getInstance()
            .getDriver())
            .register(new EventsListener());
  }

}
