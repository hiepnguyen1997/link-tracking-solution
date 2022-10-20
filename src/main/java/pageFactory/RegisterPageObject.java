package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class RegisterPageObject extends BasePageFactory{
	private WebDriver driver;
	
	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmPassword;
	
	@FindBy(xpath = "//span[@id='FirstName-error']")
	private WebElement errorMessageFirstName;
	
	@FindBy(xpath = "//span[@id='LastName-error']")
	private WebElement errorMessageLastName;
	
	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement errorMessageEmail;
	
	@FindBy(xpath = "//span[@id='Password-error']")
	private WebElement errorMessagePassword;
	
	@FindBy(xpath = "//span[@id='ConfirmPassword-error']")
	private WebElement errorMessageConfirmPassword;
	
	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
	private WebElement invalidEmailErrorMessage;
	
	@FindBy(xpath = "//li[text()='The specified email already exists']")
	private WebElement existingEmailErrorMessage;
	
	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerSuccessMessage;
	
	@FindBy(xpath = "//button[@id='register-button']")
	private WebElement registerButton;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public void clickToRegisterButton() {
		waitForElementClickabled(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getErrorMessageFirstName() {
		waitForElementVisible(driver, errorMessageFirstName);
		return getElementText(driver, errorMessageFirstName);
	}

	public String getErrorMessageLastName() {
		waitForElementVisible(driver, errorMessageLastName);
		return getElementText(driver, errorMessageLastName);
	}

	public String getErrorMessageEmail() {
		waitForElementVisible(driver, errorMessageEmail);
		return getElementText(driver, errorMessageEmail);
	}

	public String getErrorMessagePassword() {
		waitForElementVisible(driver, errorMessagePassword);
		return getElementText(driver, errorMessagePassword);
	}

	public String getErrorMessageConfirmPassword() {
		waitForElementVisible(driver, errorMessageConfirmPassword);
		return getElementText(driver, errorMessageConfirmPassword);
	}

	public void inputToFistName(String value) {
		waitForElementVisible(driver, firstName);
		sendkeyToElement(driver, firstName, value);

	}

	public void inputToLastName(String value) {
		waitForElementVisible(driver, lastName);
		sendkeyToElement(driver, lastName, value);

	}

	public void inputToEmail(String value) {
		waitForElementVisible(driver, email);
		sendkeyToElement(driver, email, value);

	}

	public void inputToConfirmPassword(String value) {
		waitForElementVisible(driver, confirmPassword);
		sendkeyToElement(driver, confirmPassword, value);

	}

	public void inputToPassword(String value) {
		waitForElementVisible(driver, password);
		sendkeyToElement(driver, password, value);

	}

	public String getErrorInvalidMail() {
		waitForElementVisible(driver, invalidEmailErrorMessage);
		return getElementText(driver, invalidEmailErrorMessage);
	}

	public String getRegisterSuccess() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}

	public void clickToLogoutLink() {
		waitForElementClickabled(driver, logoutLink);
		clickToElement(driver, logoutLink);

	}

	public boolean isExistingEmailErrorDisplayed() {
		waitForElementVisible(driver, existingEmailErrorMessage);
		return isElementDisplayed(driver, existingEmailErrorMessage);
	}

}
