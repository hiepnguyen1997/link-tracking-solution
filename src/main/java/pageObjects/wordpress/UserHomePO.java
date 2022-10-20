package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.wordpress.UserHomePageUI;

public class UserHomePO extends BasePage{
	private WebDriver driver;

	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostInforDisplayInHomePage(String postTitle) {
		waitForElementVisible(driver, UserHomePageUI.POST_TITLE, postTitle);
		return isElementDisplayed(driver, UserHomePageUI.POST_TITLE, postTitle);
	}

	public boolean isPostInforBodyDisplayInHomePage(String postTitle, String postBody) {
		waitForElementVisible(driver, UserHomePageUI.POST_BODY_BY_TITLE, postTitle, postBody);
		return isElementDisplayed(driver, UserHomePageUI.POST_BODY_BY_TITLE, postTitle, postBody);
	}

	public boolean isPostInforAuthorDisplayInHomePage(String postTitle, String authorName) {
		waitForElementVisible(driver, UserHomePageUI.AUTOR_BY_TITLE, postTitle, authorName);
		return isElementDisplayed(driver, UserHomePageUI.AUTOR_BY_TITLE, postTitle, authorName);
	}

	public boolean isPostInforCurrentDayDisplayInHomePage(String postTitle, String currentDay) {
		waitForElementVisible(driver, UserHomePageUI.CURRENET_DATE_BY_TITLE, postTitle, currentDay);
		return isElementDisplayed(driver, UserHomePageUI.CURRENET_DATE_BY_TITLE, postTitle, currentDay);
	}
	
	public UserPostDetailPageObject clicnOnPostTitle(String postTitle) {
		waitForElementVisible(driver, UserHomePageUI.POST_TITLE, postTitle);
		clickToElement(driver, UserHomePageUI.POST_TITLE, postTitle);
		return PageGeneraterManagement.getUserPostDetailPage(driver);
	}

	public boolean isPostInforUnDisplayInHomePage(String editTitle) {
		return isElementUnDisplay(driver, UserHomePageUI.POST_TITLE, editTitle);
	}

	public void inputToSearchbox(String editTitle) {
		waitForElementVisible(driver, UserHomePageUI.SEARCH_BOX);
		sendkeyToElement(driver, UserHomePageUI.SEARCH_BOX, editTitle);
		
	}

	public UserSearchPageObject clickOnSearchButton() {
		waitForElementClickabled(driver, UserHomePageUI.SEARCH_BUTTON);
		clickToElement(driver, UserHomePageUI.SEARCH_BUTTON);
		return PageGeneraterManagement.getUserSearchPage(driver);
	}

}
