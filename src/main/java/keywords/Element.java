package keywords;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Element {
    @Inject WebDriver driver;

    public String getText(WebElement element) {
        return element.getText();
    }

    public void click(WebElement element) {
        element.click();
    }
}