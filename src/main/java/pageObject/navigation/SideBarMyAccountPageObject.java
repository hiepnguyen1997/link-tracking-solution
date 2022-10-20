package pageObject.navigation;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserAddressPageObject;
import pageObjects.nopCommerce.portal.UserCustomerInforPageObject;
import pageObjects.nopCommerce.portal.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.portal.UserRewardPointsPageObject;
import pageUIs.nopCommerce.user.BasePageUINopCommerce;

public class SideBarMyAccountPageObject extends BasePage{
	private WebDriver driver;
	
	public SideBarMyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public UserCustomerInforPageObject openCustomerPage() {
		waitForElementVisible(driver, BasePageUINopCommerce.CUSTOMER_INFOR_LINK);
		clickToElement(driver, BasePageUINopCommerce.CUSTOMER_INFOR_LINK);
		return PageGeneratorManager.getUserCustomerPage(driver);
	}
	
	public UserAddressPageObject openAddressPage() {
		waitForElementVisible(driver, BasePageUINopCommerce.ADDRESS_LINK);
		clickToElement(driver, BasePageUINopCommerce.ADDRESS_LINK);
		return PageGeneratorManager.getUserAddressPage(driver);
	}
	
	public UserMyProductReviewPageObject openMyProdcutPage() {
		waitForElementVisible(driver, BasePageUINopCommerce.MY_PRODUCT_LINK);
		clickToElement(driver, BasePageUINopCommerce.MY_PRODUCT_LINK);
		return PageGeneratorManager.getUserMyProductPage(driver);
	}
	
	public UserRewardPointsPageObject openRewardPage() {
		waitForElementVisible(driver, BasePageUINopCommerce.REWARD_POINTS_LINK);
		clickToElement(driver, BasePageUINopCommerce.REWARD_POINTS_LINK);
		return PageGeneratorManager.getUserRewardPage(driver);
	}

}
