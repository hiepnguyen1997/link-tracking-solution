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
import exception.BrowserNotSupport;
import pageFactory.HomePageObject;
import pageFactory.LoginPageObject;
import pageFactory.RegisterPageObject;


public class Level_05_Page_Factory extends BaseTest {
	WebDriver driver;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");
	String validEmail, invalidEmail, notFoundEmail, firstName, lastName, validPassword, confirmPassword, wrongPassword;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(@Optional ("chrome") String browserName) throws BrowserNotSupport {
		driver= getBrowserDriver(browserName);
		homePage = HomePageObject.getHomePageObject(driver);

		driver.get("https://demo.nopcommerce.com/");
		validEmail = "automation" + getRandomNumber() + "@gmail.com";
		invalidEmail = "123@dasd.#22";
		notFoundEmail = "test" + getRandomNumber() + "@gmail.vn";
		firstName = "Automation";
		lastName = "FC";
		validPassword = "123456";
		confirmPassword = "123456";
		wrongPassword = "147258";
		System.out.println("Pre-Condition Step 1: Click on Register link");
		homePage.clickToRegisterLink();
		System.out.println("Pre-Condition Step 2: Input mandatory field");
		registerPage = RegisterPageObject.getRegisterPageObject(driver);
		registerPage.inputToFistName(firstName);
		registerPage.inputToLastName(lastName);
		registerPage.inputToEmail(validEmail);
		registerPage.inputToPassword(validPassword);
		registerPage.inputToConfirmPassword(confirmPassword);
		System.out.println("Pre-Condition Step 3: Click on Register button");
		registerPage.clickToRegisterButton();
		System.out.println("Pre-Condition Step 4: Verify successfull message appear");
		Assert.assertEquals(registerPage.getRegisterSuccess(), "Your registration completed");
		System.out.println("Pre-Condition Step 5: Click on Logout link");
		registerPage.clickToLogoutLink();
		homePage = HomePageObject.getHomePageObject(driver);
	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.clickOnLoginLink();
		loginPage = LoginPageObject.getLoginPageObject(driver);
		loginPage.clickOnLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageEmailTexbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.clickOnLoginLink();
		loginPage = LoginPageObject.getLoginPageObject(driver);
		loginPage.inputToEmailTextBox(invalidEmail);
		loginPage.clickOnLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageEmailTexbox(), "Wrong email");
	}

	@Test
	public void TC_03_Email_NotFound() {
		homePage.clickOnLoginLink();
		loginPage = LoginPageObject.getLoginPageObject(driver);
		loginPage.inputToEmailTextBox(notFoundEmail);
		loginPage.clickOnLoginButton();
		Assert.assertEquals(loginPage.getInvalidErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void TC_04_Valid_Email_Empty_Password() {
		homePage.clickOnLoginLink();
		loginPage = LoginPageObject.getLoginPageObject(driver);
		loginPage.inputToEmailTextBox(validEmail);
		loginPage.clickOnLoginButton();
		Assert.assertEquals(loginPage.getInvalidErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_05_Valid_Email_Incorrect_Password() {
		homePage.clickOnLoginLink();
		loginPage = LoginPageObject.getLoginPageObject(driver);
		loginPage.inputToEmailTextBox(validEmail);
		loginPage.inputToPasswordTextBox(wrongPassword);
		loginPage.clickOnLoginButton();
		Assert.assertEquals(loginPage.getInvalidErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_06_Login_Success() {
		homePage.clickOnLoginLink();
		loginPage = LoginPageObject.getLoginPageObject(driver);
		loginPage.inputToEmailTextBox(validEmail);
		loginPage.inputToPasswordTextBox(validPassword);
		loginPage.clickOnLoginButton();
		homePage = HomePageObject.getHomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
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
