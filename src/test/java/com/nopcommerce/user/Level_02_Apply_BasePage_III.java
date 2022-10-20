package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_02_Apply_BasePage_III extends BasePage{
	WebDriver driver;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");
	String email;
	// Declare (khai bao)

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + File.separator + "browserDrivers" + File.separator + "geckodriver.exe");
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		email = "automation" + getRandomNumber() + "@gmail.com";
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		waitForElementClickabled(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");
		waitForElementClickabled(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");
		waitForElementVisible(driver, "//span[@id='FirstName-error']");
		Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		waitForElementVisible(driver, "//span[@id='LastName-error']");
		Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		waitForElementVisible(driver, "//span[@id='Email-error']");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		waitForElementVisible(driver, "//span[@id='Password-error']");
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		waitForElementVisible(driver, "//span[@id='ConfirmPassword-error']");
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");

	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		clickToElement(driver, "//a[@class='ico-register']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		sendkeyToElement(driver, "//input[@id='LastName']", "FC");
		sendkeyToElement(driver, "//input[@id='Email']", "123@hcm");
		sendkeyToElement(driver, "//input[@id='Password']", "1234567");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "1234567");
		clickToElement(driver, "//button[@id='register-button']");
		waitForElementVisible(driver, "//div[@class='message-error validation-summary-errors']");
		Assert.assertEquals(getElementText(driver, "//div[@class='message-error validation-summary-errors']"), "Wrong email");
	}

	@Test
	public void TC_03_Register_Success() {
		clickToElement(driver, "//a[@class='ico-register']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		sendkeyToElement(driver, "//input[@id='LastName']", "FC");
		sendkeyToElement(driver, "//input[@id='Email']", email);
		sendkeyToElement(driver, "//input[@id='Password']", "1234567");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "1234567");
		clickToElement(driver, "//button[@id='register-button']");
		waitForElementVisible(driver, "//div[@class='result']");
		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");
	}

	@Test
	public void TC_04_Register_Exsiting_Email() {
		waitForElementVisible(driver, "//a[@class='ico-logout']");
		clickToElement(driver, "//a[@class='ico-logout']");
		waitForElementClickabled(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");
		waitForElementClickabled(driver, "//button[@id='register-button']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		sendkeyToElement(driver, "//input[@id='LastName']", "FC");
		sendkeyToElement(driver, "//input[@id='Email']", email);
		sendkeyToElement(driver, "//input[@id='Password']", "1234567");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "1234567");
		clickToElement(driver, "//button[@id='register-button']");
		waitForElementVisible(driver, "//li[text()='The specified email already exists']");
		Assert.assertTrue(isElementDisplayed(driver, "//li[text()='The specified email already exists']"));
	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Characters() {
		clickToElement(driver, "//a[@class='ico-register']");
		waitForElementClickabled(driver, "//button[@id='register-button']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		sendkeyToElement(driver, "//input[@id='LastName']", "FC");
		sendkeyToElement(driver, "//input[@id='Email']", email);
		sendkeyToElement(driver, "//input[@id='Password']", "123");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123");
		clickToElement(driver, "//button[@id='register-button']");
		waitForElementVisible(driver, "//span[@id='Password-error']");
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void TC_06_Register_Invalid_Comfirm_Password() {
		clickToElement(driver, "//a[@class='ico-register']");
		waitForElementClickabled(driver, "//button[@id='register-button']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		sendkeyToElement(driver, "//input[@id='LastName']", "FC");
		sendkeyToElement(driver, "//input[@id='Email']", email);
		sendkeyToElement(driver, "//input[@id='Password']", "123456");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123");
		clickToElement(driver, "//button[@id='register-button']");
		waitForElementVisible(driver, "//span[@id='ConfirmPassword-error']");
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
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
