package pageObject.liveGuru;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.liveGuru.AdminHomePageGuruUI;

public class AdminHomePageGuruObject extends BasePage {
	private WebDriver driver;

	public AdminHomePageGuruObject(WebDriver driver) {
		this.driver = driver;
	}

	public void closeMessagePopup() {
		if (isElementDisplayed(driver, AdminHomePageGuruUI.POPUP)) {
			waitForElementClickabled(driver, AdminHomePageGuruUI.CLOSE_POPUP);
			clickToElement(driver, AdminHomePageGuruUI.CLOSE_POPUP);
		}
	}

	public boolean messagePopupDisplay() {
		return isElementDisplayed(driver, AdminHomePageGuruUI.POPUP);
	}

	public void inputToTextboxByColumnNameRowNumber(String columnName, String rowNumber, String value) {
		int indexCulumnName = getElementSize(driver, AdminHomePageGuruUI.COLUMN_NAME, columnName) + 1;
		waitForElementVisible(driver, AdminHomePageGuruUI.TEXTBOX_BY_COLUMN_NAME_ROW_NUMBER, rowNumber, String.valueOf(indexCulumnName));
		sendkeyToElement(driver, AdminHomePageGuruUI.TEXTBOX_BY_COLUMN_NAME_ROW_NUMBER, value, rowNumber, String.valueOf(indexCulumnName));
	}

	public void sendKeyBoardToToTextboxByColumnNameRowNumber(String columnName, String rowNumber) {
		int indexCulumnName = getElementSize(driver, AdminHomePageGuruUI.COLUMN_NAME, columnName) + 1;
		waitForElementVisible(driver, AdminHomePageGuruUI.TEXTBOX_BY_COLUMN_NAME_ROW_NUMBER, rowNumber, String.valueOf(indexCulumnName));
		sendKeyBoardToElement(driver, AdminHomePageGuruUI.TEXTBOX_BY_COLUMN_NAME_ROW_NUMBER, Keys.ENTER, rowNumber, String.valueOf(indexCulumnName));
	}

	public void waitForLoadingIconNotPresence() {
		waitForElementInvisible(driver, AdminHomePageGuruUI.LOADING_ICON);
	}

	public String getTextByByColumnNameRowNumber(String columnName, String rowNumber) {
		int indexCulumnName = getElementSize(driver, AdminHomePageGuruUI.COLUMN_NAME, columnName) + 1;
		waitForElementVisible(driver, AdminHomePageGuruUI.CELL_BY_COLUMN_NAME_ROW_NUMBER, rowNumber, String.valueOf(indexCulumnName));
		return getElementText(driver, AdminHomePageGuruUI.CELL_BY_COLUMN_NAME_ROW_NUMBER, rowNumber, String.valueOf(indexCulumnName));
	}

	public boolean isCellByColumnNameContainsText(String columnName, String expectedValue) {
		int indexColumnName = getElementSize(driver, AdminHomePageGuruUI.COLUMN_NAME, columnName) + 1;
		List<String> allValueAtColumn = new ArrayList<String>();
		waitForAllElementsVisible(driver, AdminHomePageGuruUI.CELL_BY_COLUMN_NAME, String.valueOf(indexColumnName));
		List<WebElement> allCellByColumnName = getListWebElement(driver, AdminHomePageGuruUI.CELL_BY_COLUMN_NAME, String.valueOf(indexColumnName));
		for (WebElement cell : allCellByColumnName) {
			allValueAtColumn.add(cell.getText());
		}
		boolean mapping = false;
		for (String value : allValueAtColumn) {
			if (value.equals(expectedValue)) {
				mapping = !mapping;
			}
		}
		return mapping;
	}
}
