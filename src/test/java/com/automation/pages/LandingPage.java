package com.automation.pages;

import com.automation.base.Page;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class LandingPage extends Page{

	 public LandingPage(EventFiringWebDriver driver , ExtentTest test) {
     super(driver,test);
	}

	 
	 
	 
	 
public DisplayPage gotoFlipkart(){
	
	System.out.println("Inside the class");
	driver.get("http://www.flipkart.com");

	test.log(LogStatus.INFO, "Opened url for flipkart ");

	DisplayPage displayPage = new DisplayPage(driver,test);
	 PageFactory.initElements(driver, displayPage);
	return displayPage;
}






}
