package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.liveGuru.UserHomePageGuruUI;

public class UserHomePageGuruObject extends BasePage{
	private WebDriver driver;
	
	public UserHomePageGuruObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserLoginPageGuruObject clickOnMyAccountLink() {
		waitForElementVisible(driver, UserHomePageGuruUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageGuruUI.LOGIN_LINK);
		return PageGeneratorManagementGuru.getLoginPage(driver);
	}
}
