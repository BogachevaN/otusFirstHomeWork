package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class CoursePage extends BasePage {

    @FindBy(css = ".course-header2__title")
    WebElement courseTitle;

    public CoursePage(WebDriver driver) {
        super(driver);
    }

    public void checkTitle(String expectedValue) {
        Assert.assertEquals(expectedValue, this.courseTitle.getText());
    }

    public CoursePage waitForUrlContains(String urlPath) {
        var wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(urlPath));
        return this;
    }
}
