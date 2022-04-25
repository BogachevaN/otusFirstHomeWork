package configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.String.format;

public final class PropertyManager {
    private static final Properties PROPERTIES;

    static {
        PROPERTIES = new Properties();
        ClassLoader classLoader = PropertyManager.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("application.properties");
        try {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private PropertyManager() {
        throw new UnsupportedOperationException(format("Создание экземпляра класса %s запрещено.",
            PropertyManager.class));
    }

    public static String getProperty(String propertyName) {
        return PROPERTIES.getProperty(propertyName);
    }
}
