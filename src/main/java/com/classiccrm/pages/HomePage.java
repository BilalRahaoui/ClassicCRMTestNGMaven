package com.classiccrm.pages;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.classiccrm.base.TestBase;

public class HomePage extends TestBase  {
	
	public HomePage() throws Exception {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src='https://classic.crmpro.com/img/logo.png']")
	public WebElement logo;
	
	@FindBy(xpath = "//a[contains(text(),'Pricing')]")
	public WebElement pricingLinkText;
	
	@FindBy(xpath = "//a[@class='btn btn-default squared']")
	public WebElement getFreeCRM;
	
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
	//Move to LoginPage if login data is valid
	public LoginPage performValidLogin() throws Exception {
		loginText.sendKeys(prop.getProperty("username"));
		passwordText.sendKeys(prop.getProperty("password"));
		loginButton.click();
		return new LoginPage();
	}
	//Stay at HomePage if login data is not valid
	public void performInvalidLogin(String username,String password) {
		loginText.sendKeys(username);
		passwordText.sendKeys(password);
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String urlForInvalidLogin = "https://classic.crmpro.com/index.html?e=1";
		String actuelUrl = driver.getCurrentUrl();
		Assert.assertEquals(urlForInvalidLogin,actuelUrl,"Login Test with invalid data is OK");
	}
	
	public void clickOnPricing() {
		pricingLinkText.click();
		boolean getFreeCRMiSClickable = getFreeCRM.isEnabled();
		Assert.assertTrue(getFreeCRMiSClickable,"Can't click on button 'Get Free CRM'");
	}

}
