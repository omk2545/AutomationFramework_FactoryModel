package com.automation.testcases;

import com.automation.helper.Constants.BROWSERTYPE;
import com.automation.pages.DisplayPage;
import com.automation.pages.LandingPage;
import com.automation.testcases.base.BaseTest;
import com.automation.utils.ExtentManager;
import com.automation.utils.UtilsFlipkart;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestFlipkart extends BaseTest{

	ExtentReports extentReports;
	ExtentTest extentTest;
	@Test
	public void test01() {
		extentReports = ExtentManager.getInstance();

		extentTest = extentReports.startTest("TestFlipkart");


		init(BROWSERTYPE.CHROME);

		//System.out.println("Tess");
		
		//driver = new FirefoxDriver();
		
		LandingPage landingPage = PageFactory.initElements(driver,
				LandingPage.class);
		//extentTest.log(LogStatus.PASS,"We can conclude that test is Pass");


		//this is change
		
		landingPage.getMenu().ClickonEletronics();
		
		
		DisplayPage displayPage = landingPage.gotoFlipkart();
		extentTest.log(LogStatus.INFO,"Flipkart site opened ");

		Assert.assertTrue(false);

//		Object Page = displayPage.findProduct(Constants.validProduct);
//
//
//		if (Page instanceof ProductsDisplay) {
//			System.out.println("We are on the Product Display ");
//			Assert.assertTrue(false);
//
//		} else {
//			System.out.println("We are on the Display page only ");
//			System.out.println("Not able to find the Product");
//			Assert.assertTrue(false);
//		}
//
//		Object Page2 = ((ProductsDisplay) Page).selectFirstProductFromList();
	}
	
	@AfterMethod
	public void TearDown(ITestResult iTestResult) throws IOException {
		System.out.println("Inside Teardown");

		if (iTestResult.getStatus()== ITestResult.FAILURE){

			String testName = iTestResult.getName();

			System.out.println(testName);
				String pathToFile = UtilsFlipkart.ScreenCapture(driver,testName);
			System.out.println(pathToFile);


String file = extentTest.addScreenCapture(pathToFile);
            extentTest.log(LogStatus.FAIL, "This has failed  ", file);

		}
		extentReports.endTest(extentTest);

		extentReports.flush();
		driver.quit();

	}

}
