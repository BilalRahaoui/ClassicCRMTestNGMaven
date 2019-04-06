package com.classiccrm.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.classiccrm.base.TestBase;
import com.classiccrm.testdata.Data;


public class ContactPageTest extends TestBase {
	
	//constructor from super class
	public ContactPageTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	//Parameters from testng.xml
	@Parameters({"URL","browser"})
	
	//initialize and lunch test on selected browser
	@BeforeMethod
	public void lanchBrowser(String URL,String browser) {
		setUp(URL, browser);
	}
	
	//terminate test "to do after test"
	@AfterMethod
	public void drop() {
		dropAll();
	}
	
	//testing if adding new contact feature is working
	@Test(dataProvider = "addContactData")
	public void testAddContact(String First_Name,String Last_Name,String Company,String Department) {
		WebElement loginText = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		WebElement passwordText = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
		loginText.sendKeys("rahaouitesting");
		passwordText.sendKeys("Bmn123456");
		loginButton.click();
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		WebElement contact = driver.findElement(By.xpath("//a[@title='Contacts']"));
		WebElement newContact = driver.findElement(By.xpath("//a[@title='New Contact']"));
		action.moveToElement(contact).build().perform();
		action.moveToElement(newContact).build().perform();
		action.click(newContact).build().perform();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement fnameTextBox = driver.findElement(By.id("first_name"));
		fnameTextBox.sendKeys(First_Name);
		WebElement lnameTextBox = driver.findElement(By.id("surname"));
		lnameTextBox.sendKeys(Last_Name);
		WebElement companyTextBox = driver.findElement(By.name("client_lookup"));
		companyTextBox.sendKeys(Company);
		WebElement departmentTextBox = driver.findElement(By.id("department"));
		departmentTextBox.sendKeys(Department);
		WebElement saveButton = driver.findElement(By.xpath("//input[@value='Save']"));
		action.moveToElement(saveButton).click().build().perform();
		SoftAssert soft = new SoftAssert();
		boolean editIsVisible = driver.findElement(By.xpath("//input[@value='Edit']")).isDisplayed();
		soft.assertTrue(editIsVisible,"Adding new contact failed!");
	}
	
	//Read data for add new contact test from Data.java class
	@DataProvider
	public Object[][] addContactData() throws Exception{
		Object data [][] = Data.contactData();
		return data;
	}

}
