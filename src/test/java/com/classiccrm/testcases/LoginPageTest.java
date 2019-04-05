package com.classiccrm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.classiccrm.base.TestBase;
import com.classiccrm.testdata.Data;

public class LoginPageTest extends TestBase{
	
	public LoginPageTest() {
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
	@Test(priority = 5,dataProvider = "testLoginData")
	public void testLogin(String username,String password) {
		HomePageTest.loginTest(username, password);
	}
	
	@DataProvider
	public Object[][] testLoginData() throws Exception{
		Object data [][] = Data.loginTestData();
		return data;
	}
	
}
