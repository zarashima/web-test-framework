package modules;

import annotations.Window;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.matcher.Matchers;
import ensure.Wait;
import org.aopalliance.intercept.MethodInterceptor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import webdriver.DriverManager;

public class DriverModule extends AbstractModule {

	@Override
	protected void configure() {
		MethodInterceptor interceptor = new WindowInterceptor();
		requestInjection(interceptor);
		bindInterceptor(Matchers.annotatedWith(Window.class), Matchers.any(), interceptor);
	}

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
