package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.navigation.SideBarMyAccountPageObject;

public class UserRewardPointsPageObject extends SideBarMyAccountPageObject{
private WebDriver driver;
	
	public UserRewardPointsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
