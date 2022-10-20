package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.wordpress.AdminPostAddNewUI;

public class AdminPostAddNewPageObject extends BasePage{
	private WebDriver driver;
	
	public AdminPostAddNewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToNewPostTitle(String postTitle) {
		waitForElementVisible(driver, AdminPostAddNewUI.INPUT_TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewUI.INPUT_TITLE_TEXTBOX, postTitle);
		sleepInSecond(2);
	}

	public void inputToNewPostBody(String postBody) {
		waitForElementClickabled(driver, AdminPostAddNewUI.BODY_BUTTON);
		clickToElement(driver, AdminPostAddNewUI.BODY_BUTTON);
		sleepInSecond(2);
		sendkeyToElement(driver, AdminPostAddNewUI.INPUT_BODY_TEXTBOX, postBody);
	}

	public void clickOnPushButton() {
		waitForElementClickabled(driver, AdminPostAddNewUI.PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewUI.PUBLISH_BUTTON);
	}

	public boolean isPushPublicisDisplay(String textMessage) {
		waitForElementVisible(driver, AdminPostAddNewUI.PUBLISH_MESSAGE, textMessage);
		return isElementDisplayed(driver, AdminPostAddNewUI.PUBLISH_MESSAGE, textMessage);
		
	}

	public AdminPostSearchPageObject openSearchPostPage(String postSearchURL) {
		openPageUrl(driver, postSearchURL);
		return PageGeneraterManagement.getAdminPostSearchPage(driver);
	}

	public void clickOnPrePushButton() {
		waitForElementClickabled(driver, AdminPostAddNewUI.PRE_PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewUI.PRE_PUBLISH_BUTTON);
	}

	public void editPostBody(String editBody) {
		waitForElementClickabled(driver, AdminPostAddNewUI.INPUT_BODY_TEXTBOX);
		clickToElement(driver, AdminPostAddNewUI.INPUT_BODY_TEXTBOX);
		sleepInSecond(1);
		clearTextInElementByKey(driver, AdminPostAddNewUI.INPUT_BODY_TEXTBOX);
		sleepInSecond(2);
		sendkeyToElement(driver, AdminPostAddNewUI.INPUT_BODY_TEXTBOX, editBody);
		
	}

}
