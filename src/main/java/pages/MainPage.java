package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    // локаторы
    @FindBy(xpath = "//p[@class='header2-menu__item-text' and text()='Курсы']")
    public WebElement coursesMenuItem;

    @FindBy(xpath = "//div[contains(@class, 'header2-menu__subdropdown-wrapper')]/a[contains(@href, '/categories/testing')]")
    public  WebElement testingSubmenuItem;

    @FindBy(xpath = "//a[contains(@title, 'Тестирование')]/div[contains(@class, 'js-menu-subdropdown-trigger')]")
    public WebElement dropDownTrigger;

    @FindBy(xpath = "//a[contains(@href, '/lessons/java-qa-pro/')]")
    public WebElement javaProCourseMenuElement;

    @FindBy(xpath = "//div[contains(@class,'lessons__new-item-title')]")
    public List<WebElement> coursesNames;

    @FindBy(xpath = "//div[@class='transitional-main__event-text']")
    public WebElement selectCourseButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage moveToElementAction(Actions actions, WebElement element) {
        actions.moveToElement(element).perform();
        return this;
    }

    public CoursePage moveToElementAndClickAction(Actions actions, WebElement element) {
        actions.moveToElement(element).click().build().perform();
        return new CoursePage(driver);
    }
}
