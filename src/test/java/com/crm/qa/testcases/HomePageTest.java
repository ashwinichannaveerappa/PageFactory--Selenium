package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

/*
 * test cases should be independent 
 *before each test case  -launch the browser and login
 *@test - execute test case
 *after each test case - close the browser
 */
public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public HomePageTest(){
		//to call Baseclasss constructor
		super();
	}
	
	/*Prerequisite: launch the application -login with valid credentials : */
	
	@BeforeMethod
	public void setUp(){
		intialization();
		loginPage=new LoginPage();
		contactsPage=new ContactsPage();
		loginPage.clickOnLoginLink();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest(){
		String homePageTitle= homePage.verifyHomePageTitile();
		//Home page title not matched: message will be printed in the report only when testcase is failed
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home page title not matched");
	}
	
	@Test(priority = 2)
	public void verifyUserNameTest()
	{
		Assert.assertTrue(homePage.verifyCorrectUserName(),"Valid username displayed");
	}
	
	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		contactsPage = homePage.clickOnContactsLink();
		
	}
	
	@AfterMethod()
	public void tearDown(){
		driver.quit();
	}
	
}
