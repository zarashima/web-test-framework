import factory.DriverManager;
import module.Chrome;
import module.DriverModule;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.network.Network;
import org.testng.Assert;
import org.testng.annotations.*;
import javax.inject.Inject;

import static com.google.common.truth.Truth.assertThat;

@Guice(modules = {
        DriverModule.class
})

public class HomepageTest extends BaseTest {

   @Inject
   HomePage homePage;

   @Test
   public void homePageTest() {
       homePage.goTo();
       assertThat(driverManager.getDriver().manage().getCookies()).isNotEmpty();
       devTools.send(Network.clearBrowserCookies());
       assertThat(driverManager.getDriver().manage().getCookies()).isEmpty();
       assertThat(homePage.getProductWidget().getProductTitle())
               .isEqualTo( "Rerum cupiditate est modi asperiores dolore aut omnis aut.");
   }
}
