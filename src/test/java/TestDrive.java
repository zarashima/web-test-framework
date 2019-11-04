import factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.inject.Inject;

@Guice(modules = {
        DriverModule.class
})

public class TestDrive {
   @Inject @Firefox
   DriverManager driverManager;

   @Inject
   WebDriver driver;

   @AfterMethod
   public void afterMethod() {
       driverManager.quitDriver();
   }

   @Test
   public void homePageTest() {

       // No creation logic for driver instance as it it's covered by Guice
       driver.get("https://another-nodejs-shopping-cart.herokuapp.com/");
       Assert.assertEquals(driver.getTitle(),"Shopping Cart");
   }
}
