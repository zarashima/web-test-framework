package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import static core.log.Log.log;
import static core.log.Type.INFO;

public class EventsListener extends AbstractWebDriverEventListener {

  private WebElement lastElement;

  @Override
  public void beforeFindBy(By by, WebElement element, WebDriver driver) {
    log(INFO,"Before finding ");
    if (lastElement != null) {
      ((JavascriptExecutor) driver).executeScript(
          "arguments[0].style.border='none'", lastElement);
    }
    lastElement = null;
  }

  @Override
  public void afterFindBy(By by, WebElement element, WebDriver driver) {
    lastElement = element;
    ((JavascriptExecutor) driver).executeScript(
        "arguments[0].style.border='red'", lastElement);
    log(INFO,"After finding ");
  }
}
