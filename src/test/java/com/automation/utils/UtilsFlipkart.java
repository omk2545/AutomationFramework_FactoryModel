package com.automation.utils;

import com.automation.helper.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by omkarkul on 8/18/2016.
 */
public class UtilsFlipkart  {


    public static String  ScreenCapture(WebDriver driver , String fileName) throws IOException {

        Date date  = new Date();
        String updatedName = date.toString().replace(":","_").replace(" ","_");
        fileName = fileName+updatedName;


        File scrFile;
        String path = Constants.USER_DIR+"/screenshots/"+fileName+".png";

        System.out.println(path);
        scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
        FileUtils.copyFile(scrFile, new File(path));


     //   String path = "C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg";


       return scrFile.getAbsolutePath();

    }



    public static String capScreen(WebDriver driver, ExtentTest test){

        Date date  = new Date();
        String updatedName = date.toString().replace(":","_").replace(" ","_");

        File scrFile;
        String path = Constants.USER_DIR+"\\screenshots\\"+updatedName+".png";

        System.out.println(path);
        scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
        try {
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.log(LogStatus.FAIL,"testCase failed at this page",test.addScreenCapture(path));

        return "some";
    }

}

