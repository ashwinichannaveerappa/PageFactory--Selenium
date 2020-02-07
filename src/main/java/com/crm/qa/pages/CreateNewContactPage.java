package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CreateNewContactPage extends TestBase {

	
	//Create New Contact Page - Object Repository:
	
	@FindBy(xpath="//div[@id='dashboard-toolbar']/div[contains(text(),'Create New Contact')]")
	WebElement createNewContactLabel;
	
	@FindBy(name="first_name")
	WebElement firstNameTextBox;
	
	@FindBy(name="last_name")
	WebElement lastNameTextBox;
	
	@FindBy(xpath="//div[@name='company']//input[@class='search']")
	WebElement companyTextBox;
	
	@FindBy(css = ".button.linkedin.ui.button")
	WebElement saveBtn;
	
	//Initialize the Page Factory Objects
	
	public CreateNewContactPage(){
		PageFactory.initElements(driver,this);
	}
	
	//Actions:
	
	public String verifyCreateNewPageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyCreateNewContactLabel()
	{
		return createNewContactLabel.isDisplayed();
	}
		
	
	public void createNewContact(String ftName,String ltName,String comp) {
		firstNameTextBox.sendKeys(ftName);
		lastNameTextBox.sendKeys(ltName);
		companyTextBox.click();
		companyTextBox.sendKeys(comp);
		saveBtn.click();
	}
}
