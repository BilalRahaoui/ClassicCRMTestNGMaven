package com.classiccrm.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import com.classiccrm.util.WebListener;

public class TestBase{
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static EventFiringWebDriver e_driver;
	public static WebListener weblistener;
	public static Properties prop;
	public TestBase() throws Exception {
		prop = new Properties();
		String propertiesPath = "src/main/java/com/classiccrm/testdata/prop.properties";
		FileInputStream inputStream = new FileInputStream(propertiesPath);
		prop.load(inputStream);
	}
	//Parameters from testng.xml
	@Parameters({"URL","browser"})
	
	public void setUp(String URL,String browser) {
		//Working browsers "choose your browser from testng.xml"
		if(browser.equalsIgnoreCase("Firefox")) 
			driver = new FirefoxDriver();
		else if (browser.equalsIgnoreCase("Chrome"))
			driver = new ChromeDriver();
		//Non-working browsers
		else if(browser.equalsIgnoreCase("IE"))
			driver = new InternetExplorerDriver();
		else if(browser.equalsIgnoreCase("Opera"))
			driver = new OperaDriver();
		else if (browser.equalsIgnoreCase("Safari"))
			driver = new SafariDriver();
		//Deleting cookies and maximize window
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//Getting url from testNG parameters
		driver.get(URL);
		//Wait for invisibility of loader that appears when page is opened
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
		//Event listener to show action performed in console "view WebListener.java class"
		e_driver = new EventFiringWebDriver(driver);
		weblistener = new WebListener();
		e_driver.register(weblistener);
		driver = e_driver ;
	}
	
	//Method to terminate test case
	public void dropAll() {
		driver.quit();
	}
	
}

