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
    private WebDriverWait wait;

    @Inject
    Wait(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, PropertyUtils.getInstance().getWebTimeout());
    }

    public void waitForElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
