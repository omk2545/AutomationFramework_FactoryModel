package com.automation.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
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
	
	public ProductsDisplay(WebDriver driver, ExtentTest test) {
	super(driver, test);
	
	
	}

public  Object selectFirstProductFromList(){
	
	driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

	List<WebElement> allproc_list_productDisplay = driver.findElements(By.cssSelector(Constants.allproc_list_productDisplay));
	
//	System.out.println("size "+allproc_list_productDisplay.size());
	test.log(LogStatus.INFO,"Finding out  list of elements");

	if (allproc_list_productDisplay.isEmpty()) {
		
		System.out.println("inse e ee");
		//return PageFactory.initElements(driver, ProductsDisplay.class);

//        ProductsDisplay productsDisplay = new ProductsDisplay(driver,test);
//        PageFactory.initElements(driver,productsDisplay);
//        return productsDisplay;


        test.log(LogStatus.INFO,"Not able to find Products ");
        return this;
	}else{
		System.out.println("No of Products Displayed  "+allproc_list_productDisplay.size());
		
		test.log(LogStatus.INFO, "No of Products Displayed  "+allproc_list_productDisplay.size());



        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        allproc_list_productDisplay.get(1).click();
//	FirstProduct = AllProducts.get(2).findElement(By.cssSelector("div[class ='product-unit unit-4 browse-product new-design']"));

//	FirstProduct.click();

        test.log(LogStatus.INFO,"product selected ");



		//System.out.println("Has value");
ProductDetails productDetails = new ProductDetails(driver,test);
		 PageFactory.initElements(driver, productDetails);

		return  productDetails;
	}



}
	
	
	
	
}
