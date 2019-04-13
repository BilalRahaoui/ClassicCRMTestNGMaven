package com.classiccrm.testcases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.classiccrm.base.TestBase;
import com.classiccrm.pages.HomePage;
import com.classiccrm.util.ReportingTools;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageTest extends TestBase {

	//initialize an object from HomePage-LoginPage classes
	public HomePage homePage ;

	//constructor from super class
	public HomePageTest() throws Exception {
		super();

	}

	//Parameters from testng.xml
	@Parameters({"URL","browser"})

	//initialize and lunch test on selected browser
	@BeforeMethod
	public void lanchBrowser(Method method,String URL,String browser) throws Exception {
		logger = extents.startTest(method.getName());
		setUp(URL, browser);
		homePage = new HomePage();	
	}
	//terminate test "to do after test"
	@AfterMethod
	public void drop(ITestResult result) throws Exception {
		ReportingTools.takeSnapShot(result.getName());
		if(result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test success!");
			logger.log(LogStatus.PASS, "<a href='" +result.getName() + ".png" +"'><span class='label info'>Download Snapshot</a>");
		}
		else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test skipped!");
			logger.log(LogStatus.SKIP, "<a href='" +result.getName() + ".png" +"'><span class='label info'>Download Snapshot</a>");
		}
		else if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, result.getThrowable());
			logger.log(LogStatus.FAIL, "<a href='" +result.getName() + ".png" +"'><span class='label info'>View Snapshot</a>");
		}
		dropAll();
		}

	//Check if url is as descripted
	@Test(priority = 1)
	public void urlTest(Method method) throws Exception {
		//logger = extents.startTest(method.getName());
		String actual = homePage.getURL();
		String expected = "https://classic.crmpro.com/index.html";
		Assert.assertEquals(actual, expected, "TestURL failed because url is not matching!");
		ReportingTools.takeSnapShot(method.getName());
	}

	//check if title is as descripted
	@Test(priority = 2)
	public void titleTest(Method method) throws Exception {
		String actual = homePage.getTitle();
		String expected = "CRMPRO - CRM software for customer relationship management, sales, and support.";
		Assert.assertEquals(actual, expected, "TestTitle failed because title is not matching!");
		ReportingTools.takeSnapShot(method.getName());
	}

	//check if logo is visible
	@Test(priority = 3)
	public void logoTest(Method method) throws Exception {
		boolean logoStatus = homePage.logoIsDisplayed();
		Assert.assertTrue(logoStatus, "TestLogo failed because logo is not displayed");
		ReportingTools.takeSnapShot(method.getName());
	}

	//test click on pricing textLink
	@Test(priority = 4)
	public void pricingTest(Method method) throws Exception  {
		homePage.clickOnPricing();
		ReportingTools.takeSnapShot(method.getName());
	}

}
