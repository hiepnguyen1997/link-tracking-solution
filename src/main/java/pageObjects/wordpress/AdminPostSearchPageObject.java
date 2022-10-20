package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.wordpress.AdminPostSearchUI;

public class AdminPostSearchPageObject extends BasePage{
	private WebDriver driver;
	
	public AdminPostSearchPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostAddNewPageObject clickOnAddNewButton() {
		waitForElementClickabled(driver, AdminPostSearchUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostSearchUI.ADD_NEW_BUTTON);
		return PageGeneraterManagement.getAdminPostAddNewPage(driver);
	}

	public void inputToSearchBox(String postTitle) {
		waitForElementVisible(driver, AdminPostSearchUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, AdminPostSearchUI.SEARCH_TEXTBOX, postTitle);
	}

	public void clickOnSearchButton() {
		waitForElementClickabled(driver, AdminPostSearchUI.SEARCH_BUTTON);
		clickToElement(driver, AdminPostSearchUI.SEARCH_BUTTON);
	}

	public boolean isPostSearchTableDisplay(String columnName, String value) {
		int indexColumn = getElementSize(driver, AdminPostSearchUI.HEADER_TABLE_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, AdminPostSearchUI.TABLE_ROW_VALUE_BY_INDEX_HEADER, String.valueOf(indexColumn), value);
		return isElementDisplayed(driver, AdminPostSearchUI.TABLE_ROW_VALUE_BY_INDEX_HEADER, String.valueOf(indexColumn), value);
	}

	public AdminPostAddNewPageObject clickOnCellByIDName(String columnName, String value) {
		int indexColumn = getElementSize(driver, AdminPostSearchUI.HEADER_TABLE_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, AdminPostSearchUI.TABLE_ROW_VALUE_BY_INDEX_HEADER, String.valueOf(indexColumn), value);
		clickToElement(driver, AdminPostSearchUI.TABLE_ROW_VALUE_BY_INDEX_HEADER, String.valueOf(indexColumn), value);
		return PageGeneraterManagement.getAdminPostAddNewPage(driver);
		
	}

	public void clickOnPostDetailCheckboxByTitle(String editTitle) {
		waitForElementClickabled(driver, AdminPostSearchUI.POST_CHECKBOX_BY_TITLE, editTitle);
		checkToDefaultCheckboxRadio(driver, AdminPostSearchUI.POST_CHECKBOX_BY_TITLE, editTitle);
	}

	public void selectTextIteminActionDropdown(String textItem) {
		waitForElementClickabled(driver, AdminPostSearchUI.ACTION_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminPostSearchUI.ACTION_DROPDOWN, textItem);
		
	}

	public boolean isMoveToTrashMessageDisplayed(String message) {
		waitForElementVisible(driver, AdminPostSearchUI.MOVE_TO_TRASH_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostSearchUI.MOVE_TO_TRASH_MESSAGE, message);
	}

	public boolean isNoPostFoundMessageDisplayed(String message) {
		waitForElementVisible(driver, AdminPostSearchUI.NO_POST_FOUND_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostSearchUI.NO_POST_FOUND_MESSAGE, message);
	}

	public void clickOnApplyButton() {
		waitForElementClickabled(driver, AdminPostSearchUI.APPLY_BUTTON);
		clickToElement(driver, AdminPostSearchUI.APPLY_BUTTON);
		
	}

}
