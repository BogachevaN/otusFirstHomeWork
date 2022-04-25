import configuration.Environment;
import driver.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.MarkBeforeClickListener;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

@Slf4j
public class BaseTest {

	protected EventFiringWebDriver driver;

	protected WebDriverWait wait;

	protected Actions actions;
	protected MarkBeforeClickListener markBeforeClickListener;

	@BeforeClass
	public void setupWebDriverManager() {
		driver = DriverFactory.newDriver();
	}

	@BeforeMethod
	public void startTest(Method method) {
		actions = new Actions(driver);
		driver.register(new MarkBeforeClickListener());
		driver.get(Environment.getBaseUrl());
		log.info(String.format("Start test '%s'", method.getName()));
	}

	@AfterMethod
	public void endTest(Method method) {
		log.info(String.format("End test '%s'", method.getName()));
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
