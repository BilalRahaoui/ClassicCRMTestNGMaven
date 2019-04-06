package com.classiccrm.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classiccrm.base.TestBase;

public class HomePage extends TestBase  {
	
	public HomePage() throws Exception {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src='https://classic.crmpro.com/img/logo.png']")
	public WebElement logo;
	@FindBy(xpath = "//input[@placeholder='Username']")
	public WebElement loginText;
	@FindBy(xpath = "//input[@placeholder='Password']")
	public WebElement passwordText;
	@FindBy(xpath = "//input[@value='Login']")
	public WebElement loginButton;

	
	public String getURL() {
		String actual = driver.getCurrentUrl();
		return actual;
	}
	
	public String getTitle() {
		String actual = driver.getTitle();
		return actual;
	}
	
	public boolean logoIsDisplayed() {
		boolean logoIsDisplayed = logo.isDisplayed();
		return logoIsDisplayed;
	}
	
	public LoginPage performValidLogin() throws Exception {
		loginText.sendKeys(prop.getProperty("username"));
		passwordText.sendKeys(prop.getProperty("password"));
		loginButton.click();
		return new LoginPage();
	}
	
	public void performInvalidLogin(String username,String password) {
		loginText.sendKeys(username);
		passwordText.sendKeys(password);
		loginButton.click();
		String urlForInvalidLogin = "https://classic.crmpro.com/index.html?e=1";
		String actuelUrl = driver.getCurrentUrl();
		Assert.assertEquals(urlForInvalidLogin,actuelUrl);
	}

}
