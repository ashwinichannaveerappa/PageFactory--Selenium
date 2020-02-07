package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	//Contacts Page - Object Repository:
	@FindBy(xpath="//div[@id='dashboard-toolbar']/div[text()='Contacts']")
	WebElement contactsLabel;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newContactLink;
	
	//Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]")).click();
	}
	
	public CreateNewContactPage clickOnNewContactLink(){
		newContactLink.click();
		return new CreateNewContactPage();
	}
	
	
	
}
