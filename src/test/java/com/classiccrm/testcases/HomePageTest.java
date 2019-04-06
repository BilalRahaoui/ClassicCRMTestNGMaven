package com.classiccrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.classiccrm.base.TestBase;
import com.classiccrm.pages.HomePage;
import com.classiccrm.pages.LoginPage;
import com.classiccrm.testdata.Data;
public class HomePageTest extends TestBase {
	
	//initialize an object from HomePage class
	public HomePage homePage ;
	public LoginPage loginPage;
	
	//constructor from super class
	public HomePageTest() throws Exception {
		super();

	}

	//Parameters from testng.xml
	@Parameters({"URL","browser"})

	//initialize and lunch test on selected browser
	@BeforeMethod
	public void lanchBrowser(String URL,String browser) throws Exception {
		setUp(URL, browser);
		homePage = new HomePage();
		loginPage = new LoginPage();
	}
	
	//terminate test "to do after test"
	@AfterMethod
	public void drop() {
		dropAll();
	}
	
	//Check if url is as descripted
	@Test(priority = 1)
	public void urlTest() {
		String actual = homePage.getURL();
		String expected = "https://classic.crmpro.com/index.html";
		Assert.assertEquals(actual, expected, "TestURL failed because url is not matching!");
	}
	
	//check if title is as descripted
	@Test(priority = 2)
	public void titleTest() {
		String actual = homePage.getTitle();
		String expected = "CRMPRO - CRM software for customer relationship management, sales, and support.";
		Assert.assertEquals(actual, expected, "TestTitle failed because title is not matching!");
	}
	
	//check if logo is visible
	@Test(priority = 3)
	public void logoTest() {
		boolean logoStatus = homePage.logoIsDisplayed();
		Assert.assertTrue(logoStatus, "TestLogo failed because logo is not displayed");
	}
	
	//test login feature "with valid user& valid password 
	@Test(priority = 4)
	public void validLoginTest() throws Exception {
		homePage.performValidLogin();
		loginPage.checkLoginPerformed();	
	}
	
	//test login feature "with invalid user // invalid password 
	@Test(priority = 5, dataProvider = "inalidLogin")
	public void invalidLoginTest(String username,String password) {
		homePage.performInvalidLogin(username, password);
	}
	
	@DataProvider
	public Object[][] inalidLogin() throws Exception {
		Object data [][] = Data.loginTestData();
		return data;
	}
}
