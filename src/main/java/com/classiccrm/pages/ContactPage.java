package com.classiccrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.classiccrm.base.TestBase;

public class ContactPage extends TestBase {
	public ContactPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first_name")	
	public WebElement fnameTextBox;
	
	@FindBy(id="surname")
	public WebElement lnameTextBox;
	
	@FindBy(name="client_lookup")
	public WebElement companyTextBox;
	
	@FindBy(name="department")
	public WebElement departmentTextBox;
	
	@FindBy(xpath="//input[@value='Save']")
	public WebElement saveButton;
	
	@FindBy(xpath="//input[@value='Edit']")
	public WebElement edit;
	
	public void sendContactData(String First_Name,String Last_Name,String Company,String Department) {
		fnameTextBox.sendKeys(First_Name);
		lnameTextBox.sendKeys(Last_Name);
		companyTextBox.sendKeys(Company);
		departmentTextBox.sendKeys(Department);
		saveButton.click();

	}
	public void checkSendContactDataPass() {
		SoftAssert soft = new SoftAssert();
		boolean editIsVisible = edit.isDisplayed();
		soft.assertTrue(editIsVisible, "Adding new contact failed!");
	}

}
