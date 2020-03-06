package keywords;

import com.google.inject.Inject;
import ensure.Wait;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class Browser {

  @Inject
  WebDriver driver;

  @Inject
  Wait wait;

  public void goTo(String url) {
    driver.get(url);
    wait.waitForPageLoad();
  }

  public Set<Cookie> getCookies() {
    return driver.manage().getCookies();
  }

}
