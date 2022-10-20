package com.nopcommerce.user;

import org.testng.annotations.Test;
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

public class Level_01_Register_DRY {
	WebDriver driver;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");
	String email;

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
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.ico-register")));
		driver.findElement(By.cssSelector("a.ico-register")).click();
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#register-button")));
		driver.findElement(By.cssSelector("button#register-button")).click();
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span#FirstName-error")));
		Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(), "First name is required.");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span#LastName-error")));
		Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(), "Last name is required.");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span#Email-error")));
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Email is required.");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span#Password-error")));
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password is required.");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span#ConfirmPassword-error")));
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "Password is required.");
	}
	
	@Test
	public void TC_02_Register_Invalid_Email() {
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automation");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("FC");
		driver.findElement(By.cssSelector("input#Email")).sendKeys("123@hcm");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("1234567");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("1234567");
		driver.findElement(By.cssSelector("button#register-button")).click();
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.message-error")));
		Assert.assertEquals(driver.findElement(By.cssSelector("div.message-error")).getText(), "Wrong email");
	}
	
	@Test
	public void TC_03_Register_Success() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automation");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("FC");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(email);
		driver.findElement(By.cssSelector("input#Password")).sendKeys("1234567");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("1234567");
		driver.findElement(By.cssSelector("button#register-button")).click();
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.result")));
		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
	}
	
	@Test
	public void TC_04_Register_Exsiting_Email() {
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.ico-logout")));
		driver.findElement(By.cssSelector("a.ico-logout")).click();
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.ico-register")));
		driver.findElement(By.cssSelector("a.ico-register")).click();
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#register-button")));
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automation");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("FC");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(email);
		driver.findElement(By.cssSelector("input#Password")).sendKeys("1234567");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("1234567");
		driver.findElement(By.cssSelector("button#register-button")).click();
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='The specified email already exists']")));
		Assert.assertTrue(driver.findElement(By.xpath("//li[text()='The specified email already exists']")).isDisplayed());
	}
	
	@Test
	public void TC_05_Register_Password_Less_Than_6_Characters() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automation");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("FC");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(email);
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password must meet the following rules:\nmust have at least 6 characters");
	}
	
	@Test
	public void TC_06_Register_Invalid_Comfirm_Password() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automation");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("FC");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(email);
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "The password and confirmation password do not match.");
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
