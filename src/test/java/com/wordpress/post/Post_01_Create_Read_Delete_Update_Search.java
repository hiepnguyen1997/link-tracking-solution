package com.wordpress.post;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import exception.BrowserNotSupport;
import pageObjects.wordpress.AdminDashboardPageObject;
import pageObjects.wordpress.AdminPostAddNewPageObject;
import pageObjects.wordpress.AdminPostSearchPageObject;
import pageObjects.wordpress.LoginPageObject;
import pageObjects.wordpress.PageGeneraterManagement;
import pageObjects.wordpress.UserHomePO;
import pageObjects.wordpress.UserPostDetailPageObject;
import pageObjects.wordpress.UserSearchPageObject;

public class Post_01_Create_Read_Delete_Update_Search extends BaseTest{
	WebDriver driver;
	private String adminUserName = "automationFC";
	private String adminPassword = "automationFC";
	private String authorName = "Automation Admin";
	int randNumber = generatorNumber();
	private String postTitle = "Live Coding Title " + randNumber;
	private String postBody = "Live Coding Body " + randNumber;
	private String editTitle = "Nong Title " + randNumber;
	private String editBody = "Nong Body " + randNumber;
	private String adminURL, endUserURL;
	private String currentDay = getToday();
	
	String postSearchURL;
	LoginPageObject adminLoginPage;
	AdminDashboardPageObject adminDashboardPage;
	AdminPostAddNewPageObject adminPostAddNewPage;
	AdminPostSearchPageObject adminPostSearchPage;
	UserHomePO userHomePage;
	UserPostDetailPageObject userPostDetailPage;
	UserSearchPageObject userSearchPage;
	
	@Parameters({"browser","urlAdmin", "urlUser"})
	@BeforeClass
	public void beforeClass(String browserName, String adminURL, String endUserURL) throws BrowserNotSupport {
		this.adminURL = adminURL;
		this.endUserURL = endUserURL;
		driver = getBrowserDriver(browserName, this.adminURL);
		log.info("Pre-Condition: Step 01 - Open browser and navigate to url Admin");
		adminLoginPage = PageGeneraterManagement.getAdminLoginPage(driver);
		
		log.info("Pre-Condition: Step 02 - Input to User textbox with value: " + adminUserName);
		adminLoginPage.inputToUserNameTextbox(adminUserName);
		
		log.info("Pre-Condition: Step 03 - Input to Password textbox value: " + adminPassword);
		adminLoginPage.inputToPasswordeTextbox(adminPassword);
		
		log.info("Pre-Condition: Step 04 - Click on Login button");
		adminDashboardPage = adminLoginPage.clickOnLoginButton();
	}
	
	@Test
	public void TC_01_Create_New_Post() {
		log.info("Create_Post - Step 01: Click on Post menu link");
		adminPostSearchPage = adminDashboardPage.clickOnPostMenuLink();
		
		log.info("Create_Post - Step 02: Get Post Search Page url");
		postSearchURL = adminPostSearchPage.getPageUrl(driver);
		
		log.info("Create_Post - Step 03: Click on Add New button");
		adminPostAddNewPage = adminPostSearchPage.clickOnAddNewButton();
		
		log.info("Create_Post - Step 04: Input to title");
		adminPostAddNewPage.inputToNewPostTitle(postTitle);
		
		log.info("Create_Post - Step 05: Input to body");
		adminPostAddNewPage.inputToNewPostBody(postBody);
		
		log.info("Create_Post - Step 06: Click on Pushlic button");
		adminPostAddNewPage.clickOnPushButton();
		
		log.info("Create_Post - Step 07: Click on Pre Pushlic button");
		adminPostAddNewPage.clickOnPrePushButton();
		
		log.info("Create_Post - Step 08: Verify Push Public display");
		verifyTrue(adminPostAddNewPage.isPushPublicisDisplay("Post published."));
	}
	
	@Test
	public void TC_02_Search_Post_And_View_Post() {
		log.info("Search_Post - Step 01: Open Post Search page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPage(postSearchURL);
		adminPostSearchPage.inputToSearchBox(postTitle);
		
		log.info("Search_Post - Step 02: Input to Search Post");
		adminPostSearchPage.inputToSearchBox(postTitle);
		
		log.info("Search_Post - Step 03: Click on Search button");
		adminPostSearchPage.clickOnSearchButton();

		log.info("Search_Post - Step 04: Verify search table contains '" + postTitle + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplay("title", postTitle));
		
		log.info("Search_Post - Step 05: Verify search table contains '" + authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplay("author", authorName));
		
		log.info("Search_Post - Step 06: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserURL);
		
		log.info("Search_Post - Step 07: Verify Post title display in Home Page");
		verifyTrue(userHomePage.isPostInforDisplayInHomePage(postTitle));
		verifyTrue(userHomePage.isPostInforBodyDisplayInHomePage(postTitle, postBody));
		verifyTrue(userHomePage.isPostInforAuthorDisplayInHomePage(postTitle, authorName));
		verifyTrue(userHomePage.isPostInforCurrentDayDisplayInHomePage(postTitle, currentDay));
		
		log.info("Search_Post - Step 08: Click on Post title");
		userPostDetailPage = userHomePage.clicnOnPostTitle(postTitle);
		
		log.info("Search_Post - Step 09: Verify Post infor display at Post detail page");
		verifyTrue(userPostDetailPage.isPostInforDisplayInDetailPage(postTitle));
		verifyTrue(userPostDetailPage.isPostInforBodyDisplayInDetaiPage(postTitle, postBody));
		verifyTrue(userPostDetailPage.isPostInforAuthorDisplayInDetaiPage(postTitle, authorName));
		verifyTrue(userPostDetailPage.isPostInforCurrentDayDisplayInDetaiPage(postTitle, currentDay));
	}
	
	@Test
	public void TC_03_Edit_Post() {
		log.info("Edit_Post - Step 01: Open Admin Site");
		adminDashboardPage = userPostDetailPage.openAdminSite(driver, this.adminURL);
		log.info("Edit_Post - Step 02: Click on Post menu link");
		adminPostSearchPage = adminDashboardPage.clickOnPostMenuLink();
		log.info("Edit_Post - Step 03: Input to Search textbox");
		adminPostSearchPage.inputToSearchBox(postTitle);
		log.info("Edit_Post - Step 03: Click on Search button");
		adminPostSearchPage.clickOnSearchButton();
		log.info("Edit_Post - Step 03: Click on Post title and navigate to Post Edit page");
		adminPostAddNewPage = adminPostSearchPage.clickOnCellByIDName("title", postTitle);
		log.info("Edit_Post - Step 04: Input to title");
		adminPostAddNewPage.inputToNewPostTitle(editTitle);
		
		log.info("Edit_Post - Step 05: Input to body");
		adminPostAddNewPage.editPostBody(editBody);
		
		log.info("Edit_Post - Step 06: Click on Pushlic button");
		adminPostAddNewPage.clickOnPushButton();
		
		log.info("Edit_Post - Step 08: Verify Push Public display");
		verifyTrue(adminPostAddNewPage.isPushPublicisDisplay("Post updated."));
		
		
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPage(postSearchURL);
		
		log.info("Search_Post - Step 02: Input to Search Post");
		adminPostSearchPage.inputToSearchBox(editTitle);
		
		log.info("Search_Post - Step 03: Click on Search button");
		adminPostSearchPage.clickOnSearchButton();

		log.info("Search_Post - Step 04: Verify search table contains '" + editTitle + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplay("title", editTitle));
		
		log.info("Search_Post - Step 05: Verify search table contains '" + authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplay("author", authorName));
		
		log.info("Search_Post - Step 06: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserURL);
		
		log.info("Search_Post - Step 07: Verify Post title display in Home Page");
		verifyTrue(userHomePage.isPostInforDisplayInHomePage(editTitle));
		verifyTrue(userHomePage.isPostInforBodyDisplayInHomePage(editTitle, editBody));
		verifyTrue(userHomePage.isPostInforAuthorDisplayInHomePage(editTitle, authorName));
		verifyTrue(userHomePage.isPostInforCurrentDayDisplayInHomePage(editTitle, currentDay));
		
		log.info("Search_Post - Step 08: Click on Post title");
		userPostDetailPage = userHomePage.clicnOnPostTitle(editTitle);
		
		log.info("Search_Post - Step 09: Verify Post infor display at Post detail page");
		verifyTrue(userPostDetailPage.isPostInforDisplayInDetailPage(editTitle));
		verifyTrue(userPostDetailPage.isPostInforBodyDisplayInDetaiPage(editTitle, editBody));
		verifyTrue(userPostDetailPage.isPostInforAuthorDisplayInDetaiPage(editTitle, authorName));
		verifyTrue(userPostDetailPage.isPostInforCurrentDayDisplayInDetaiPage(editTitle, currentDay));
	}
	
	@Test
	public void TC_04_Delete_Post() {
		log.info("Delete_Post - Step 01: Open Admin Site");
		adminDashboardPage = userPostDetailPage.openAdminSite(driver, this.adminURL);
		log.info("Delete_Post - Step 02: Click on Post menu link");
		adminPostSearchPage = adminDashboardPage.clickOnPostMenuLink();
		log.info("Delete_Post - Step 03: Input to Search textbox");
		adminPostSearchPage.inputToSearchBox(editTitle);
		log.info("Delete_Post - Step 04: Click on Search button");
		adminPostSearchPage.clickOnSearchButton();
		log.info("Delete_Post - Step 05: Click on Post detail checkbox");
		adminPostSearchPage.clickOnPostDetailCheckboxByTitle(editTitle);
		log.info("Delete_Post - Step 06: Select Move To Trash item in dropdoown");
		adminPostSearchPage.selectTextIteminActionDropdown("Move to Trash");
		log.info("Delete_Post - Step 07: Click on Apply button");
		adminPostSearchPage.clickOnApplyButton();
		log.info("Delete_Post - Step 08: Verify delete message");
		verifyTrue(adminPostSearchPage.isMoveToTrashMessageDisplayed("1 post moved to the Trash."));
		log.info("Delete_Post - Step 09: Input to Search textbox");
		adminPostSearchPage.inputToSearchBox(editTitle);
		log.info("Delete_Post - Step 10: Click on Search button");
		adminPostSearchPage.clickOnSearchButton();
		log.info("Delete_Post - Step 11: Verify not found message");
		verifyTrue(adminPostSearchPage.isNoPostFoundMessageDisplayed("No posts found."));
		log.info("Delete_Post - Step 12: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserURL);
		
		log.info("Delete_Post - Step 13: Verify Post title undisplay in Home Page");
		verifyTrue(userHomePage.isPostInforUnDisplayInHomePage(editTitle));
		log.info("Delete_Post - Step 14: Input to searchbox");
		userHomePage.inputToSearchbox(editTitle);
		log.info("Delete_Post - Step 15: Click search button");
		userSearchPage = userHomePage.clickOnSearchButton();
		log.info("Delete_Post - Step 16: Verify Not found");
		verifyTrue(userSearchPage.isNotFoundMessageDisplay("Nothing Found"));
		
		
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
	

}
