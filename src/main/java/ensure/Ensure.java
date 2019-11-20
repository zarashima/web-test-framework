package ensure;

import com.google.inject.Inject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyUtils;
import static com.google.common.base.Preconditions.checkNotNull;

public class Ensure {

    @Inject
    private WebDriver driver;

    private WebElement element;

    @Inject
    public Ensure(WebDriver driver) {
        this.driver = driver;
    }

    protected Ensure with(WebElement element) {
        checkNotNull(element, "Input element must not be null");
        this.element = element;
        return this;
    }

    protected Ensure shouldVisible() {
        WebDriverWait wait = new WebDriverWait(driver, PropertyUtils.getInstance().getWebTimeout());
        wait.until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    protected Ensure inView() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView", element);
        return this;
    }
}
