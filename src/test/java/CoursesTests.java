
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.MainPage;

public class CoursesTests extends BaseTest{

	private MainPage mainPage ;

	@Test
	public void filterCourseByName() {
		String filter = "PHP";

		MainPage mainPage = new MainPage(driver);

		mainPage.coursesNames.stream()
			.map(WebElement::getText)
			.filter((String s) -> s.contains(filter))
			.forEach(System.out::println);
	}

	@Test
	public void selectCourseByName() {
		MainPage mainPage = new MainPage(driver);

		mainPage
			.moveToElementAction(actions, mainPage.coursesMenuItem)
			.moveToElementAction(actions, mainPage.testingSubmenuItem)
			.moveToElementAction(actions, mainPage.dropDownTrigger)
			.moveToElementAndClickAction(actions, mainPage.javaProCourseMenuElement)
			.waitForUrlContains("java-qa-pro")
			.checkTitle("Java QA Engineer. Professional");
	}

	@Test
	public void checkHighlightBeforeClick() {
		MainPage mainPage = new MainPage(driver);
		mainPage.coursesMenuItem.click();
	}
}
