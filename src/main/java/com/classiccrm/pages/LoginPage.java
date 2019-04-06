package com.classiccrm.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.classiccrm.base.TestBase;

public class LoginPage extends TestBase {
	public Actions action;
	public LoginPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//td[contains(text(),'User:')]")
	public WebElement userInTopPage;
	
	@FindBy(xpath = "//td[contains(text(),'Free account ::')]")
	public WebElement accountLabel;
	
	@FindBy(xpath = "//a[@title='Contacts']")
	public WebElement contact;
	
	@FindBy(xpath = "//a[@title='New Contact']")
	public WebElement newContact;
	
	public void checkLoginPerformed() {
		driver.switchTo().frame("mainpanel");
		boolean userNameOnTopStatus = userInTopPage.isDisplayed();
		Assert.assertTrue(userNameOnTopStatus,"Login Failed");
	}
		
	public void checkAccountLabel() {
		driver.switchTo().frame("mainpanel");
		boolean accountLabelIsVisible = accountLabel.isDisplayed();
		Assert.assertTrue(accountLabelIsVisible,"Free account");
	}
	
	public ContactPage clickOnContact() throws Exception {
		driver.switchTo().frame("mainpanel");
		action = new Actions(driver);
		action.moveToElement(contact).build().perform();
		action.moveToElement(newContact).click().build().perform();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return new ContactPage();
	}
	
}
