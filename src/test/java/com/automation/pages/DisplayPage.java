package com.automation.pages;

import com.automation.base.Page;
import com.automation.helper.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DisplayPage extends Page {

	public DisplayPage(EventFiringWebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	@FindBy(css = Constants.textBox_search_DisplayPage)
	WebElement textBox_search_DisplayPage;

	@FindBy(css = Constants.button_search_DisplayPage)
	WebElement button_search_DisplayPage;

	//@FindBy(css = Constants.productsDisplayedText)
	WebElement productsdisplayedText;

	public Object findProduct(String productname) {

		WebDriverWait wait = new WebDriverWait(driver, 60);

		wait.until(ExpectedConditions.visibilityOf(button_search_DisplayPage));

		textBox_search_DisplayPage.sendKeys(productname);
		test.log(LogStatus.INFO, "Serching for product" + productname);
		button_search_DisplayPage.click();

		boolean isError = false;
try {
	productsdisplayedText = driver.findElement(By.cssSelector(Constants.ProductsdisplayedText));
	isError = productsdisplayedText.isDisplayed();
}catch(Exception e){
	test.log(LogStatus.INFO,"Not able to find element");

}
		if(!isError){
			ProductsDisplay productsDisplay = new ProductsDisplay(driver, test);
			PageFactory.initElements(driver,productsDisplay);
            return productsDisplay;

		} else {


			return this;

		}








		//wait.until(ExpectedConditions.visibilityOf(productsDisplayedText));

//		String productsData = ProductsdisplayedText.getText();
//		if (productsData.contains("No products")) {
//			isProductAvailable = false;
//
//		}
//		if (isProductAvailable) {
//
//			ProductsDisplay productsDisplay = new ProductsDisplay(driver, test);
//			PageFactory.initElements(driver,productsDisplay);
//            return productsDisplay;
//			//return PageFactory.initElements(driver, ProductsDisplay.class);
//		} else {
//
//
//		}


	}
}