package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.liveGuru.UserLoginPageGuruUI;

public class UserLoginPageGuruObject extends BasePage{
	private WebDriver driver;
	
	public UserLoginPageGuruObject(WebDriver driver) {
		this.driver=driver;
	}

	public UserRegisterPageGuruObject clickOnCreateAccountButton() {
		waitForElementClickabled(driver, UserLoginPageGuruUI.CREATE_AN_ACCOUNT);
		clickToElement(driver, UserLoginPageGuruUI.CREATE_AN_ACCOUNT);
		return PageGeneratorManagementGuru.getRegisterPage(driver);
	}
}
