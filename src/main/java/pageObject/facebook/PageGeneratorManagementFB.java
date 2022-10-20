package pageObject.facebook;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManagementFB {
	
	public static LoginPageFBObject getLoginPage(WebDriver driver) {
		return new LoginPageFBObject(driver);
	}
}
