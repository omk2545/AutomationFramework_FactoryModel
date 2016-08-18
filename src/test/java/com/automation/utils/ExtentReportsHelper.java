package com.automation.utils;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;
import java.util.Date;

/**
 * Created by Lenovo on 8/17/2016.
 */
public class ExtentReportsHelper {
    private static ExtentReports extentReports;

    public static ExtentReports getInstace(){

if (extentReports == null){

    Date d = new Date();
    String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
    extentReports = new ExtentReports( "D:\\reports\\"+ fileName, true,DisplayOrder.NEWEST_FIRST);
extentReports.loadConfig(new File(System.getProperty("user.dir")+ "\\Resources\\ReportsConfig.xml"));
System.out.println(System.getProperty("user.dir")+ "\\Resources\\ReportsConfig.xml");
    extentReports.addSystemInfo("Selenium ","2.53");
}

return  extentReports;
    }


}
