package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

public class PageGeneraterManagement {
	
	public static LoginPageObject getAdminLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
	
	public static AdminPostAddNewPageObject getAdminPostAddNewPage(WebDriver driver) {
		return new AdminPostAddNewPageObject(driver);
	}
	
	public static AdminPostSearchPageObject getAdminPostSearchPage(WebDriver driver) {
		return new AdminPostSearchPageObject(driver);
	}
	
	public static UserHomePO getUserHomePage(WebDriver driver) {
		return new UserHomePO(driver);
	}
	
	public static UserPostDetailPageObject getUserPostDetailPage(WebDriver driver) {
		return new UserPostDetailPageObject(driver);
	}
	
	public static UserSearchPageObject getUserSearchPage(WebDriver driver) {
		return new UserSearchPageObject(driver);
	}

}
