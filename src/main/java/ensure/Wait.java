package ensure;

import com.google.inject.Inject;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    final WebDriverWait wait;

    @Inject
    WebDriver driver;

    @Inject
    public Wait(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 30);
        this.driver = driver;
    }

    public boolean waitForElementVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    public boolean waitForPageLoad() {
        return wait.until((ExpectedCondition<Boolean>) driver -> {
            if (driver != null) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
            else {
                throw new NullPointerException("NPE");
            }
        });
    }

}
