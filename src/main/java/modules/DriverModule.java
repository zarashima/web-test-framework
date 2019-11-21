package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import ensure.Ensure;
import webdriver.*;
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
  public WebDriver getDriver() {
    return DriverFactory.getInstance().getDriver();
  }

  @Provides
  public Ensure getEnsure() {
    return new Ensure(DriverFactory.getInstance().getDriver());
  }

}
