package ensure;

import com.google.inject.Inject;
import helper.StringConstants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class Wait {

    final WebDriverWait wait;

    @Inject
    WebDriver driver;

    @Inject
    public Wait(WebDriver driver) {
        this.wait = new WebDriverWait(driver, StringConstants.TIMEOUT);
        this.driver = driver;
    }

    public boolean waitForElementVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    public boolean waitForPageLoad() {
        return wait.until((ExpectedCondition<Boolean>) driver -> (
        		(JavascriptExecutor) Objects.requireNonNull(driver)).executeScript("return document.readyState").equals("complete"));
    }

}
