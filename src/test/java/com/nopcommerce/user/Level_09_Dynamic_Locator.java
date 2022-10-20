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

public class Level_09_Dynamic_Locator extends BaseTest {
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

	@Parameters({"browser", "environment"})
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
	public void TC_04_Switch_Page() {
		addressPage = customerInforPage.openAddressPage();
//		myProductPage = addressPage.openMyProdcutPage();
//		rewardPage = myProductPage.openRewardPage();
//		addressPage = rewardPage.openAddressPage();
//		customerInforPage = addressPage.openCustomerPage();
	}

	@Test
	public void TC_05_Dynamic_Page_I() {
		addressPage = (UserAddressPageObject) customerInforPage.openPageAtMyAccountByName(driver, "Addresses");
		myProductPage = (UserMyProductReviewPageObject) addressPage.openPageAtMyAccountByName(driver, "My product reviews");
		rewardPage = (UserRewardPointsPageObject) myProductPage.openPageAtMyAccountByName(driver, "Reward points");
		addressPage = (UserAddressPageObject) rewardPage.openPageAtMyAccountByName(driver, "Addresses");
		customerInforPage = (UserCustomerInforPageObject) addressPage.openPageAtMyAccountByName(driver, "Customer info");
	}
	
	@Test
	public void TC_06_Dynamic_Page_II() {
		customerInforPage.openPageAtMyAccountByPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);
		addressPage.openPageAtMyAccountByPageName(driver, "My product reviews");
		myProductPage = PageGeneratorManager.getUserMyProductPage(driver);
		myProductPage.openPageAtMyAccountByPageName(driver, "Reward points");
		rewardPage = PageGeneratorManager.getUserRewardPage(driver);
		rewardPage.openPageAtMyAccountByPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);
		addressPage.openPageAtMyAccountByPageName(driver, "Customer info");
		customerInforPage = PageGeneratorManager.getUserCustomerPage(driver);
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
