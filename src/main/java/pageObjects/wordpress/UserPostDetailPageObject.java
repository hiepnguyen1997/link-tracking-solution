package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.wordpress.UserPostDetailPageUI;

public class UserPostDetailPageObject extends BasePage{
	private WebDriver driver;
	
	public UserPostDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostInforDisplayInDetailPage(String postTitle) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_TITLE, postTitle);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_TITLE, postTitle);
	}

	public boolean isPostInforBodyDisplayInDetaiPage(String postTitle, String postBody) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_BODY_BY_TITLE, postTitle, postBody);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_BODY_BY_TITLE, postTitle, postBody);
	}

	public boolean isPostInforAuthorDisplayInDetaiPage(String postTitle, String authorName) {
		waitForElementVisible(driver, UserPostDetailPageUI.AUTOR_BY_TITLE, postTitle, authorName);
		return isElementDisplayed(driver, UserPostDetailPageUI.AUTOR_BY_TITLE, postTitle, authorName);
	}

	public boolean isPostInforCurrentDayDisplayInDetaiPage(String postTitle, String currentDay) {
		waitForElementVisible(driver, UserPostDetailPageUI.CURRENET_DATE_BY_TITLE, postTitle, currentDay);
		return isElementDisplayed(driver, UserPostDetailPageUI.CURRENET_DATE_BY_TITLE, postTitle, currentDay);
	}

}
