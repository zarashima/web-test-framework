package tests;

import keywords.Browser;
import keywords.Element;
import managers.DriverManager;
import modules.Chrome;
import modules.DriverModule;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Guice;
import javax.inject.Inject;

@Guice(modules = {
    DriverModule.class
})

public class BaseTest {

  @Inject
  @Chrome
  DriverManager driverManager;
  @Inject
  DevTools devTools;
  @Inject
  Browser browserKeywords;
  @Inject
  Element elementKeywords;

  @AfterMethod
  public void afterMethod() {
    driverManager.quitDriver();
  }
}
