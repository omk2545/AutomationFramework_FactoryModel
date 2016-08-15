package com.automation.testcases.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automation.helper.Constants.BROWSERTYPE;

public class BaseTest {

	protected WebDriver driver;
	
	public void init(BROWSERTYPE BROWSER){
		
		
		
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
		
		
	   // driver.get("http:www.google.com");
	}
		
		
		
		
		
	}
