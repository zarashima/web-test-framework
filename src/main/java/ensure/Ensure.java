package ensure;

import com.google.inject.Inject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Ensure {

    @Inject
    private WebDriver driver;

    private final Wait wait;

    private WebElement element;

    @Inject
    public Ensure(WebDriver driver) {
        this.driver = driver;
        this.wait = new Wait(driver);
    }

    protected Ensure with(WebElement element) {
        this.element = element;
        return this;
    }

    protected Ensure shouldVisible() {
        wait.waitForElementVisible(element);
        return this;
    }

    protected Ensure inView() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView", element);
        return this;
    }
}
