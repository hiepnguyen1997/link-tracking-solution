package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.wordpress.UserSearchPageUI;

public class UserSearchPageObject extends BasePage{
	private WebDriver driver;
	
	public UserSearchPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public boolean isNotFoundMessageDisplay(String message) {
		waitForElementVisible(driver, UserSearchPageUI.NOT_FOUND_MESSAGE, message);
		return isElementDisplayed(driver, UserSearchPageUI.NOT_FOUND_MESSAGE, message);
	}

}
