package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory {
	private WebDriver driver;
	
	@FindBy(xpath = "//button[contains(@class,'login-button')]")
	private WebElement loginButton;
	
	@FindBy(xpath = "//input[@class='email']")
	private WebElement emailTextBox;
	
	@FindBy(xpath = "//input[@class='password']")
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//span[@data-valmsg-for='Email']")
	private WebElement errorMessageEmailTextBox;
	
	@FindBy(xpath = "//div[contains(@class,'message-error')]")
	private WebElement invalidErrorMessage;

	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnLoginButton() {
		waitForElementClickabled(driver, loginButton);
		clickToElement(driver, loginButton);

	}

	public String getErrorMessageEmailTexbox() {
		waitForElementVisible(driver, errorMessageEmailTextBox);
		return getElementText(driver, errorMessageEmailTextBox);
	}

	public String getInvalidErrorMessage() {
		waitForElementVisible(driver, invalidErrorMessage);
		return getElementText(driver, invalidErrorMessage);
	}

	public void inputToPasswordTextBox(String value) {
		waitForElementVisible(driver, passwordTextBox);
		sendkeyToElement(driver, passwordTextBox, value);
	}

	public void inputToEmailTextBox(String value) {
		waitForElementVisible(driver, emailTextBox);
		sendkeyToElement(driver, emailTextBox, value);
	}
}
