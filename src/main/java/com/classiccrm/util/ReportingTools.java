package com.classiccrm.util;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.classiccrm.base.TestBase;


public class ReportingTools extends TestBase {
	
	public ReportingTools() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void takeSnapShot(String name) throws Exception {
		String snapshotFilePath = new File("TestReport/SnapShot").getAbsolutePath();
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(snapshotFilePath+"\\"+name+".png"));
		System.out.println(snapshotFilePath+"\\"+name+".png");
	}

}
