package pageUI.wordpress;

public class UserPostDetailPageUI {
	
	public static final String POST_TITLE = "xpath=//article[contains(@class,'status-publish')]//h1[text()='%s']";
	public static final String POST_BODY_BY_TITLE = "xpath=//article[contains(@class,'status-publish')]//h1[text()='%s']/parent::header/following-sibling::div/p[text()='%s']";
	public static final String CURRENET_DATE_BY_TITLE = "xpath=//article[contains(@class,'status-publish')]//h1[text()='%s']/following-sibling::div//time[text()='%s']";
	public static final String AUTOR_BY_TITLE = "xpath=//article[contains(@class,'status-publish')]//h1[text()='%s']/following-sibling::div//a[text()='%s']";


}
