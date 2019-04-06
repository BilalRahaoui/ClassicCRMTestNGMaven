package com.classiccrm.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.classiccrm.base.TestBase;
import com.classiccrm.pages.HomePage;
import com.classiccrm.pages.LoginPage;
import com.classiccrm.testdata.Data;

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
	
	//test login feature "with valid user& valid password 
	@Test(priority = 5,dataProvider = "testLoginData")
	public void loginTest(String username,String password) {
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
	
	//Read data for add new contact test from Data.java class
	@DataProvider
	public Object[][] testLoginData() throws Exception{
		Object data [][] = Data.loginTestData();
		return data;
	}
	
}
