package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.Page;
import com.automation.helper.Constants;

public class DisplayPage extends Page {
	
	public DisplayPage(WebDriver driver) {
	super(driver);
	}

	@FindBy(css=Constants.textBox_search_DisplayPage)
	WebElement textBox_search_DisplayPage;
	
	
	
	@FindBy(how=How.CSS,using = Constants.button_search_DisplayPage)
	WebElement button_search_DisplayPage;
	
	@FindBy(css ="#products > div")
	WebElement noproductsavailable;
	
	public Object findProduct(String productname){

		textBox_search_DisplayPage.sendKeys(productname);
		button_search_DisplayPage.click(); 
		
		boolean isProductAvailable = true;
		
	String productsData  = 	noproductsavailable.getText();
	if (productsData.contains("No products")) {
    isProductAvailable= false;
		
	} 
	
	if (isProductAvailable) {
		return PageFactory.initElements(driver, ProductsDisplay.class);
	}else {
		
		return this;
	}
		
		
		
	}
	
	
}
