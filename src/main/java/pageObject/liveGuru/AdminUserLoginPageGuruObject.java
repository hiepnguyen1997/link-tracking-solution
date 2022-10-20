package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.liveGuru.AdminLoginPageGuruUI;
import pageUIs.nopCommerce.admin.AdminDashboardPageUI;

public class AdminUserLoginPageGuruObject extends BasePage{
	
	private WebDriver driver;
	
	public AdminUserLoginPageGuruObject(WebDriver driver) {
		this.driver = driver;
	}

	public AdminHomePageGuruObject loginAsAdmin(String userName, String password) {
		waitForElementVisible(driver, AdminLoginPageGuruUI.USER_NAME);
		sendkeyToElement(driver, AdminLoginPageGuruUI.USER_NAME, userName);
		waitForElementVisible(driver, AdminLoginPageGuruUI.PASSWORD);
		sendkeyToElement(driver, AdminLoginPageGuruUI.PASSWORD, password);
		waitForElementClickabled(driver, AdminLoginPageGuruUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageGuruUI.LOGIN_BUTTON);
		return PageGeneratorManagementGuru.getAdminHomePage(driver);
	}

}
