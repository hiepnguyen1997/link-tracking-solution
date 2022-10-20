package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.liveGuru.UserRegisterPageGuruUI;

public class UserRegisterPageGuruObject extends BasePage{
	private WebDriver driver;
	public UserRegisterPageGuruObject(WebDriver driver) {
		this.driver = driver;
	}
	public void inputToTextboxByName(String nameTextbox, String textValue) {
		waitForElementVisible(driver, UserRegisterPageGuruUI.TEXTBOX_BY_NAME, nameTextbox);
		sendkeyToElement(driver, UserRegisterPageGuruUI.TEXTBOX_BY_NAME, textValue, nameTextbox);
		
	}
	public UserAccountPageObjectGuru clickOnRegisterButton() {
		waitForElementClickabled(driver, UserRegisterPageGuruUI.REGISERTER_BUTTON);
		clickToElement(driver, UserRegisterPageGuruUI.REGISERTER_BUTTON);
		return PageGeneratorManagementGuru.getAccountPage(driver);
	}

}
