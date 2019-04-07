package com.classiccrm.testcases;

import java.io.File;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import com.classiccrm.base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;

public class Config extends TestBase {

	public Config() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	//Start reporting using extent report
	@BeforeSuite
	public void start() {
		String reportFilePath = new File("TestReport").getAbsolutePath();
		//String snapshotFilePath = new File("D:\\Java\\Eclipse\\WorkSpace\\ClassicCRMTestMaven\\TestReport").getAbsolutePath();
		extents = new ExtentReports(reportFilePath+"\\index.html",true);
		
		extents.addSystemInfo("OS", "windows");
		extents.addSystemInfo("Tester", "Bilal RAHAOUI");
		extents.addSystemInfo("Test Name", "Classic CRM");
		extents.addSystemInfo("language", "JAVA");
		extents.addSystemInfo("Framework Design", "Page Object");
	}
	
	//End reporting using extent report
	@AfterSuite
	public void end() {
		extents.flush();
	}

}
