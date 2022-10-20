package com.jQuery;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import exception.BrowserNotSupport;
import pageObject.jQuery.datatable.HomePageObject;
import pageObject.jQuery.datatable.PageGenerateManagementTable;

public class Level_10_DataTable_DataGrid extends BaseTest {
	WebDriver driver;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");
	private HomePageObject homePage;
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName, String appURL) throws BrowserNotSupport {
		driver = getBrowserDriver(browserName);
		homePage = PageGenerateManagementTable.getHomePage(driver);
		driver.manage().window().maximize();
		driver.get(appURL);
		
	}

	//@Test
	public void TC_01_Input_To_Header_Texbox() {
		homePage.inputToTextboxByName("12253515", "Females");
		homePage.inputToTextboxByName("AFRICA", "Country");
	}

	//@Test
	public void TC_02_Input_To_Header_Texbox() {
		homePage.refreshCurrentPage(driver);
		homePage.inputToTextboxByName("12253515", "Females");
		homePage.sendkeyToTextbox("Females");
	}

	//@Test
	public void TC_03_Get_All_Value_At_Row() {
		homePage.getValueAllRowAtPage();
	}

	@Test
	public void TC_04_Input_To_Textbox_By_ColumnName_RowNumber() {
		homePage.clickOnLoadButton();
		homePage.inputToTextboxByColumnNameAtRowNumber("3", "Album", "Nguyen");
		homePage.inputToTextboxByColumnNameAtRowNumber("3", "Artist", "Hoang");
		homePage.inputToTextboxByColumnNameAtRowNumber("3", "Year", "Hiep");
		homePage.selectValueDropdowByColumnNameAtRowNumber("3", "Origin", "Others");
		homePage.clickOnCheckboxByColumnNameAtRowNumber("3", "With Poster?");
		homePage.clickOnCheckboxByColumnNameAtRowNumber("5", "With Poster?");
		homePage.unClickOnCheckboxByColumnNameAtRowNumber("1", "With Poster?");
		homePage.unClickOnCheckboxByColumnNameAtRowNumber("2", "With Poster?");
		homePage.unClickOnCheckboxByColumnNameAtRowNumber("4", "With Poster?");
	}

	@Test
	public void TC_05_Dynamic_Page_I() {
	}
	
	@Test
	public void TC_06_Dynamic_Page_II() {
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
