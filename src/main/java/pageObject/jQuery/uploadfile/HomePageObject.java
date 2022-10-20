package pageObject.jQuery.uploadfile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.jQuery.uploadfile.HomePageUIUploadFile;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoaded(String fileName) {
		waitForElementVisible(driver, HomePageUIUploadFile.FILE_NAME_LOADED, fileName);
		return isElementDisplayed(driver, HomePageUIUploadFile.FILE_NAME_LOADED, fileName);
	}

	public void clickOnStartButton() {
		waitForAllElementsVisible(driver, HomePageUIUploadFile.START_BUTTON);
		List<WebElement> allStartButton = getListWebElement(driver, HomePageUIUploadFile.START_BUTTON);
		for (WebElement startButton : allStartButton) {
			startButton.click();
			sleepInSecond(2);
		}
	}

	public boolean isLinkFileByNameDisplay(String fileName) {
		waitForElementVisible(driver, HomePageUIUploadFile.LINK_FILE_NAME_UPLOADED, fileName);
		return isElementDisplayed(driver, HomePageUIUploadFile.LINK_FILE_NAME_UPLOADED, fileName);
	}
	
	public boolean isUploadedFileImageByNameDisplay(String fileName) {
		waitForElementVisible(driver, HomePageUIUploadFile.IMAGE_UPLOADED, fileName);
		return isImageLoaded(driver, HomePageUIUploadFile.IMAGE_UPLOADED, fileName);
	}

	
}
