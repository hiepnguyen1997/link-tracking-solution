package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage{
	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String emailValue) {
			waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX_ADMIN_PAGE);
			sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX_ADMIN_PAGE, emailValue);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX_ADMIN_PAGE);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX_ADMIN_PAGE, password);
	}

	public AdminDashboardPageObject clickOnLoginButton() {
		waitForElementVisible(driver, AdminLoginPageUI.LOGIN_BUTTON_ADMIN_PAGE);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON_ADMIN_PAGE);
		return PageGeneratorManager.getAdminDashboardPage(driver);
		
	}

	public AdminDashboardPageObject loginAsAdmin(String email, String password) {
		inputToEmailTextbox(email);
		inputToPasswordTextbox(password);
		return clickOnLoginButton();
	}
	

}
