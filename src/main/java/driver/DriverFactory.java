package driver;

import configuration.Environment;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.time.Duration;


public class DriverFactory {

	static String driverType = Environment.getDriverType();

	public static EventFiringWebDriver newDriver() {

		EventFiringWebDriver driver;
		switch (driverType) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				var options = setChromeOptions();
				driver = new EventFiringWebDriver(new ChromeDriver(options));
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new EventFiringWebDriver(new FirefoxDriver());
				break;
			case "opera":
				WebDriverManager.operadriver().setup();
				driver = new EventFiringWebDriver(new OperaDriver());
				break;
			default:
				throw new IllegalArgumentException(String.format("Browser type %s doesn't support", driverType));
		}
		return driver;
	}

	public static ChromeOptions setChromeOptions() {
		var options = new ChromeOptions();
		options.setScriptTimeout(Duration.ofSeconds(30));
		options.addArguments("--kiosk");
		return options;
	}
}
