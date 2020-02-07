package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CreateNewContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	CreateNewContactPage createContactPage;
	TestUtil testUtil;
	String sheetName="contacts";
	
	public ContactsPageTest(){
		//to call TestBase Class constructor
		super();
		}
	
	
	@BeforeMethod
	public void setUp(){
		intialization();
		loginPage=new LoginPage();
		contactsPage=new ContactsPage();
		createContactPage=new CreateNewContactPage();
		testUtil =new TestUtil();
		loginPage.clickOnLoginLink();
		
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage=homePage.clickOnContactsLink();
	}
	
	@Test(priority = 1)
	public void verifyContactsPageLabelTest(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts Label is missing on the Page");
	}
	
	@Test(priority = 2)
	public void selectSingleContactTest() {
		contactsPage.selectContactsByName("Ashwini C");
	}
	
	@Test(priority = 3)
	public void selectMultipleContactTest() {
		contactsPage.selectContactsByName("Ashwini C");
		contactsPage.selectContactsByName("test test");
	}
	
	@DataProvider
	public Object[][] getCRMContactData() throws EncryptedDocumentException, IOException{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 4,dataProvider = "getCRMContactData")
		public void validateCreateNewContact(String firstName, String lastName, String Company) {
		contactsPage.clickOnNewContactLink();
		createContactPage.createNewContact(firstName, lastName, Company);
	}
	
	

	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
