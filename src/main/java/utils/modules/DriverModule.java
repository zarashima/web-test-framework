package utils.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import managers.ChromeDriverManager;
import managers.DriverManager;
import managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import java.io.Closeable;

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

        bind(Closeable.class)
                .to(DevTools.class)
                .in(Scopes.SINGLETON);
    }

    @Provides
    public WebDriver getDriver(@Chrome DriverManager driverManager) {
        return driverManager.getDriver();
    }

    @Provides
    public DevTools getDevTools(@Chrome DriverManager driverManager) {
        return ((ChromeDriver) driverManager.getDriver()).getDevTools();
    }
}
