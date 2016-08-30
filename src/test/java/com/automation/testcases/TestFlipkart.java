package com.automation.testcases;

import com.automation.helper.Constants;
import com.automation.helper.Constants.BROWSERTYPE;
import com.automation.pages.DisplayPage;
import com.automation.pages.LandingPage;
import com.automation.pages.ProductDetails;
import com.automation.pages.ProductsDisplay;
import com.automation.testcases.base.BaseTest;
import com.automation.utils.ExcelUtil;
import com.automation.utils.UtilsFlipkart;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Hashtable;

public class TestFlipkart extends BaseTest{

//	ExtentReports extentReports;
//	ExtentTest extentTest;
	@Test(dataProvider = "getdata")
	public void test01(Hashtable <String,String> data) {



		init(BROWSERTYPE.CHROME);

		String testName = data.get("Product");

		test = extentReports.startTest("TestCase01"+"_"+testName);

		if(	!data.get("RunMode").equalsIgnoreCase("Y")) {

			test.log(LogStatus.SKIP,"Skipping the Test As Run Mode is N");

			throw new SkipException("Run mode is not set to Y");

		}





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

		try {
			displayPage.ScreenShot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Assert.assertTrue(false);

//		if (data.get(""))

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

			Assert.assertTrue(false);

    }
	
	@AfterMethod
	public void TearDown(ITestResult iTestResult) throws IOException {
		System.out.println("Inside Teardown");

		if (iTestResult.getStatus()== ITestResult.FAILURE){

			String testName = iTestResult.getName();

			System.out.println(testName);
				String pathToFile =
			//System.out.println(pathToFile);

           UtilsFlipkart.capScreen(driver,test);

         //   test.log(LogStatus.FAIL, "This has failed  ",file);

		}
		extentReports.endTest(test);

		extentReports.flush();
		driver.quit();

	}


@DataProvider
public Object[][] getdata() {

        Object[][] data;

        ExcelUtil excelUtil = new ExcelUtil(Constants.USER_DIR + "//Resources//Data.xlsx");

        String sheet = "Test01";
//        int rowCount = excelUtil.getRowCount(sheet);
//        System.out.println(rowCount);
//
//        int colCount = excelUtil.getColumnCount(sheet);
//
//        System.out.println(colCount);

        String testName = "TestB";

        int testStartRow = 1;

        while (!excelUtil.getCellData(sheet, 0, testStartRow).equals(testName)) {
            testStartRow++;
        }

        int columnStartRow = testStartRow + 1;
        int dataStartRow = testStartRow + 2;

//        System.out.println("TestStatRow: "+testStartRow);

        int noOfRows = 0;
        while (!excelUtil.getCellData(sheet, 0, dataStartRow + noOfRows).equals("")) {
            noOfRows++;
        }

        System.out.println("No of Rows for TestCase: " + testName + " equals: " + noOfRows);

        int noOfColumns = 0;
        while (!excelUtil.getCellData(sheet, noOfColumns, columnStartRow).equals("")) {
            noOfColumns++;
        }

        //data = new Object[noOfRows][noOfColumns];
        data = new Object[noOfRows][1];

        int dataRow = 0;
        Hashtable<String, String> dataHashTable = null;
        for (int i = dataStartRow; i < dataStartRow + noOfRows; i++) {
            dataHashTable =   new Hashtable<String, String>();

            for (int j = 0; j < noOfColumns; j++) {

                String key = excelUtil.getCellData(sheet, j, columnStartRow);
                String value = excelUtil.getCellData(sheet, j, i);

                dataHashTable.put(key,value);

                //  data[dataRow][j] = excelUtil.getCellData(sheet, j, i);
                // dataHashTable.put(excelUtil.getCellData(sheet),excelUtil.getCellData(sheet,j,i));

            }

            data[dataRow][0] = dataHashTable;
            dataRow++;
        }


//            int x = data.length;
//            int y = data[0].length;
//
//
//            for (int q = 0; q < x; q++) {
//
//                for (int w = 0; w < y; w++) {
//
//                    System.out.println(" Data " + data[q][w]);
//                }
//            }

////        System.out.println("No of Columns for testcase: "+testName+" is " +noOfColumns);


        return data;
    }


//    @AfterMethod
//    public void  Quit(){
//
//
//
//    }

}
