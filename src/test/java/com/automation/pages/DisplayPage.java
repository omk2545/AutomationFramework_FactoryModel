package com.automation.pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.base.Page;
import com.automation.helper.Constants;

public class DisplayPage extends Page {

	public DisplayPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	@FindBy(css = Constants.textBox_search_DisplayPage)
	WebElement textBox_search_DisplayPage;

	@FindBy(css = Constants.button_search_DisplayPage)
	WebElement button_search_DisplayPage;

	@FindBy(css = "#container > div > div._3Q31_D > div._1XdvSH > div > div._2xw3j-")
	WebElement ProductsdisplayedText;

	public Object findProduct(String productname) {

		WebDriverWait wait = new WebDriverWait(driver, 60);

		wait.until(ExpectedConditions.visibilityOf(button_search_DisplayPage));

		textBox_search_DisplayPage.sendKeys(productname);
		test.log(LogStatus.INFO, "Serching for product" + productname);
		button_search_DisplayPage.click();

		boolean isProductAvailable = true;

		wait.until(ExpectedConditions.visibilityOf(ProductsdisplayedText));

		String productsData = ProductsdisplayedText.getText();
		if (productsData.contains("No products")) {
			isProductAvailable = false;

		}
		if (isProductAvailable) {

			ProductsDisplay productsDisplay = new ProductsDisplay(driver, test);
			PageFactory.initElements(driver,productsDisplay);
            return productsDisplay;
			//return PageFactory.initElements(driver, ProductsDisplay.class);
		} else {

			return this;
		}


	}
}