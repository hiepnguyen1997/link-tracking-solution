package pageObject.jQuery.uploadfile;

import org.openqa.selenium.WebDriver;

public class PageGenerateManagementUpload {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

}
