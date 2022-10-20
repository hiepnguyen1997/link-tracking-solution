package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import exception.BrowserNotSupport;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_04_Multiple_Browser extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String email, firstName, lastName, password, confirmPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName) throws BrowserNotSupport {
		driver = getBrowserDriver(browserName);
		homePage = new UserHomePageObject(driver);
		registerPage = new UserRegisterPageObject(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		email = "automation" + getRandomNumber() + "@gmail.com";
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		confirmPassword = "123456";
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorMessageFirstName(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageLastName(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageEmail(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessagePassword(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageConfirmPassword(), "Password is required.");

	}

	//@Test
	public void TC_02_Register_Invalid_Email() {
		homePage.clickToRegisterLink();
		registerPage.inputToFistName(firstName);
		registerPage.inputToLastName(lastName);
		registerPage.inputToEmail("123@123");
		registerPage.inputToPassword(password);
		registerPage.inputToConfirmPassword(confirmPassword);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorInvalidMail(), "Wrong email");

	}

	//@Test
	public void TC_03_Register_Success() {
		homePage.clickToRegisterLink();
		registerPage.inputToFistName(firstName);
		registerPage.inputToLastName(lastName);
		registerPage.inputToEmail(email);
		registerPage.inputToPassword(password);
		registerPage.inputToConfirmPassword(confirmPassword);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	//@Test
	public void TC_04_Register_Exsiting_Email() {
		registerPage.clickToLogoutLink();
		homePage.clickToRegisterLink();
		registerPage.inputToFistName(firstName);
		registerPage.inputToLastName(lastName);
		registerPage.inputToEmail(email);
		registerPage.inputToPassword(password);
		registerPage.inputToConfirmPassword(confirmPassword);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isExistingEmailErrorDisplayed());

	}

	//@Test
	public void TC_05_Register_Password_Less_Than_6_Characters() {
		homePage.clickToRegisterLink();
		registerPage.inputToFistName(firstName);
		registerPage.inputToLastName(lastName);
		registerPage.inputToEmail(email);
		registerPage.inputToPassword("123");
		registerPage.inputToConfirmPassword("123");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorMessagePassword(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	//@Test
	public void TC_06_Register_Invalid_Comfirm_Password() {
		homePage.clickToRegisterLink();
		registerPage.inputToFistName(firstName);
		registerPage.inputToLastName(lastName);
		registerPage.inputToEmail(email);
		registerPage.inputToPassword(password);
		registerPage.inputToConfirmPassword("123");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorMessageConfirmPassword(), "The password and confirmation password do not match.");

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
