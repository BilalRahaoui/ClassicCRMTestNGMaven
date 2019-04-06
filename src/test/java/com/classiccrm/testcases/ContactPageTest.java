package com.classiccrm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.classiccrm.base.TestBase;
import com.classiccrm.pages.ContactPage;
import com.classiccrm.pages.HomePage;
import com.classiccrm.pages.LoginPage;
import com.classiccrm.testdata.Data;

public class ContactPageTest extends TestBase {
	public HomePage homePage;
	public LoginPage loginPage;
	public ContactPage contactPage;
	//constructor from super class
	public ContactPageTest() throws Exception {
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
		contactPage = new ContactPage();
	}
	
	//terminate test "to do after test"
	@AfterMethod
	public void drop() {
		dropAll();
	}
	
	//testing if adding new contact feature is working
	@Test(priority = 7,dataProvider = "addContactData")
	public void addNewContactTest(String First_Name,String Last_Name,String Company,String Department) throws Exception {
		homePage.performValidLogin();
		loginPage.clickOnContact();
		contactPage.sendContactData(First_Name, Last_Name, Company, Department);
		contactPage.checkSendContactDataPass();
	}
	
	//Read data for add new contact test from Data.java class
	@DataProvider
	public Object[][] addContactData() throws Exception{
		Object data [][] = Data.contactData();
		return data;
	}

}
