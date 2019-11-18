package abstractions;

import com.google.inject.Inject;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utils.PropertyUtils;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

class ElementEnsure {

    private WebElement element;

    @Inject
    private ElementEnsure(WebElement element) {
        this.element = element;
    }

    static void ensureElementVisible(WebElement element) {
        await().atMost(Long.valueOf(PropertyUtils.getInstance().getWebTimeout()), SECONDS)
                .ignoreException(StaleElementReferenceException.class)
                .until(element::isDisplayed);
    }
}
