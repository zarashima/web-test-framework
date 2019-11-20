package ensure;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyUtils;

public class Wait {

    @Inject
    private WebDriver driver;

    @Inject
    private static WebDriverWait wait;

    public static void waitForElementVisible(WebElement element, WebDriver driver) {
        wait = new WebDriverWait(driver, PropertyUtils.getInstance().getWebTimeout());
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
