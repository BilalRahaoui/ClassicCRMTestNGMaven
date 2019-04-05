package com.classiccrm.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.classiccrm.base.TestBase;
import com.classiccrm.pages.HomePage;
import com.classiccrm.testdata.Data;
public class HomePageTest extends TestBase {
	HomePage hp = new HomePage();
	
	public HomePageTest() {
		super();
		
	}
	@Parameters({"URL","browser"})
	
	@BeforeMethod
	public void lanchBrowser(String URL,String browser) {
		setUp(URL, browser);
	}
	@AfterMethod
	public void drop() {
		dropAll();
	}
	@Test(priority = 1)
	public void urlTest() {
		String expected = "https://classic.crmpro.com/index.html";
		Assert.assertEquals(hp.getURL(), expected, "TestURL failed because url is not matching!");
	}
	@Test(priority = 2)
	public void titleTest() {
		String expected = "CRMPRO - CRM software for customer relationship management, sales, and support.";
		Assert.assertEquals(hp.getTitle(), expected, "TestTitle failed because title is not matching!");
	}
	

	@Test(priority = 3)
	public void logoTest() {
		WebElement logo = driver.findElement(By.xpath("//img[@src='https://classic.crmpro.com/img/logo.png']"));
		boolean logoIsDisplayed = logo.isDisplayed();
		Assert.assertTrue(logoIsDisplayed, "TestLogo failed because logo is not displayed");
	}
	@Test(priority = 4,dataProvider="validLogin")
	public static void loginTest(String username,String password) {
		SoftAssert soft = new SoftAssert();
		WebElement loginText = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		WebElement passwordText = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
		loginText.sendKeys(username);
		passwordText.sendKeys(password);
		loginButton.click();
		driver.switchTo().frame("mainpanel");
		WebElement logoutElement = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		boolean logout = logoutElement.isDisplayed();
		WebElement userElement = driver.findElement(By.xpath("//td[contains(text(),'User:')]"));
		boolean user = userElement.isDisplayed();
		soft.assertTrue(logout, "Login failed!");
		soft.assertTrue(user, "Login failed!");
		soft.assertAll();

	}
	@DataProvider
	public Object[][] validLogin() throws Exception {
		Object data [][] = Data.validLoginData();
		return data;
	}

	
}
