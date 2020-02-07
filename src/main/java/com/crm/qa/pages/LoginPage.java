package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory - Object Repository:
	@FindBy(xpath = "//span[contains(text(),'Log In')]")
	private WebElement loginLink;

	@FindBy(name = "email")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	private WebElement loginBtn;
	
	@FindBy(linkText = "Sign Up")
	private WebElement signUpBtn;
	
	@FindBy(xpath="//a[contains(@title,'free crm home')]")
	private WebElement crmLogo;
	
	
	//constructor 
	//initializing the Page Objects
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMImage()
	{
		return crmLogo.isDisplayed();
	}
	public LoginPage clickOnLoginLink()
	{
		loginLink.click();
		return new LoginPage();
	}
		
	public HomePage login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}

}
