package utils;

import lombok.NonNull;

public class PropertyUtils {
    public void getProperty(@NonNull String propertyName) {
        System.getProperty(propertyName);
    }
}
