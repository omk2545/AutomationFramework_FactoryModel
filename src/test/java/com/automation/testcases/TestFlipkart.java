package com.automation.testcases;

import com.automation.helper.Constants;
import com.automation.helper.Constants.BROWSERTYPE;
import com.automation.pages.DisplayPage;
import com.automation.pages.LandingPage;
import com.automation.pages.ProductDetails;
import com.automation.pages.ProductsDisplay;
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

//	ExtentReports extentReports;
//	ExtentTest extentTest;
	@Test
	public void test01() {
        init(BROWSERTYPE.CHROME);
        test = extentReports.startTest("TestCase01");




		//System.out.println("Tess");
		
		//driver = new FirefoxDriver();
		
		/*LandingPage landingPage = PageFactory.initElements(driver,
				LandingPage.class);*/

        LandingPage landingPage = new LandingPage(driver,test);
        PageFactory.initElements(driver,landingPage);

		//extentTest.log(LogStatus.PASS,"We can conclude that test is Pass");

		//landingPage.getMenu().ClickonEletronics();
		
		
		DisplayPage displayPage = landingPage.gotoFlipkart();
        test.log(LogStatus.INFO,"Flipkart site opened ");

		//Assert.assertTrue(false);

		Object page = displayPage.findProduct(Constants.validProduct);


		if (page instanceof ProductsDisplay) {
			//System.out.println("");
            test.log(LogStatus.INFO,"We are on the Product Display ");
			Assert.assertTrue(true);

		} else {

			System.out.println("Not able to find the Product");
			Assert.assertTrue(false);
		}


        Object page2  = ((ProductsDisplay) page).selectFirstProductFromList();

        if(page2 instanceof ProductDetails){

            test.log(LogStatus.INFO,"We are on the product details page");

        }else {

            test.log(LogStatus.FAIL, "Failing the the test as product not found  ");
            Assert.assertTrue(false);
            // ((ProductsDisplay) page).selectFirstProductFromList();
        }

    boolean vale =    ((ProductDetails) page2).verifyProductPrice();


    }
	
	@AfterMethod
	public void TearDown(ITestResult iTestResult) throws IOException {
		System.out.println("Inside Teardown");

		if (iTestResult.getStatus()== ITestResult.FAILURE){

			String testName = iTestResult.getName();

			System.out.println(testName);
				String pathToFile = UtilsFlipkart.ScreenCapture(driver,testName);
			System.out.println(pathToFile);


String file = test.addScreenCapture(pathToFile);
            test.log(LogStatus.FAIL, "This has failed  ", file);

		}
		extentReports.endTest(test);

		extentReports.flush();
		driver.quit();

	}


//    @AfterMethod
//    public void  Quit(){
//
//
//
//    }

}
