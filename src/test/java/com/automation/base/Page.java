package com.automation.base;



import com.automation.pages.common.Topmenu;

public class Page {
	
	protected WebDriver driver;
	public Page() {
		
		
		
	}

	public Page(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, Topmenu.class);
		
	}
	
	
	public Topmenu getMenu(){
		
		return PageFactory.initElements(driver, Topmenu.class);
	}
	
	
}
