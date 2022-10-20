package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.wordpress.AdminLoginUI;

public class LoginPageObject extends BasePage{
	
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUserNameTextbox(String adminUserName) {
		waitForElementVisible(driver, AdminLoginUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, AdminLoginUI.USERNAME_TEXTBOX, adminUserName);
		
	}

	public void inputToPasswordeTextbox(String adminPassword) {
		waitForElementVisible(driver, AdminLoginUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginUI.PASSWORD_TEXTBOX, adminPassword);
	}

	public AdminDashboardPageObject clickOnLoginButton() {
		waitForElementClickabled(driver, AdminLoginUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginUI.LOGIN_BUTTON);
		return PageGeneraterManagement.getAdminDashboardPage(driver);
	}

}
