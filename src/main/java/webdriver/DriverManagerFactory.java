package webdriver;

class DriverManagerFactory {

	private DriverManagerFactory() {}

	public static DriverManager getManager(DriverType type) {
		DriverManager driverManager;
		if (type == DriverType.CHROME) {
			driverManager = new ChromeDriverManager();
		} else {
			driverManager = new FirefoxDriverManager();
		}
		return driverManager;
	}
}
