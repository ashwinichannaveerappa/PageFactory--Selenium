package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	//HomePage - Object Repository:
	@FindBy(xpath="//span[@class='user-display']")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Calendar')]")
	WebElement calendarLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//Initializing the Page Objects:
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public String verifyHomePageTitile()
	{
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink()
	{
		contactsLink.click();
		return new ContactsPage();
	}
	

	public DealsPage clickOnDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	
	public TasksPage clickOnTaksLink()
	{
		tasksLink.click();
		return new TasksPage();
	}
	
	public CalendarPage clickOnCalendarLink()
	{
		calendarLink.click();
		return new CalendarPage();
	}
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
}
