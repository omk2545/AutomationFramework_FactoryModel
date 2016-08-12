package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.Page;
import com.automation.helper.Constants;

public class ProductsDisplay extends Page {
	

	public WebElement FirstProduct;
	
	@FindBys({
		@FindBy (css = "div[class ='product-unit unit-4 browse-product new-design']")
	})
	public List<WebElement > AllProducts; 
	
	public ProductsDisplay(WebDriver driver) {
	super(driver);
	
	
	}

public Object selectFirstProductFromList(){
	
	
	List<WebElement > allproc_list_productDisplay = driver.findElements(By.cssSelector(Constants.allproc_list_productDisplay));
	
	System.out.println("size "+allproc_list_productDisplay.size());
	
	
	if (AllProducts.isEmpty()) {
		
		System.out.println("inse e ee");
		return PageFactory.initElements(driver, ProductsDisplay.class);
		
		
	}else{
		System.out.println("No of Products Displayed"+AllProducts.size());
		
		AllProducts.get(3).click();
	/*FirstProduct = AllProducts.get(2).findElement(By.cssSelector("div[class ='product-unit unit-4 browse-product new-design']"));
	
	FirstProduct.click();*/
		
		System.out.println("Has value");
		
		return PageFactory.initElements(driver, ProductDetails.class);
		
		
	}
	
	
}
	
	
	
	
}
