import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import factory.ChromeDriverManager;
import factory.DriverManager;
import org.openqa.selenium.WebDriver;

public class DriverModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(DriverManager.class)
                .to(ChromeDriverManager.class)
                .in(Scopes.SINGLETON);
    }

    @Provides
    public WebDriver getDriver(DriverManager driverManager) {
        return driverManager.getDriver();
    }

}
