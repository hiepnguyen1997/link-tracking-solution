//package com.nopcommerce.user;
//
//import java.lang.reflect.Method;
//import java.util.Random;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Optional;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.aventstack.extentreports.Status;
//
////import com.relevantcodes.extentreports.LogStatus;
//
//import commons.BaseTest;
//import commons.PageGeneratorManager;
//import exception.BrowserNotSupport;
//import io.qameta.allure.Description;
//import io.qameta.allure.Severity;
//import io.qameta.allure.SeverityLevel;
//import pageObjects.nopCommerce.portal.UserAddressPageObject;
//import pageObjects.nopCommerce.portal.UserCustomerInforPageObject;
//import pageObjects.nopCommerce.portal.UserHomePageObject;
//import pageObjects.nopCommerce.portal.UserLoginPageObject;
//import pageObjects.nopCommerce.portal.UserMyProductReviewPageObject;
//import pageObjects.nopCommerce.portal.UserRegisterPageObject;
//import pageObjects.nopCommerce.portal.UserRewardPointsPageObject;
////import reportConfig.ExtentManager;
//import reportConfig.ExtentTestManager;
//
//public class Level_15_Allure extends BaseTest {
//	WebDriver driver;
//	WebDriverWait explicitWait;
//	String validEmail, invalidEmail, notFoundEmail, firstName, lastName, validPassword, confirmPassword, wrongPassword;
//	private UserHomePageObject homePage;
//	private UserRegisterPageObject registerPage;
//	private UserLoginPageObject loginPage;
//	private UserCustomerInforPageObject customerInforPage;
//	private UserAddressPageObject addressPage;
//	private UserRewardPointsPageObject rewardPage;
//	private UserMyProductReviewPageObject myProductPage;
//
//	@Parameters({"browser","environment"})
//	@BeforeClass
//	public void beforeClass(@Optional("chrome") String browserName, String environmentName) throws BrowserNotSupport {
//		driver = getBrowserDriver(browserName);
//		homePage = PageGeneratorManager.getUserHomePage(driver);
//		driver.manage().window().maximize();
//		driver.get(getEnvironmentName(environmentName));
//		validEmail = "automation" + getRandomNumber() + "@gmail.com";
//		firstName = "Automation";
//		lastName = "FC";
//		validPassword = "123456";
//		confirmPassword = "123456";
//	}
//
//	@Description("Register to system")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void Login_01_Regiester(Method method) {
//		registerPage = homePage.clickToRegisterLink();
//		registerPage.inputToFistName(firstName);
//		registerPage.inputToLastName(lastName);
//		registerPage.inputToEmail(validEmail);
//		registerPage.inputToPassword(validPassword);
//		registerPage.inputToConfirmPassword(confirmPassword);
//		registerPage.clickToRegisterButton();
//		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
//	}
//
//	@Description("Login to system")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void Login_02_Login(Method method) {
//		homePage = registerPage.clickToLogoutLink();
//		loginPage = homePage.clickOnLoginLink();
//		loginPage.inputToEmailTextBox(validEmail);
//		loginPage.inputToPasswordTextBox(validPassword);
//		homePage = loginPage.clickOnLoginButton();
//		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
//		customerInforPage = homePage.clickOnMyAccountLink();
//		Assert.assertEquals(customerInforPage.getMyAccountTitle(), "My account - Customer info..");
//	}
//	
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}
//
//
//	public int getRandomNumber() {
//		Random rand = new Random();
//		return rand.nextInt(9999);
//	}
//
//}
