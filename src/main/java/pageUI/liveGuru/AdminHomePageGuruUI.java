package pageUI.liveGuru;

public class AdminHomePageGuruUI {
	public static final String POPUP = "css=div#message-popup-window";
	public static final String CLOSE_POPUP = "xpath=//a[@title='close']";
	public static final String COLUMN_NAME = "XPATH=//thead//span[text()='%s']/ancestor::th/preceding-sibling::th";
	public static final String TEXTBOX_BY_COLUMN_NAME_ROW_NUMBER = "XPATH=//thead/tr[%s]/th[%s]//input";
	public static final String CELL_BY_COLUMN_NAME_ROW_NUMBER = "XPATH=//div[@class='grid']//tbody/tr[%s]/td[%s]";
	public static final String CELL_BY_COLUMN_NAME = "XPATH=//div[@class='grid']//tbody/tr/td[%s]";
	public static final String LOADING_ICON = "ID=loading-mask";
	
}
