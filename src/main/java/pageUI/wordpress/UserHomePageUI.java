package pageUI.wordpress;

public class UserHomePageUI {
	public static final String POST_TITLE = "xpath=//article[contains(@class,'status-publish')]//a[text()='%s']";
	public static final String POST_BODY_BY_TITLE = "xpath=//article[contains(@class,'status-publish')]//a[text()='%s']/ancestor::header/following-sibling::div/p[text()='%s']";
	public static final String CURRENET_DATE_BY_TITLE = "xpath=//article[contains(@class,'status-publish')]//a[text()='%s']/parent::h2/following-sibling::div//time[text()='%s']";
	public static final String AUTOR_BY_TITLE = "xpath=//article[contains(@class,'status-publish')]//a[text()='%s']/parent::h2/following-sibling::div//a[text()='%s']";
	public static final String SEARCH_BOX = "css=section.widget_search input.search-field";
	public static final String SEARCH_BUTTON = "css=section.widget_search input.search-submit";

}
