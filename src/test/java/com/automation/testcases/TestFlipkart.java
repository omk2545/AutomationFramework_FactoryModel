package com.automation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.helper.Constants;
import com.automation.pages.DisplayPage;
import com.automation.pages.LandingPage;
import com.automation.pages.ProductsDisplay;

public class TestFlipkart {
	
	
public WebDriver driver;

	@BeforeTest
	public void init() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	   // driver.get("http:www.google.com");
	}

	@Test
	public void test01() {
		System.out.println("Tess");
		
		LandingPage landingPage = PageFactory.initElements(driver,
				LandingPage.class);
		//this is change
		
		
		DisplayPage displayPage = landingPage.gotoFlipkart();
		Object Page = displayPage.findProduct(Constants.validProduct);
		
		
		if (Page instanceof ProductsDisplay) {
			System.out.println("We are on the Product Display ");
		} else {
			System.out.println("We are on the Display page only ");
		}

		Object Page2 = ((ProductsDisplay) Page).selectFirstProductFromList();
	}
	
	@AfterTest
	public void Teardown(){
	driver.quit();
	}

}
