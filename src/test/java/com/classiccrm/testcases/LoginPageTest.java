package com.classiccrm.testcases;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.classiccrm.base.TestBase;
import com.classiccrm.pages.HomePage;
import com.classiccrm.pages.LoginPage;
import com.classiccrm.testdata.Data;
import com.classiccrm.util.ReportingTools;


public class LoginPageTest extends TestBase{
	
	public HomePage homePage;
	public LoginPage loginPage;
	
	//constructor from super class
	public LoginPageTest() throws Exception {
	
		super();
		// TODO Auto-generated constructor stub
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
	
	//test login feature "with valid user & valid password 
	@Test(priority = 4)
	public void validLoginTest(Method method) throws Exception {
		homePage.performValidLogin();
		loginPage.checkLoginPerformed();
		ReportingTools.takeSnapShot(method.getName());
	}
	
	//test login feature "with invalid user // invalid password 
	@Test(priority = 5, dataProvider = "invalidLogin")
	public void invalidLoginTest(String username,String password,Method method) throws Exception {
		homePage.performInvalidLogin(username, password);
		ReportingTools.takeSnapShot(method.getName());
	}

	@Test(priority = 6)
	public void loginTest(Method method) throws Exception {
		homePage.performValidLogin();
		loginPage.checkLoginPerformed();
		ReportingTools.takeSnapShot(method.getName());
	}
	@Test(priority = 7)
	public void accountLabelTest(Method method) throws Exception {
		homePage.performValidLogin();
		loginPage.checkAccountLabel();
		ReportingTools.takeSnapShot(method.getName());
	}
	
	//Data provider from Data.java class
	@DataProvider
	public Object[][] invalidLogin() throws Exception {
		Object data [][] = Data.invalidLoginTestData();
		return data;
	}
	
	
}
