package core.keywords;

import com.google.inject.Inject;
import org.openqa.selenium.Cookie;
import core.driver.WebDriverWrapper;

import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

public class BrowserActions {

  @Inject
  WebDriverWrapper webDriverWrapper;

  public void goTo(String url) {
    checkNotNull(url, "URL address must not be NULL");
    webDriverWrapper.get(url);
  }

  public Set<Cookie> getCookies() {
    return webDriverWrapper.manage().getCookies();
  }

}
