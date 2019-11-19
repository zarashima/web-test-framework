package ensure;

import com.google.inject.Inject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PropertyUtils;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

class ElementEnsure {

    @Inject
    private ElementEnsure(WebElement element) {
        WebElement element1 = element;
    }

    static void ensureElementVisible(WebElement element, WebDriver driver) {
        await().atMost(PropertyUtils.getInstance().getWebTimeout(), SECONDS)
                .ignoreException(StaleElementReferenceException.class)
                .until(element::isDisplayed);
    }

    static void ensureElementInView(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView", element);
    }
}
