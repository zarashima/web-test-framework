package modules;

import annotations.Window;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import webdriver.DriverManager;

public class WindowInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		int index = methodInvocation.getMethod().getDeclaringClass().getAnnotation(Window.class).value();
		this.switchToWindow(index);
		Object object = methodInvocation.proceed();
		this.switchToWindow(0);
		return object;
	}

	private void switchToWindow(int index) {
		String handle = DriverManager.getDriver().getWindowHandles().toArray(new String[0])[index];
		DriverManager.getDriver().switchTo().window(handle);
	}
}
