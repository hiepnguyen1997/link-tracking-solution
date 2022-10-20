package com.facebook;

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
import pageObject.facebook.LoginPageFBObject;
import pageObject.facebook.PageGeneratorManagementFB;
import pageObject.jQuery.uploadfile.HomePageObject;
import pageObject.jQuery.uploadfile.PageGenerateManagementUpload;

public class Level_13_Element_Condition extends BaseTest {
	WebDriver driver;
	private LoginPageFBObject loginPage;
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName, String appURL) throws BrowserNotSupport {
		driver = getBrowserDriver(browserName);
		loginPage = PageGeneratorManagementFB.getLoginPage(driver);
		driver.get(appURL);
		
	}

	@Test
	public void TC_01_Upload_Single_File() {
		loginPage.clickOCreateNewAccount();
		loginPage.sendkeysToEmailAddressTextbox("hiep@gmail.com");
		delay(2);
		verifyTrue(loginPage.isConfirmEmailTextboxDisplay());
		loginPage.sendkeysToEmailAddressTextbox("");
		delay(2);
		verifyTrue(loginPage.isConfirmEmailTextboxUnDisplay());
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
