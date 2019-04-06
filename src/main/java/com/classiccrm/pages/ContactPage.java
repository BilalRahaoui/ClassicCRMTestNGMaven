package com.classiccrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classiccrm.base.TestBase;

public class ContactPage extends TestBase {

	public ContactPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contact;
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContact;
	@FindBy(id="first_name")	
	WebElement fnameTextBox;
	@FindBy(id="surname")
	WebElement lnameTextBox;
	@FindBy(name="client_lookup")
	WebElement companyTextBox;
	@FindBy(name="department")
	WebElement departmentTextBox;
	@FindBy(xpath="//input[@value='Edit']")
	WebElement saveButton;

}
