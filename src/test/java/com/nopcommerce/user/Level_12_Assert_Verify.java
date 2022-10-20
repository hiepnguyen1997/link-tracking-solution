package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import exception.BrowserNotSupport;
import pageObject.jQuery.uploadfile.HomePageObject;
import pageObject.jQuery.uploadfile.PageGenerateManagementUpload;

public class Level_12_Assert_Verify extends BaseTest {
	WebDriver driver;
	private HomePageObject homePage;
	private String samsungFileName = "SAMSUNG.PNG";
	private String senkoFileName = "SENKO.PNG";
	private String xiaomiFileName = "XIAOMI.PNG";
	private String[] listFileName = {"SAMSUNG.PNG", "SENKO.PNG", "XIAOMI.PNG"};
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName, String appURL) throws BrowserNotSupport {
		driver = getBrowserDriver(browserName);
		homePage = PageGenerateManagementUpload.getHomePage(driver);
		driver.get(appURL);
		
	}

	@Test
	public void TC_01_Upload_Single_File() {
		homePage.uploadMultipleFiles(driver, samsungFileName);
		verifyTrue(homePage.isFileLoaded(samsungFileName));
		homePage.clickOnStartButton();
		verifyTrue(homePage.isLinkFileByNameDisplay(samsungFileName));
		verifyTrue(homePage.isUploadedFileImageByNameDisplay(samsungFileName));
	}

	@Test
	public void TC_02_Upload_Multiple() {
		homePage.refreshCurrentPage(driver);
		homePage.uploadMultipleFiles(driver, listFileName);
		verifyTrue(homePage.isFileLoaded(samsungFileName));
		verifyTrue(homePage.isFileLoaded(senkoFileName));
		verifyTrue(homePage.isFileLoaded(xiaomiFileName));
		homePage.clickOnStartButton();
		verifyTrue(homePage.isLinkFileByNameDisplay(samsungFileName));
		verifyTrue(homePage.isUploadedFileImageByNameDisplay(samsungFileName));
		verifyTrue(homePage.isLinkFileByNameDisplay(senkoFileName));
		verifyTrue(homePage.isUploadedFileImageByNameDisplay(senkoFileName));
		verifyTrue(homePage.isLinkFileByNameDisplay(xiaomiFileName));
		verifyTrue(homePage.isUploadedFileImageByNameDisplay(xiaomiFileName));
		
	}

	@Test
	public void TC_03_Get_All_Value_At_Row() {
	}

	@Test
	public void TC_04_Input_To_Textbox_By_ColumnName_RowNumber() {
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
