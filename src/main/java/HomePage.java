import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;

    @Inject
    public ProductWidget productWidget;

    @Inject
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    ProductWidget getProductWidget() {
        return productWidget;
    }

    void goTo() {
        this.driver.get("https://another-nodejs-shopping-cart.herokuapp.com/");
    }
}
