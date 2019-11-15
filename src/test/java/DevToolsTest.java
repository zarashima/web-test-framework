import keywords.Browser;
import org.openqa.selenium.devtools.Console;
import org.openqa.selenium.devtools.network.Network;
import org.testng.annotations.*;
import reports.ReportListener;

import javax.inject.Inject;

import static com.google.common.truth.Truth.assertThat;

@Listeners({ReportListener.class})
public class DevToolsTest extends BaseTest {
   @Inject
   Browser browserKeywords;

   @Test
   public void clearCookies() {
       devTools.createSession();
       browserKeywords.goTo("https://another-nodejs-shopping-cart.herokuapp.com/");
       assertThat(browserKeywords.getCookies()).isNotEmpty();
       devTools.send(Network.clearBrowserCookies());
       assertThat(browserKeywords.getCookies()).isEmpty();
   }
}