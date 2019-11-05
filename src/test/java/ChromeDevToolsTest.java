import com.google.common.truth.Truth;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.network.Network;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class ChromeDevToolsTest extends BaseTest {
   @Test(description = "Verify current cookies are cleared")
   public void verifyCookiesAreEmpty() {
       driver.get("https://another-nodejs-shopping-cart.herokuapp.com/");
       assertThat(driver.manage().getCookies()).isNotEmpty();
       chromeDevTools = ((ChromeDriver)driver).getDevTools();
       chromeDevTools.createSession();
       chromeDevTools.send(Network.clearBrowserCookies());
       assertThat(driver.manage().getCookies()).isEmpty();
   }

}
