package widget;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;

public class ProductWidget {
    @FindBy(xpath = "/html/body/div/div[2]/div[1]/div/img")
    private WebElement productImage;

    @FindBy(xpath = "/html/body/div/div[2]/div[1]/div/div/h3")
    private WebElement title;

    @Inject
    public ProductWidget(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public String getProductTitle() {
        return title.getText();
    }
}
