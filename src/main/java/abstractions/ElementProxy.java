package abstractions;

import com.google.inject.Inject;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ElementProxy implements InvocationHandler {

    private final WebElement element;
    @Inject private WebDriverWait wait;
    @Inject WebDriver driver;

    ElementProxy(WebElement element) {
        this.element = element;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.waitForElementVisible();
        Object result = method.invoke(element, args);
        return result;
    }

    private void waitForElementVisible() {
        System.out.println("Test");
        /*wait = new WebDriverWait(driver, 30);
        wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOf(element));*/

    }

}
