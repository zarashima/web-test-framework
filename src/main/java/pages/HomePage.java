package pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import widget.ProductWidget;

public class HomePage {
    private final WebDriver driver;

    @Inject
    public ProductWidget productWidget;

    @Inject
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductWidget getProductWidget() {
        return productWidget;
    }
}
