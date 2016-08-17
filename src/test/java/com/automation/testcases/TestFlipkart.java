package com.automation.testcases;

import com.automation.helper.Constants;
import com.automation.helper.Constants.BROWSERTYPE;
import com.automation.pages.DisplayPage;
import com.automation.pages.LandingPage;
import com.automation.pages.ProductsDisplay;
import com.automation.testcases.base.BaseTest;
import com.automation.utils.ExtentReportsHelper;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class TestFlipkart extends BaseTest{
	
		
	@Test
	public void test01() {
		
		init(BROWSERTYPE.CHROME);
		ExtentReportsHelper.getInstace();
		//System.out.println("Tess");
		
		//driver = new FirefoxDriver();
		
		LandingPage landingPage = PageFactory.initElements(driver,
				LandingPage.class);
		//this is change
		
		landingPage.getMenu().ClickonEletronics();
		
		
		DisplayPage displayPage = landingPage.gotoFlipkart();
//		Object Page = displayPage.findProduct(Constants.validProduct);
//
//
//		if (Page instanceof ProductsDisplay) {
//			System.out.println("We are on the Product Display ");
//			Assert.assertTrue(true);
//
//		} else {
//			System.out.println("We are on the Display page only ");
//			System.out.println("Not able to find the Product");
//			Assert.assertTrue(false);
//		}
//
//		Object Page2 = ((ProductsDisplay) Page).selectFirstProductFromList();
	}
	
	@AfterSuite
	public void Teardown(){
	driver.quit();

	}

}
