package core.driver;

import com.google.inject.Inject;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverWrapper extends EventFiringWebDriver {

    @Inject
    public WebDriverWrapper(WebDriver driver) {
        super(driver);
    }

    @Override
    public Capabilities getCapabilities() {
        return ((HasCapabilities) super.getWrappedDriver()).getCapabilities();
    }

}
