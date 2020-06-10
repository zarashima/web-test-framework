package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import ensure.Wait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import webdriver.DriverManager;

public class DriverModule extends AbstractModule {

	@Provides
	public WebDriver getDriver() {
		return DriverManager.getDriver();
	}

	@Provides
	public Wait getWait() {
		return new Wait(DriverManager.getDriver());
	}

	@Provides
	public JavascriptExecutor getJsExecutor() {
		return (JavascriptExecutor) DriverManager.getDriver();
	}

}
