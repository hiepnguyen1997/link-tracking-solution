package com.liveGuru;

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
import pageObject.jQuery.datatable.HomePageObject;
import pageObject.jQuery.datatable.PageGenerateManagementTable;
import pageObject.liveGuru.AdminHomePageGuruObject;
import pageObject.liveGuru.AdminUserLoginPageGuruObject;
import pageObject.liveGuru.PageGeneratorManagementGuru;
import pageObject.liveGuru.UserAccountPageObjectGuru;
import pageObject.liveGuru.UserHomePageGuruObject;
import pageObject.liveGuru.UserLoginPageGuruObject;
import pageObject.liveGuru.UserRegisterPageGuruObject;
import pageUI.liveGuru.AdminHomePageGuruUI;

public class Level_10_LiveGuru extends BaseTest {
	WebDriver driver;
	WebDriverWait explicitWait;
	private UserHomePageGuruObject userHonePage;
	private UserLoginPageGuruObject userLoginPage;
	private UserRegisterPageGuruObject userRegisterPage;
	private UserAccountPageObjectGuru userAccountPage;
	private AdminUserLoginPageGuruObject adminLoginPage;
	private AdminHomePageGuruObject adminHomePage;
	private String fullName,firstName, lastName, emailAddress, password;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName, String appURL) throws BrowserNotSupport {
		driver = getBrowserDriver(browserName);
		userHonePage = PageGeneratorManagementGuru.getHonePage(driver);
		driver.manage().window().maximize();
		driver.get(appURL);
		firstName = "Hiep" + getRandomNumber();
		lastName = "Nguyen";
		fullName = firstName + " " +lastName;
		emailAddress = "tuyennong" + getRandomNumber() + "@gmail.com";
		password = "123456";
	}

	@Test
	public void TC_01_Register_Account() {
		userLoginPage = userHonePage.clickOnMyAccountLink();
		userRegisterPage = userLoginPage.clickOnCreateAccountButton();
		userRegisterPage.inputToTextboxByName("firstname", firstName);
		userRegisterPage.inputToTextboxByName("lastname", lastName);
		userRegisterPage.inputToTextboxByName("email_address", emailAddress);
		userRegisterPage.inputToTextboxByName("password", password);
		userRegisterPage.inputToTextboxByName("confirmation", password);
		userAccountPage = userRegisterPage.clickOnRegisterButton();
		Assert.assertTrue(userAccountPage.isRegisterSuccessMessageDisplay());
		
	}

	@Test
	public void TC_02_Login_Admin_Role() {
		userAccountPage.openPageUrl(driver, "http://live.techpanda.org/index.php/backendlogin/customer/");
		adminLoginPage = PageGeneratorManagementGuru.getAminLoginPage(driver);
		adminHomePage = adminLoginPage.loginAsAdmin("user01", "guru99com");
	}

	@Test
	public void TC_03_Handle_Data_Table() {
		adminHomePage.closeMessagePopup();
		Assert.assertFalse(adminHomePage.messagePopupDisplay());
//		adminHomePage.inputToTextboxByColumnNameRowNumber("Name", "2", fullName);
//		adminHomePage.inputToTextboxByColumnNameRowNumber("Email", "2", emailAddress);
//		adminHomePage.sendKeyBoardToToTextboxByColumnNameRowNumber("Email", "2");
//		adminHomePage.waitForLoadingIconNotPresence();
//		Assert.assertEquals(adminHomePage.getTextByByColumnNameRowNumber("Name", "1"), fullName);
//		Assert.assertEquals(adminHomePage.getTextByByColumnNameRowNumber("Email", "1"), emailAddress);
		Assert.assertTrue(adminHomePage.isCellByColumnNameContainsText("Email", emailAddress));
		
		
	}

	@Test
	public void TC_04_Input_To_Textbox_By_ColumnName_RowNumber() {
	}

	@Test
	public void TC_05_Dynamic_Page_I() {
	}
	
	@Test
	public void TC_06_Dynamic_Page_II() {
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
