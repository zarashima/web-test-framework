package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import ensure.Ensure;
import managers.ChromeDriverManager;
import managers.DriverManager;
import managers.FirefoxDriverManager;
import managers.IEDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(DriverManager.class)
        .annotatedWith(Firefox.class)
        .to(FirefoxDriverManager.class)
        .in(Scopes.SINGLETON);

    bind(DriverManager.class)
        .annotatedWith(Chrome.class)
        .to(ChromeDriverManager.class)
        .in(Scopes.SINGLETON);

    bind(DriverManager.class)
        .annotatedWith(InternetExplorer.class)
        .to(IEDriverManager.class)
        .in(Scopes.SINGLETON);
  }

  @Provides
  public WebDriver getDriver(@Chrome DriverManager driverManager) {
    return driverManager.getDriver();
  }

  @Provides
  public Ensure getEnsure(@Chrome DriverManager driverManager) {
    return new Ensure(driverManager.getDriver());
  }
}
