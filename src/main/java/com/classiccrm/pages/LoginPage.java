package com.classiccrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.classiccrm.base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//td[contains(text(),'User:')]")
	public WebElement userInTopPage;
	
	public void checkLoginPerformed() {
		driver.switchTo().frame("mainpanel");
		boolean userNameOnTopStatus = userInTopPage.isDisplayed();
		Assert.assertTrue(userNameOnTopStatus,"Login Failed");
	}

	
}
