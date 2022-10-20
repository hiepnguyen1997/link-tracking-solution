package pageObject.SauceLab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.SauceLab.ProductPageUI;

public class ProductPageObject extends BasePage {
	private WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInProductContainser(String textItem) {
		waitForElementClickabled(driver, ProductPageUI.PRODUCT_SORT_CONTAINER);
		selectItemInDefaultDropdown(driver, ProductPageUI.PRODUCT_SORT_CONTAINER, textItem);
	}

	public boolean isValueSortAscending() {
		ArrayList<String> productNameAtUI = new ArrayList<String>();
		List<WebElement> productName = getListWebElement(driver, ProductPageUI.PRODUCT_NAME);
		for (WebElement element : productName) {
			productNameAtUI.add(element.getText().trim());
		}
		ArrayList<String> productNameConvert = new ArrayList<String>();
		for (String item : productNameAtUI) {
			productNameConvert.add(item);
		}
		Collections.sort(productNameConvert);
		return productNameConvert.equals(productNameAtUI);
	}

	public boolean isValueSortDecending() {
		ArrayList<String> productNameAtUI = new ArrayList<String>();
		List<WebElement> productName = getListWebElement(driver, ProductPageUI.PRODUCT_NAME);
		for (WebElement element : productName) {
			productNameAtUI.add(element.getText().trim());
		}
		ArrayList<String> productNameConvert = new ArrayList<String>();
		for (String item : productNameAtUI) {
			productNameConvert.add(item);
		}
		Collections.sort(productNameConvert);
		Collections.reverse(productNameConvert);
		return productNameConvert.equals(productNameAtUI);
	}

	public boolean isPriceSortAscending() {
		ArrayList<Float> productPriceAtUI = new ArrayList<Float>();
		List<WebElement> productPrice = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE);
		for (WebElement element : productPrice) {
			productPriceAtUI.add(Float.parseFloat(element.getText().trim().replace("$", "")));
		}
		ArrayList<Float> productNameConvert = new ArrayList<Float>();
		for (Float item : productPriceAtUI) {
			productNameConvert.add(item);
		}
		Collections.sort(productNameConvert);
		return productNameConvert.equals(productPriceAtUI);
	}

	public boolean isPriceSortDecending() {
		ArrayList<Float> productPriceAtUI = new ArrayList<Float>();
		List<WebElement> productPrice = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE);
		for (WebElement element : productPrice) {
			productPriceAtUI.add(Float.parseFloat(element.getText().trim().replace("$", "")));
		}
		ArrayList<Float> productPriceConvert = new ArrayList<Float>();
		for (Float item : productPriceAtUI) {
			productPriceConvert.add(item);
		}
		Collections.sort(productPriceConvert);
		Collections.reverse(productPriceConvert);
		return productPriceConvert.equals(productPriceAtUI);
	}
}
