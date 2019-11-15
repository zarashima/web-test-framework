package keywords;

import com.google.inject.Inject;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

public class Browser {

    @Inject WebDriver driver;

    public void goTo(String url) {
        checkNotNull(url, "URL address must not be NULL");
        driver.get(url);
    }

    public Set<Cookie> getCookies() {
        return driver.manage().getCookies();
    }

}
