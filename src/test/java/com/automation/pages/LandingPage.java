package com.automation.pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.Page;

public class LandingPage extends Page{

	 public LandingPage(WebDriver driver , ExtentTest test) {
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
