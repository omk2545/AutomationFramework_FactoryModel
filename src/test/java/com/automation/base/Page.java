package com.automation.base;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.pages.common.Topmenu;

public class Page {
	
	protected WebDriver driver;
	

	public Page(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, Topmenu.class);
		
	}
	
	
	public Topmenu getMenu(){
		//Here  is the Change
		return PageFctory.initElements(driver, Topmenu.class);
	}
	
	
}
