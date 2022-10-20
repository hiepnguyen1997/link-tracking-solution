package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.liveGuru.UserAccountPageGuruUI;

public class UserAccountPageObjectGuru extends BasePage{
	private WebDriver driver;
	public UserAccountPageObjectGuru(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isRegisterSuccessMessageDisplay() {
		return isElementDisplayed(driver, UserAccountPageGuruUI.REGISETR_SUCCESSFULLY_MESSAGE);
	}

}
