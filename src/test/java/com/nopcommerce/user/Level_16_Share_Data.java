package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_New_Account;

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

public class Level_16_Share_Data extends BaseTest {
	WebDriver driver;
	WebDriverWait explicitWait;
	String email, invalidEmail, notFoundEmail, firstName, lastName, password, confirmPassword, wrongPassword;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;

	@Parameters({"browser","environment"})
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName, String  environmentName) throws BrowserNotSupport {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		driver.manage().window().maximize();
		driver.get(getEnvironmentName(environmentName));
		
		email = Common_01_Register_New_Account.email;
		password = Common_01_Register_New_Account.password;
	}


	@Test
	public void Login_02_Login() {
		log.info("Login - Step 01: Click on Login link");
		loginPage = homePage.clickOnLoginLink();
		log.info("Login - Step 02: Input to email");
		loginPage.inputToEmailTextBox(email);
		log.info("Login - Step 03: Input to password");
		loginPage.inputToPasswordTextBox(password);
		log.info("Login - Step 04: Click on Login button");
		homePage = loginPage.clickOnLoginButton();
		log.info("Login - Step 05: Verify My Account link display");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		log.info("Login - Step 06: Click on My Account link");
		customerInforPage = homePage.clickOnMyAccountLink();
		log.info("Login - Step 07: Verify Customer Infor page display");
		verifyEquals(customerInforPage.getMyAccountTitle(), "My account - Customer info..");
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
