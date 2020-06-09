package thread;

import java.util.Properties;

public class ThreadLocalProperties extends Properties {
	private final ThreadLocal<Properties> localProperties = ThreadLocal.withInitial(Properties::new);

	public ThreadLocalProperties(Properties properties) {
		super(properties);
	}

	@Override
	public String getProperty(String key) {
		String localValue = localProperties.get().getProperty(key);
		return localValue == null ? super.getProperty(key) : localValue;
	}

	@Override
	public Object setProperty(String key, String value) {
		return localProperties.get().setProperty(key, value);
	}
}
