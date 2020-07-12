package integration;

import io.percy.selenium.Percy;
import properties.ConfigurationManager;
import webdriver.DriverManager;

public class PercyIntegrationManager implements IntegrationManager {

	private static final ThreadLocal<Percy> percy = new ThreadLocal<>();

	@Override
	public boolean isIntegrated() {
		return ConfigurationManager.loadConfiguration().percyIntegration();
	}

	@Override
	public void setupIntegration() {
		if (isIntegrated())
			percy.set(new Percy(DriverManager.getDriver()));
		else
			percy.remove();
	}

	public Percy getPercy() {
		setupIntegration();
		return percy.get();
	}

}
