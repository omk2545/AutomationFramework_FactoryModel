package com.automation.utils;

import com.automation.helper.Constants;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;
import java.util.Date;

/**
 * Created by Lenovo on 8/17/2016.
 */
public class ExtentManager {
    private static ExtentReports extent;


    public static ExtentReports getInstance() {

        if (extent == null) {
            Date d = new Date();


String todayDate = String.valueOf(d.getDate());

            File folderName = new File(Constants.USER_DIR+"\\reports\\"+todayDate);
            if (!folderName.exists()) {
                if (folderName.mkdir()) {
                    System.out.println("Directory is created!");
                } else {
                    System.out.println("Failed to create directory!");
                }
            }


            String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".html";
            //String reportPath = "D:\\reports\\"+fileName;
            String reportPath = Constants.USER_DIR+"\\reports\\"+todayDate+"\\"+fileName;
            System.out.println(reportPath);
            extent = new ExtentReports(reportPath, true, DisplayOrder.NEWEST_FIRST);


            extent.loadConfig(new File(System.getProperty("user.dir") + "\\Resources\\ReportsConfig.xml"));
            // optional
            extent.addSystemInfo("Selenium Version", "2.53.0").addSystemInfo(
                    "Environment", "QA");
        }
        return extent;
    }
}