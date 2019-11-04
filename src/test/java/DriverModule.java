import com.google.inject.AbstractModule;
import com.google.inject.BindingAnnotation;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.name.Named;
import factory.ChromeDriverManager;
import factory.DriverManager;
import factory.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@BindingAnnotation
@Target({ FIELD, PARAMETER, METHOD }) @Retention(RUNTIME)
@interface Firefox{}

@BindingAnnotation
@Target({ FIELD, PARAMETER, METHOD }) @Retention(RUNTIME)
@interface Chrome{}

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
    }

    @Provides
    public WebDriver getDriver(@Firefox DriverManager driverManager) {
        return driverManager.getDriver();
    }

}
