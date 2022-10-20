package pageObject.jQuery.datatable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.jQuery.datatable.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToTextboxByName(String value, String pageName) {
		waitForElementVisible(driver, HomePageUI.NAME_TEXTBOX, pageName);
		sendkeyToElement(driver, HomePageUI.NAME_TEXTBOX, value, pageName);
		
	}
	
	public void clickOnPagination(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGE_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGE_NUMBER, pageNumber);
	}
	
	public void sendkeyToTextbox(String pageName) {
		sendKeyBoardToElement(driver, HomePageUI.NAME_TEXTBOX, Keys.ENTER, pageName);
	}

	public void getValueAllRowAtPage() {
		List<String> valueAllRowOfAllPage = new ArrayList<String>();
		int totalPage = getElementSize(driver, HomePageUI.ALL_PAGE);
		for (int index =1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGE_NUMBER, String.valueOf(index));
			List<WebElement> allValueRowEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_IN_EACH_PAGE);
			for (WebElement row : allValueRowEachPage) {
				valueAllRowOfAllPage.add(row.getText());
			}
		}
		for (String value : valueAllRowOfAllPage) {
			System.out.println("======================================================================");
			System.out.println(value);
		}
	}

	public void inputToTextboxByColumnNameAtRowNumber(String rowNumber, String columnName, String value) {
		int indexColumnName = getElementSize(driver, HomePageUI.COLUMN_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_NAME_ROW_NUMBER, rowNumber, String.valueOf(indexColumnName));
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_NAME_ROW_NUMBER, value, rowNumber, String.valueOf(indexColumnName));
	}

	public void selectValueDropdowByColumnNameAtRowNumber(String rowNumber, String columnName, String valueItem) {
		int indexColumnName = getElementSize(driver, HomePageUI.COLUMN_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, HomePageUI.DROPDOW_BY_COLUMN_NAME_ROW_NUMBER, rowNumber, String.valueOf(indexColumnName));
		selectItemInDefaultDropdown(driver, HomePageUI.DROPDOW_BY_COLUMN_NAME_ROW_NUMBER, valueItem, rowNumber, String.valueOf(indexColumnName));
	}

	public void clickOnCheckboxByColumnNameAtRowNumber(String rowNumber, String columnName) {
		int indexColumnName = getElementSize(driver, HomePageUI.COLUMN_BY_NAME, columnName) + 1;
		waitForElementClickabled(driver, HomePageUI.CHECKBOX_BY_COLUMN_NAME_ROW_NUMBER, rowNumber, String.valueOf(indexColumnName));
		checkToDefaultCheckboxRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_NAME_ROW_NUMBER, rowNumber, String.valueOf(indexColumnName));
	}
	
	public void unClickOnCheckboxByColumnNameAtRowNumber(String rowNumber, String columnName) {
		int indexColumnName = getElementSize(driver, HomePageUI.COLUMN_BY_NAME, columnName) + 1;
		waitForElementClickabled(driver, HomePageUI.CHECKBOX_BY_COLUMN_NAME_ROW_NUMBER, rowNumber, String.valueOf(indexColumnName));
		unCheckToDefaultCheckbox(driver, HomePageUI.CHECKBOX_BY_COLUMN_NAME_ROW_NUMBER, rowNumber, String.valueOf(indexColumnName));
	}

	public void clickOnLoadButton() {
		waitForElementClickabled(driver, HomePageUI.LOAD_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_BUTTON);
	}
	
}
