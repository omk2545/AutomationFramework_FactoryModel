package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.Page;

public class LandingPage extends Page{

	 public LandingPage(WebDriver driver) {
     super(driver);		
	}

	 
	 
	 
	 
public DisplayPage gotoFlipkart(){
	
	System.out.println("Inside the class");
	driver.get("http://www.flipkart.com");
	
	return PageFactory.initElements(driver, DisplayPage.class);
}






}
