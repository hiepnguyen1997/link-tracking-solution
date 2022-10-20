package com.nopcommerce.common;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import exception.BrowserNotSupport;
import pageObjects.nopCommerce.portal.UserAddressPageObject;
import pageObjects.nopCommerce.portal.UserCustomerInforPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
import pageObjects.nopCommerce.portal.UserRewardPointsPageObject;

public class Common_01_Register_New_Account extends BaseTest {
	WebDriver driver;
	private String firstName, lastName, confirmPassword;
	public static String email, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

	@Parameters({"browser","environment"})
	@BeforeTest
	public void Regiester(@Optional("chrome") String browserName, String  environmentName) throws BrowserNotSupport {
		driver = getBrowserDriver(browserName);
		driver.get(getEnvironmentName(environmentName));
		homePage = PageGeneratorManager.getUserHomePage(driver);
		email = "automation" + getRandomNumber() + "@gmail.com";
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		confirmPassword = "123456";
		
		log.info("Re-Conditions - Step 01: Click on Register link");
		registerPage = homePage.clickToRegisterLink();
		log.info("Re-Conditions - Step 02: Input to first name");
		registerPage.inputToFistName(firstName);
		log.info("Re-Conditions - Step 03: Input to last name");
		registerPage.inputToLastName(lastName);
		log.info("Re-Conditions - Step 04: Input to email");
		registerPage.inputToEmail(email);
		log.info("Re-Conditions - Step 05: Input to password");
		registerPage.inputToPassword(password);
		log.info("Re-Conditions - Step 06: Input to confirm password");
		registerPage.inputToConfirmPassword(confirmPassword);
		log.info("Re-Conditions - Step 07: Click to Register button");
		registerPage.clickToRegisterButton();
		log.info("Re-Conditions - Step 08: Verify message");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		log.info("Re-Conditions - Step 09: Click on Logout link");
		homePage = registerPage.clickToLogoutLink();
		driver.quit();
	}
	

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
