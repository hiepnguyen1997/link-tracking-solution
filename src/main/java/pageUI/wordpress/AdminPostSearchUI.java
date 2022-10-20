package pageUI.wordpress;

public class AdminPostSearchUI {
	public static final String ADD_NEW_BUTTON = "css=a.page-title-action";
	public static final String SEARCH_TEXTBOX = "css=input#post-search-input";
	public static final String SEARCH_BUTTON = "css=input#search-submit";
	public static final String HEADER_TABLE_BY_NAME = "xpath=//table[contains(@class,'table-view-list posts')]//thead//th[@id='%s']/preceding-sibling::*";
	public static final String TABLE_ROW_VALUE_BY_INDEX_HEADER = "xpath=//table[contains(@class,'table-view-list posts')]//tbody/tr/*[%s]//a[text()='%s']";
	public static final String POST_CHECKBOX_BY_TITLE = "xpath=//table[contains(@class,'table-view-list posts')]//tbody//a[@class='row-title' and text()='%s']/ancestor::td/preceding-sibling::th/input";
	public static final String ACTION_DROPDOWN = "xpath=//select[@id='bulk-action-selector-top']";
	public static final String APPLY_BUTTON = "css=div.tablenav.top input.button.action";
	public static final String MOVE_TO_TRASH_MESSAGE = "xpath=//div[@id='message']//p[contains(text(),'%s')]";
	public static final String NO_POST_FOUND_MESSAGE = "xpath=//table[contains(@class,'table-view-list posts')]/tbody//td[text()='%s']";
	
}
