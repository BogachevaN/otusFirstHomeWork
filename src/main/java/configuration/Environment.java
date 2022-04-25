package configuration;

import static configuration.PropertyManager.getProperty;

public class Environment {
	private static String DRIVER_TYPE = System.getProperty("browser");
	private static String BASE_URL = System.getProperty("base.url");

	static{
		DRIVER_TYPE = DRIVER_TYPE == null ? getProperty("browser") : DRIVER_TYPE;
		BASE_URL = BASE_URL == null ? getProperty("base.url") : BASE_URL;
	}

	public static String getDriverType() {
		return DRIVER_TYPE;
	}

	public static String getBaseUrl() {
		return BASE_URL;
	}
}
