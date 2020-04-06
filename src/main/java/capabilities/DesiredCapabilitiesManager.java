package capabilities;

import java.util.Map;
import utils.FileUtils;

public class DesiredCapabilitiesManager {

	private DesiredCapabilitiesManager() {}

	protected static Map<String, DesiredCapabilities> loadDesiredCapabilities() {
		return FileUtils.loadDesiredCapabilitiesFile();
  }
}
