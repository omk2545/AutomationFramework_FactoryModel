package com.automation.testcases.base;

import com.automation.utils.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automation.helper.Constants.BROWSERTYPE;
import org.testng.annotations.AfterMethod;

public class BaseTest {

	public WebDriver driver;

public 	ExtentReports extentReports;
public 	ExtentTest test;

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
			
			driver = new ChromeDriver();
			
		} else if (BROWSER.equals(BROWSERTYPE.FIREFOX)) {
			
			driver = new FirefoxDriver();
			
		} 
		
		driver.manage().window().maximize();
	   // driver.get("http:www.google.com");
	}


		
		
		
		
	}
