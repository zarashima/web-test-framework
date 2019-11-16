package utils;

import lombok.NonNull;

class PropertyUtils {

  public void getProperty(@NonNull String propertyName) {
    System.getProperty(propertyName);
  }
}
