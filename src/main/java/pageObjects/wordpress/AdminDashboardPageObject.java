package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.wordpress.AdminDashboardUI;

public class AdminDashboardPageObject extends BasePage{
	
	private WebDriver driver;
	
	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostSearchPageObject clickOnPostMenuLink() {
		waitForElementClickabled(driver, AdminDashboardUI.POST_MENU_LINK);
		clickToElement(driver, AdminDashboardUI.POST_MENU_LINK);
		return PageGeneraterManagement.getAdminPostSearchPage(driver);
	}

}
