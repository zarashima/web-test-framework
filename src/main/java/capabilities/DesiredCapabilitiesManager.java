package capabilities;

import java.util.Map;
import utils.FileUtils;

public class DesiredCapabilitiesManager {

  protected static Map<String, DesiredCapabilities> loadDesiredCapabilities() {
    return FileUtils.loadDesiredCapabilitiesFile();
  }
}
