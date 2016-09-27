package com.automation.testcases.base;

import com.automation.helper.Constants.BROWSERTYPE;
import com.automation.utils.TestEventListener;
import com.automation.utils.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {

	public WebDriver webDriver;
public 	EventFiringWebDriver driver;

public 	ExtentReports extentReports;
public 	ExtentTest test;
public TestEventListener testEventListener;

	public void init(BROWSERTYPE BROWSER){


		extentReports = ExtentManager.getInstance();
		
		/*driver = new FirefoxDriver();
		driver.manage().window().maximize();
		*/


		if (BROWSER.equals(BROWSERTYPE.CHROME)) {
			

			String user_dir = System.getProperty("user.dir");
			System.out.println(user_dir);
			String internalpath ="\\drivers\\chromedriver\\chromedriver.exe";
			
			System.out.println("path" +user_dir + internalpath);
			System.setProperty("webdriver.chrome.driver", user_dir+internalpath );

			webDriver = new ChromeDriver();
			
		} else if (BROWSER.equals(BROWSERTYPE.FIREFOX)) {

			webDriver = new FirefoxDriver();
			
		}



		driver = new EventFiringWebDriver(webDriver);

		driver.manage().window().maximize();
//		driver = new EventFiringWebDriver(webDriver);
//		testEventListener = new TestEventListener(driver,test);
//		driver.register(testEventListener);



	   // driver.get("http:www.google.com");
	}



	public TestEventListener createEventListener(ExtentTest test ,EventFiringWebDriver webDriver ){

		testEventListener = new TestEventListener(webDriver,test);
		driver.register(testEventListener);
return testEventListener;
//return  testEventListener;

	}
@AfterMethod
public void tearDown(){

	extentReports.flush();

	driver.quit();



}
		
		
		
		
	}
