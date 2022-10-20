package pageUI.jQuery.datatable;

public class HomePageUI {
	//url: https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/
	public static final String NAME_TEXTBOX = "xpath=//div[text()='%s']/parent::div/following-sibling::input";
	public static final String PAGE_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String ALL_ROW_IN_EACH_PAGE = "xpath=//tbody/tr";
	public static final String ALL_PAGE = "xpath=//li[@class='qgrd-pagination-page']/a";
	
	
	//url: https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/
	public static final String LOAD_BUTTON = "id=btnLoad";
	public static final String COLUMN_BY_NAME = "XPath=//thead//td[text()='%s']/preceding-sibling::td";
	public static final String TEXTBOX_BY_COLUMN_NAME_ROW_NUMBER = "XPath=//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOW_BY_COLUMN_NAME_ROW_NUMBER = "XPath=//tbody/tr[%s]/td[%s]/select";
	public static final String CHECKBOX_BY_COLUMN_NAME_ROW_NUMBER = "XPath=//tbody/tr[%s]/td[%s]/input";
}
