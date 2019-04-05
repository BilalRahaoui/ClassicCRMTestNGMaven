package com.classiccrm.base;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

public class TestBase{
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static EventFiringWebDriver e_driver;
	public static com.classiccrm.util.WebListener weblistener;

	@Parameters({"URL","browser"})

	public void setUp(String URL,String browser) {
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(URL);
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
		e_driver = new EventFiringWebDriver(driver);
		weblistener = new com.classiccrm.util.WebListener();
		e_driver.register(weblistener);
		driver = e_driver ;
	}

	public void dropAll() {
		driver.quit();
	}
}

