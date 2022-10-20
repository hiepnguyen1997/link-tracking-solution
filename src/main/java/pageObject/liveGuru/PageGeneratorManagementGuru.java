package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManagementGuru {
	
	public static UserHomePageGuruObject getHonePage(WebDriver driver) {
		return new UserHomePageGuruObject(driver);
	}
	
	public static UserLoginPageGuruObject getLoginPage(WebDriver driver) {
		return new UserLoginPageGuruObject(driver);
	}
	
	public static UserRegisterPageGuruObject getRegisterPage(WebDriver driver) {
		return new UserRegisterPageGuruObject(driver);
	}

	public static UserAccountPageObjectGuru getAccountPage(WebDriver driver) {
		return new UserAccountPageObjectGuru(driver);
	}
	
	public static AdminUserLoginPageGuruObject getAminLoginPage(WebDriver driver) {
		return new AdminUserLoginPageGuruObject(driver);
	}
	
	public static AdminHomePageGuruObject getAdminHomePage(WebDriver driver) {
		return new AdminHomePageGuruObject(driver);
	}
}
