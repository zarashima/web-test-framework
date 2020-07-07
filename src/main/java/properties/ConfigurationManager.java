package properties;

import org.aeonbits.owner.ConfigCache;

public class ConfigurationManager {

	private ConfigurationManager() { }

	public static Configuration loadConfiguration() {
		return ConfigCache.getOrCreate(Configuration.class);
	}
}
