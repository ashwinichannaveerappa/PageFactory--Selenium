package com.crm.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	// loginPage class Object
	LoginPage loginPage;
	HomePage homePage;
	public  static Logger log = LogManager.getLogger(LoginPageTest.class.getName());

	public LoginPageTest(){
		super();
	}

	@BeforeMethod()
	public void setUp() {
		intialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void landingPageTitleTest() {
		log.debug("***************Starting the Test*************************");
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
		log.info("***************Completed the Test*************************");
	}

	@Test(priority = 2)
	public void crmLogoImageTest() {
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}

	
	@Test(priority = 4)
	public void loginTest() {
		loginPage.clickOnLoginLink();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
