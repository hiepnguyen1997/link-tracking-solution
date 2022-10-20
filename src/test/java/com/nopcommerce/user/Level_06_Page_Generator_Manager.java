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
import pageObjects.nopCommerce.portal.UserCustomerInforPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;

public class Level_06_Page_Generator_Manager extends BaseTest {
	WebDriver driver;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");
	String validEmail, invalidEmail, notFoundEmail, firstName, lastName, validPassword, confirmPassword, wrongPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject myAccountPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(@Optional ("chrome") String browserName) throws BrowserNotSupport {
		driver= getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		validEmail = "automation" + getRandomNumber() + "@gmail.com";
		invalidEmail = "123@dasd.#22";
		notFoundEmail = "test" + getRandomNumber() + "@gmail.vn";
		firstName = "Automation";
		lastName = "FC";
		validPassword = "123456";
		confirmPassword = "123456";
		wrongPassword = "147258";
		System.out.println("**************************************************************************");
		System.out.println("Pre-Condition Step 1: Click on Register link");
		registerPage = homePage.clickToRegisterLink();
		System.out.println("Pre-Condition Step 2: Input mandatory field");
		registerPage.inputToFistName(firstName);
		registerPage.inputToLastName(lastName);
		registerPage.inputToEmail(validEmail);
		registerPage.inputToPassword(validPassword);
		registerPage.inputToConfirmPassword(confirmPassword);
		System.out.println("Pre-Condition Step 3: Click on Register button");
		registerPage.clickToRegisterButton();
		System.out.println("Pre-Condition Step 4: Verify successfull message appear");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		System.out.println("Pre-Condition Step 5: Click on Logout link");
		System.out.println("**************************************************************************");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void Login_01_Empty_Data() {
		loginPage = homePage.clickOnLoginLink();
		loginPage.clickOnLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageEmailTexbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage = homePage.clickOnLoginLink();
		loginPage.inputToEmailTextBox(invalidEmail);
		loginPage.clickOnLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageEmailTexbox(), "Wrong email");
	}

	@Test
	public void TC_03_Email_NotFound() {
		loginPage = homePage.clickOnLoginLink();
		loginPage.inputToEmailTextBox(notFoundEmail);
		loginPage.clickOnLoginButton();
		Assert.assertEquals(loginPage.getInvalidErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void TC_04_Valid_Email_Empty_Password() {
		loginPage = homePage.clickOnLoginLink();
		loginPage.inputToEmailTextBox(validEmail);
		loginPage.clickOnLoginButton();
		Assert.assertEquals(loginPage.getInvalidErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_05_Valid_Email_Incorrect_Password() {
		loginPage = homePage.clickOnLoginLink();
		loginPage.inputToEmailTextBox(validEmail);
		loginPage.inputToPasswordTextBox(wrongPassword);
		loginPage.clickOnLoginButton();
		Assert.assertEquals(loginPage.getInvalidErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_06_Login_Success() {
		loginPage = homePage.clickOnLoginLink();
		loginPage.inputToEmailTextBox(validEmail);
		loginPage.inputToPasswordTextBox(validPassword);
		homePage = loginPage.clickOnLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		myAccountPage = homePage.clickOnMyAccountLink();
		Assert.assertEquals(myAccountPage.getMyAccountTitle(), "My account - Customer info");
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
