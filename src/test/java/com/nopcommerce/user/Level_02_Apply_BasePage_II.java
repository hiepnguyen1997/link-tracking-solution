package com.nopcommerce.user;
//package com.nopcommerce.user;
//
//import org.testng.annotations.Test;
//
//import commons.BasePage;
//
//import org.testng.annotations.BeforeClass;
//
//import java.io.File;
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//
//public class User_02_Apply_BasePage_II{
//	WebDriver driver;
//	WebDriverWait explicitWait;
//	String projectPath = System.getProperty("user.dir");
//	String email;
//	// Declare (khai bao)
//	BasePage basePage;
//
//	@BeforeClass
//	public void beforeClass() {
//		System.setProperty("webdriver.gecko.driver", projectPath + File.separator + "browserDrivers" + File.separator + "geckodriver.exe");
//		driver = new FirefoxDriver();
//		
//		// Initial(khoi tao)
//		//Che giau viec khoi tao
//		//Static method co the duoc goi ma ko can tao instance
//		basePage = BasePage.getBasePageObject();
//		
//		explicitWait = new WebDriverWait(driver, 15);
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.get("https://demo.nopcommerce.com/");
//		email = "automation" + getRandomNumber() + "@gmail.com";
//	}
//
//	@Test
//	public void TC_01_Register_Empty_Data() {
//		basePage.waitForElementClickabled(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//		basePage.waitForElementClickabled(driver, "//button[@id='register-button']");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//		basePage.waitForElementVisible(driver, "//span[@id='FirstName-error']");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
//		basePage.waitForElementVisible(driver, "//span[@id='LastName-error']");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
//		basePage.waitForElementVisible(driver, "//span[@id='Email-error']");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
//		basePage.waitForElementVisible(driver, "//span[@id='Password-error']");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
//		basePage.waitForElementVisible(driver, "//span[@id='ConfirmPassword-error']");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
//
//	}
//
//	@Test
//	public void TC_02_Register_Invalid_Email() {
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
//		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "FC");
//		basePage.sendkeyToElement(driver, "//input[@id='Email']", "123@hcm");
//		basePage.sendkeyToElement(driver, "//input[@id='Password']", "1234567");
//		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "1234567");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//		basePage.waitForElementVisible(driver, "//div[@class='message-error validation-summary-errors']");
//		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='message-error validation-summary-errors']"), "Wrong email");
//	}
//
//	@Test
//	public void TC_03_Register_Success() {
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
//		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "FC");
//		basePage.sendkeyToElement(driver, "//input[@id='Email']", email);
//		basePage.sendkeyToElement(driver, "//input[@id='Password']", "1234567");
//		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "1234567");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//		basePage.waitForElementVisible(driver, "//div[@class='result']");
//		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
//	}
//
//	@Test
//	public void TC_04_Register_Exsiting_Email() {
//		basePage.waitForElementVisible(driver, "//a[@class='ico-logout']");
//		basePage.clickToElement(driver, "//a[@class='ico-logout']");
//		basePage.waitForElementClickabled(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//		basePage.waitForElementClickabled(driver, "//button[@id='register-button']");
//		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
//		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "FC");
//		basePage.sendkeyToElement(driver, "//input[@id='Email']", email);
//		basePage.sendkeyToElement(driver, "//input[@id='Password']", "1234567");
//		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "1234567");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//		basePage.waitForElementVisible(driver, "//li[text()='The specified email already exists']");
//		Assert.assertTrue(basePage.isElementDisplayed(driver, "//li[text()='The specified email already exists']"));
//	}
//
//	@Test
//	public void TC_05_Register_Password_Less_Than_6_Characters() {
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//		basePage.waitForElementClickabled(driver, "//button[@id='register-button']");
//		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
//		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "FC");
//		basePage.sendkeyToElement(driver, "//input[@id='Email']", email);
//		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123");
//		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//		basePage.waitForElementVisible(driver, "//span[@id='Password-error']");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");
//	}
//
//	@Test
//	public void TC_06_Register_Invalid_Comfirm_Password() {
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//		basePage.waitForElementClickabled(driver, "//button[@id='register-button']");
//		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
//		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "FC");
//		basePage.sendkeyToElement(driver, "//input[@id='Email']", email);
//		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
//		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//		basePage.waitForElementVisible(driver, "//span[@id='ConfirmPassword-error']");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
//	}
//
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}
//
//	public int getRandomNumber() {
//		Random rand = new Random();
//		return rand.nextInt(9999);
//	}
//
//}
