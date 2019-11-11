import keywords.Browser;
import org.openqa.selenium.devtools.Console;
import org.openqa.selenium.devtools.network.Network;
import org.testng.annotations.*;
import javax.inject.Inject;

import static com.google.common.truth.Truth.assertThat;

public class DevToolsTest extends BaseTest {

   @Inject
   Browser browser;

   @Test
   public void clearCookies() {
       browser.goTo("https://another-nodejs-shopping-cart.herokuapp.com/");
       assertThat(browser.getCookies()).isNotEmpty();
       devTools.send(Network.clearBrowserCookies());
       assertThat(browser.getCookies()).isEmpty();
   }

    @Test
    public void consoleLogs() {
        browser.goTo("https://another-nodejs-shopping-cart.herokuapp.com/");
        devTools.send(Console.enable());
    }
}