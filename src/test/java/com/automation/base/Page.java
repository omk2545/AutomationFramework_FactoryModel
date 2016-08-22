package com.automation.base;

import com.automation.helper.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.pages.common.Topmenu;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Page {

	public WebDriver driver;
public 	ExtentTest test;
	public Topmenu topmenu;

	public Page(WebDriver driver , ExtentTest test) {

		this.driver = driver;
		this.test = test;
//		Menu initialization as menu is common throughout the Pages
		//topmenu = PageFactory.initElements(driver, Topmenu.class);

	}

	public Topmenu getMenu() {
		return topmenu;
	}


	public  String  ScreenShot(  String fileName) throws IOException {

		Date date  = new Date();
		String updatedName = date.toString().replace(":","_").replace(" ","_");
		fileName = fileName+updatedName;


		File scrFile;
		String path = Constants.USER_DIR+"\\screenshots\\"+fileName+".png";

		System.out.println(path);
		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		FileUtils.copyFile(scrFile, new File(path));

		test.log(LogStatus.INFO,test.addScreenCapture("C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg"));





		return "some";

	}

}
