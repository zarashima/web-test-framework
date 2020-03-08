package capabilities;

import capabilities.DesiredCapabilities;
import java.util.Map;

public class YamlConfig {

  Map<String, DesiredCapabilities> capabilities;

  public Map<String, DesiredCapabilities> getCapabilities() {
    return capabilities;
  }

  public void setCapabilities(Map<String, DesiredCapabilities> capabilities) {
    this.capabilities = capabilities;
  }

}
