package com.automation.pages.common;

import com.automation.helper.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Topmenu  {

	public  ExtentTest test;
	public WebDriver driver;


	public Topmenu(WebDriver driver) {
    this.driver = driver;
//	this.test = test;
	}

//	public void click

	@FindBy(css = Constants.eletronicsMenu)
	public WebElement eletronicsMenu;
	public void clickOnEletronics()
	{


		Actions actions = new Actions(driver);
		actions.moveToElement(eletronicsMenu).build().perform();


	//	System.out.println("INSIDE MENU");
		
	}
	
	
}
