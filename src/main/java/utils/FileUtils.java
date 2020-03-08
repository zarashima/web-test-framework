package utils;

import capabilities.DesiredCapabilities;
import capabilities.YamlConfig;
import helper.StringConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class FileUtils {

  public static Map<String, DesiredCapabilities> loadDesiredCapabilitiesFile() {
    Constructor constructor = new Constructor(YamlConfig.class);
    Yaml yaml = new Yaml(constructor);
    InputStream input = null;
    try {
      input = new FileInputStream(new File(StringConstants.YAML_PATH));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    YamlConfig data = yaml.loadAs(input, YamlConfig.class);
    return data.getCapabilities();
  }

}
