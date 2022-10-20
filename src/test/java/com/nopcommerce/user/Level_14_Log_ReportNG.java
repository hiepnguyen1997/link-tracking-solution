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

public class Level_14_Log_ReportNG extends BaseTest {
	WebDriver driver;
	WebDriverWait explicitWait;
	String validEmail, invalidEmail, notFoundEmail, firstName, lastName, validPassword, confirmPassword, wrongPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	private UserRewardPointsPageObject rewardPage;
	private UserMyProductReviewPageObject myProductPage;

	@Parameters({"browser","environment"})
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName, String  environmentName) throws BrowserNotSupport {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		driver.manage().window().maximize();
		driver.get(getEnvironmentName(environmentName));
		validEmail = "automation" + getRandomNumber() + "@gmail.com";
		firstName = "Automation";
		lastName = "FC";
		validPassword = "123456";
		confirmPassword = "123456";
	}

	@Test
	public void Login_01_Regiester() {
		log.info("Register - Step 01: Click on Register link");
		registerPage = homePage.clickToRegisterLink();
		log.info("Register - Step 02: Input to first name");
		registerPage.inputToFistName(firstName);
		log.info("Register - Step 03: Input to last name");
		registerPage.inputToLastName(lastName);
		log.info("Register - Step 04: Input to email");
		registerPage.inputToEmail(validEmail);
		log.info("Register - Step 05: Input to password");
		registerPage.inputToPassword(validPassword);
		log.info("Register - Step 06: Input to confirm password");
		registerPage.inputToConfirmPassword(confirmPassword);
		log.info("Register - Step 07: Click to Register button");
		registerPage.clickToRegisterButton();
		log.info("Register - Step 08: Verify message");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");
		log.info("Register - Step 09: Click on Logout link");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void Login_02_Login() {
		log.info("Login - Step 01: Click on Login link");
		loginPage = homePage.clickOnLoginLink();
		log.info("Login - Step 02: Input to email");
		loginPage.inputToEmailTextBox(validEmail);
		log.info("Login - Step 03: Input to password");
		loginPage.inputToPasswordTextBox(validPassword);
		log.info("Login - Step 04: Click on Login button");
		homePage = loginPage.clickOnLoginButton();
		log.info("Login - Step 05: Verify My Account link display");
		verifyFalse(homePage.isMyAccountLinkDisplayed());
		log.info("Login - Step 06: Click on My Account link");
		customerInforPage = homePage.clickOnMyAccountLink();
		log.info("Login - Step 07: Verify Customer Infor page display");
		verifyEquals(customerInforPage.getMyAccountTitle(), "My account - Customer info..");
	}


	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
