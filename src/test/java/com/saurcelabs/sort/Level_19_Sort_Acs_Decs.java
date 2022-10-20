package com.saurcelabs.sort;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import exception.BrowserNotSupport;
import pageObject.SauceLab.LoginPageObject;
import pageObject.SauceLab.PageGeneraterManagement;
import pageObject.SauceLab.ProductPageObject;

public class Level_19_Sort_Acs_Decs extends BaseTest {
	WebDriver driver;
	WebDriverWait explicitWait;
	String validEmail, invalidEmail, notFoundEmail, firstName, lastName, validPassword, confirmPassword, wrongPassword, Day, Month, Year;
	private ProductPageObject productPage;
	private LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeClass(String browserName, String pageURL) throws BrowserNotSupport {
		driver = getBrowserDriver(browserName, pageURL);
		loginPage = PageGeneraterManagement.getLoginPage(driver);

		log.info("Pre-Condition: Input to UserName");
		loginPage.inputToUserNameTextbox("standard_user");
		
		log.info("Pre-Condition: Input to Password");
		loginPage.inputToPasswordTextbox("secret_sauce");
		
		log.info("Pre-Condition: Click on Login");
		productPage = loginPage.clickOnLoginButton();

	}

	@Test
	public void Sort_01_Name() {
		log.info("Sort_01_Name - Step 01: Select Name (A to Z)");
		productPage.selectItemInProductContainser("Name (A to Z)");
		delay(3);
		
		log.info("Sort_01_Name - Step 02: Verify the name sort ascending");
		Assert.assertTrue(productPage.isValueSortAscending());
		
		log.info("Sort_01_Name - Step 03: Select Name (Z to A)");
		productPage.selectItemInProductContainser("Name (Z to A)");
		delay(3);
		
		log.info("Sort_01_Name - Step 04: Verify the name sort decending");
		Assert.assertTrue(productPage.isValueSortDecending());
	}

	@Test
	public void Sort_02_Price() {
		
		log.info("Sort_02_Price - Step 01: Select Price (low to high)");
		productPage.selectItemInProductContainser("Price (low to high)");
		delay(3);
		
		log.info("Sort_02_Price - Step 02: Verify the price sort ascending");
		Assert.assertTrue(productPage.isPriceSortAscending());
		
		log.info("Sort_02_Price - Step 03: Select Price (high to low)");
		productPage.selectItemInProductContainser("Price (high to low)");
		delay(3);
		
		log.info("Sort_02_Price - Step 04: Verify the price sort decending");
		Assert.assertTrue(productPage.isPriceSortDecending());
	}

	@AfterTest(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
