package com.automation.rough;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.annotations.Test;

/**
 * Created by omkarkul on 8/18/2016.
 */
public class TryingExtentReports {
ExtentReports extentReports;
 ExtentTest extentTest;

    @Test
public void test01(){
        extentReports = new ExtentReports("D:\\reports\\Extent.html");
        extentTest = extentReports.startTest("Omkar");

        System.out.println("test is Executed");


        extentReports.endTest(extentTest);
        extentReports.flush();


    }



}
