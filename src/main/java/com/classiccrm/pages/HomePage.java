package com.classiccrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classiccrm.base.TestBase;

public class HomePage extends TestBase  {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@src='https://classic.crmpro.com/img/logo.png']")
	WebElement logo;
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement loginText;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passwordText;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginButton;
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logoutElement;
	@FindBy(xpath = "//td[contains(text(),'User:')]")
	WebElement userElement;

	public String getURL() {
		String actual = driver.getCurrentUrl();
		return actual;
	}
	
	public String getTitle() {
		String actual = driver.getTitle();
		return actual;
	}

}
