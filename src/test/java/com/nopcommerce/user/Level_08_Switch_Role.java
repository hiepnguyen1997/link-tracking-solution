//package com.nopcommerce.user;
//
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
//import commons.BaseTest;
//import commons.GlobalConstants;
//import commons.PageGeneratorManager;
//import exception.BrowserNotSupport;
//import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
//import pageObjects.nopCommerce.admin.AdminLoginPageObject;
//import pageObjects.nopCommerce.portal.UserAddressPageObject;
//import pageObjects.nopCommerce.portal.UserCustomerInforPageObject;
//import pageObjects.nopCommerce.portal.UserHomePageObject;
//import pageObjects.nopCommerce.portal.UserLoginPageObject;
//import pageObjects.nopCommerce.portal.UserMyProductReviewPageObject;
//import pageObjects.nopCommerce.portal.UserRegisterPageObject;
//import pageObjects.nopCommerce.portal.UserRewardPointsPageObject;
//
//public class Level_08_Switch_Role extends BaseTest {
//	WebDriver driver;
//	WebDriverWait explicitWait;
//	String projectPath = System.getProperty("user.dir");
//	String validEmail, firstName, lastName, validPassword, confirmPassword, adminEmail, adminPassword;
//	private UserHomePageObject userHomePage;
//	private UserRegisterPageObject userRegisterPage;
//	private UserLoginPageObject userLoginPage;
//	private AdminLoginPageObject adminLoginPage;
//	private AdminDashboardPageObject adminDashboardPage;
//	private UserCustomerInforPageObject customerPage;
//	private UserMyProductReviewPageObject myProductPage;
//
//	@Parameters("browser")
//	@BeforeClass
//	public void beforeClass(@Optional("chrome") String browserName) throws BrowserNotSupport {
//		driver = getBrowserDriver(browserName);
//		userHomePage = PageGeneratorManager.getUserHomePage(driver);
//		driver.manage().window().maximize();
//		driver.get("https://demo.nopcommerce.com/");
//		validEmail = "automation" + getRandomNumber() + "@gmail.com";
//		firstName = "Automation";
//		lastName = "FC";
//		validPassword = "123456";
//		confirmPassword = "123456";
//		adminEmail = "admin@yourstore.com";
//		adminPassword = "admin";
//	}
//
//	@Test
//	public void Login_01_Regiester() {
//		userRegisterPage = userHomePage.clickToRegisterLink();
//		userRegisterPage.inputToFistName(firstName);
//		userRegisterPage.inputToLastName(lastName);
//		userRegisterPage.inputToEmail(validEmail);
//		userRegisterPage.inputToPassword(validPassword);
//		userRegisterPage.inputToConfirmPassword(confirmPassword);
//		userRegisterPage.clickToRegisterButton();
//		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
//		userHomePage = userRegisterPage.clickToLogoutLink();
//	}
//
//	@Test
//	public void Login_02_Login_Role_User() {
//		userLoginPage = userHomePage.clickOnLoginLink();
//		userHomePage = userLoginPage.loginAsUser(validEmail, validPassword);
//		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
//		customerPage = userHomePage.clickOnMyAccountLink();
//		userHomePage = customerPage.clickOnLougoutLinkUserPage(driver);
//	}
//
//	@Test
//	public void TC_03_Role_Admin() {
//		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
//		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
//		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmail, adminPassword);
//		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
//		adminLoginPage = adminDashboardPage.clickOnLougoutLinkAdminPage(driver);
//		adminLoginPage.openPageUrl(driver, GlobalConstants.USER_PAGE_URL);
//		userHomePage = PageGeneratorManager.getUserHomePage(driver);
//		userLoginPage = userHomePage.clickOnLoginLink();
//		userHomePage = userLoginPage.loginAsUser(validEmail, validPassword);
//		customerPage = userHomePage.clickOnMyAccountLink();
//		myProductPage = customerPage.openMyProdcutPage();
//		userHomePage = customerPage.clickOnLougoutLinkUserPage(driver);
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
