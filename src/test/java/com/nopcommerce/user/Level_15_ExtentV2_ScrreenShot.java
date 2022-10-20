package com.nopcommerce.user;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;

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
//import reportConfig.ExtentManager;

public class Level_15_ExtentV2_ScrreenShot extends BaseTest {
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
	public void beforeClass(@Optional("chrome") String browserName, String environmentName) throws BrowserNotSupport {
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
	public void Login_01_Regiester(Method method) {
//		ExtentManager.startTest(method.getName(), "Login_01_Regiester");
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Click on Register link");
//		registerPage = homePage.clickToRegisterLink();
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 02: Input to first name");
//		registerPage.inputToFistName(firstName);
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 03: Input to last name");
//		registerPage.inputToLastName(lastName);
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 04: Input to email");
//		registerPage.inputToEmail(validEmail);
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 05: Input to password");
//		registerPage.inputToPassword(validPassword);
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 06: Input to confirm password");
//		registerPage.inputToConfirmPassword(confirmPassword);
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 07: Click to Register button");
//		registerPage.clickToRegisterButton();
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 08: Verify message");
//		Assert.assertEquals(registerPage.getRegisterSuccess(), "Your registration completed..");
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 09: Click on Logout link");
//		homePage = registerPage.clickToLogoutLink();
//		ExtentManager.endTest();
	}

	@Test
	public void Login_02_Login(Method method) {
//		ExtentManager.startTest(method.getName(), "Login_02_Login");
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Click on Logout link");
//		homePage = registerPage.clickToLogoutLink();
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 02: Click on Login link");
//		loginPage = homePage.clickOnLoginLink();
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 03: Input to email");
//		loginPage.inputToEmailTextBox(validEmail);
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 04: Input to password");
//		loginPage.inputToPasswordTextBox(validPassword);
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 05: Click on Login button");
//		homePage = loginPage.clickOnLoginButton();
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 06: Verify My Account link display");
//		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 07: Click on My Account link");
//		customerInforPage = homePage.clickOnMyAccountLink();
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 08: Verify Customer Infor page display");
//		Assert.assertEquals(customerInforPage.getMyAccountTitle(), "My account - Customer info..");
//		ExtentManager.endTest();
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
