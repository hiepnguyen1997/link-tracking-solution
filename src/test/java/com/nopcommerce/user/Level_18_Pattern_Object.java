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

public class Level_18_Pattern_Object extends BaseTest {
	WebDriver driver;
	WebDriverWait explicitWait;
	String validEmail, invalidEmail, notFoundEmail, firstName, lastName, validPassword, confirmPassword, wrongPassword, Day, Month, Year;
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
		Day = "11";
		Month = "August";
		Year = "1997";
	}

	@Test
	public void Login_01_Regiester() {
		log.info("Register - Step 01: Click on Register link");
		registerPage = homePage.clickToRegisterLink();
		log.info("Register - Step 02: Input to first name");
		registerPage.inputToTextboxByID(driver, "FirstName", firstName);
		log.info("Register - Step 03: Input to last name");
		registerPage.inputToTextboxByID(driver, "LastName", lastName);
		log.info("Register - Step 04: Select value in Day dropdown");
		registerPage.selectValueInDropDownByName(driver, "DateOfBirthDay", Day);
		log.info("Register - Step 06: Select value in Month dropdown");
		registerPage.selectValueInDropDownByName(driver, "DateOfBirthMonth", Month);
		log.info("Register - Step 07: Select value in Year dropdown");
		registerPage.selectValueInDropDownByName(driver, "DateOfBirthYear", Year);
		log.info("Register - Step 08: Input to email");
		registerPage.inputToTextboxByID(driver, "Email", validEmail);
		log.info("Register - Step 09: Input to password");
		registerPage.inputToTextboxByID(driver, "Password", validPassword);
		log.info("Register - Step 10: Input to confirm password");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", validPassword);
		log.info("Register - Step 11: Click to Register button");
		registerPage.clickToRegisterButton();
		log.info("Register - Step 12: Verify message");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@Test
	public void Login_02_Login() {
		log.info("Login - Step 01: Click on Logout link");
		homePage = registerPage.clickToLogoutLink();
		log.info("Login - Step 02: Click on Login link");
		loginPage = homePage.clickOnLoginLink();
		log.info("Login - Step 03: Input to email");
		loginPage.inputToTextboxByID(driver, "Email", validEmail);
		log.info("Login - Step 04: Input to password");
		loginPage.inputToTextboxByID(driver, "Password", validPassword);
		log.info("Login - Step 05: Click on Login button");
		loginPage.clickOnButtonByName(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		log.info("Login - Step 05: Verify My Account link display");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		customerInforPage = homePage.clickOnMyAccountLink();
		Assert.assertEquals(customerInforPage.getTextInTextboxByID(driver, "FirstName", "value"), firstName);
		Assert.assertEquals(customerInforPage.getTextInTextboxByID(driver, "LastName", "value"), lastName);
		Assert.assertEquals(customerInforPage.getSelectedValueInDefaultDropdownListByName(driver, "DateOfBirthDay"), Day);
		Assert.assertEquals(customerInforPage.getSelectedValueInDefaultDropdownListByName(driver, "DateOfBirthMonth"), Month);
		Assert.assertEquals(customerInforPage.getSelectedValueInDefaultDropdownListByName(driver, "DateOfBirthYear"), Year);
	
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}


	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
