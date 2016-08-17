package com.automation.utils;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;
import java.util.Date;

/**
 * Created by Lenovo on 8/17/2016.
 */
public class ExtentManager {
    public static ExtentReports extent;


    public static ExtentReports getInstance() {

        if (extent == null) {
            Date d = new Date();
            String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".html";
            String reportPath = "D://";

            extent = new ExtentReports(reportPath, true, DisplayOrder.NEWEST_FIRST);


            extent.loadConfig(new File(System.getProperty("user.dir") + "\\Resources\\ReportsConfig.xml"));
            // optional
            extent.addSystemInfo("Selenium Version", "2.53.0").addSystemInfo(
                    "Environment", "QA");
        }
        return extent;
    }
}