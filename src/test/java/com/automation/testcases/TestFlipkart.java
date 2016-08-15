package com.automation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.helper.Constants;
import com.automation.helper.Constants.BROWSERTYPE;
import com.automation.pages.DisplayPage;
import com.automation.pages.LandingPage;
import com.automation.pages.ProductsDisplay;
import com.automation.testcases.base.BaseTest;

public class TestFlipkart extends BaseTest{
	
		
	@Test
	public void test01() {
		
		init(BROWSERTYPE.CHROME);
		//System.out.println("Tess");
		
		//driver = new FirefoxDriver();
		
		LandingPage landingPage = PageFactory.initElements(driver,
				LandingPage.class);
		//this is change
		
		//landingPage.getMenu().ClickonEletronics();
		
		
		DisplayPage displayPage = landingPage.gotoFlipkart();
		Object Page = displayPage.findProduct(Constants.validProduct);
		
		
		if (Page instanceof ProductsDisplay) {
			System.out.println("We are on the Product Display ");
		} else {
			System.out.println("We are on the Display page only ");
		}

		Object Page2 = ((ProductsDisplay) Page).selectFirstProductFromList();
	}
	
	@AfterSuite
	public void Teardown(){
	driver.quit();
	}

}
