package pageObject.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.FaceBook.LoginPageUI;

public class LoginPageFBObject extends BasePage{
	private WebDriver driver;
	
	public LoginPageFBObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOCreateNewAccount() {
		waitForElementVisible(driver, LoginPageUI.CREATE_NEW_ACCOUNT_LINK);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_LINK);
	}

	public void sendkeysToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public boolean isConfirmEmailTextboxDisplay() {
		waitForElementVisible(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}

	public boolean isConfirmEmailTextboxUnDisplay() {
		waitForElementUnDisplay(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
		return isElementUnDisplay(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}
}
