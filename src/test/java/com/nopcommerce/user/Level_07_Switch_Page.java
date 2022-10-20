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

public class Level_07_Switch_Page extends BaseTest {
	WebDriver driver;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");
	String validEmail, invalidEmail, notFoundEmail, firstName, lastName, validPassword, confirmPassword, wrongPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	private UserRewardPointsPageObject rewardPage;
	private UserMyProductReviewPageObject myProductPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName) throws BrowserNotSupport {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		validEmail = "automation" + getRandomNumber() + "@gmail.com";
		firstName = "Automation";
		lastName = "FC";
		validPassword = "123456";
		confirmPassword = "123456";
	}

	@Test
	public void Login_01_Regiester() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFistName(firstName);
		registerPage.inputToLastName(lastName);
		registerPage.inputToEmail(validEmail);
		registerPage.inputToPassword(validPassword);
		registerPage.inputToConfirmPassword(confirmPassword);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void Login_02_Login() {
		loginPage = homePage.clickOnLoginLink();
		loginPage.inputToEmailTextBox(validEmail);
		loginPage.inputToPasswordTextBox(validPassword);
		homePage = loginPage.clickOnLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void TC_03_Customer_Infor() {
		customerInforPage = homePage.clickOnMyAccountLink();
		Assert.assertEquals(customerInforPage.getMyAccountTitle(), "My account - Customer info");
	}

	@Test
	public void TC_04_Switch_Page_UI() {
		addressPage = customerInforPage.openAddressPage();
//		myProductPage = addressPage.openMyProdcutPage();
//		rewardPage = myProductPage.openRewardPage();
		addressPage = rewardPage.openAddressPage();
		customerInforPage = homePage.clickOnMyAccountLink();
	}

	@Test
	public void TC_05_Valid_Email_Incorrect_Password() {
	}

	@Test
	public void TC_06_Login_Success() {
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
