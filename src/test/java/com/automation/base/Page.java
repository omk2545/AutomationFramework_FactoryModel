package com.automation.base;

import com.automation.helper.Constants;
import com.automation.pages.common.Topmenu;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Page {


	public EventFiringWebDriver driver;
public 	ExtentTest test;
	public Topmenu topmenu;

	public Page(EventFiringWebDriver driver , ExtentTest test) {

		this.driver = driver;
		this.test = test;
//		Menu initialization as menu is common throughout the Pages
       

	//	topmenu = PageFactory.initElements(driver, Topmenu.class);

	}

	public Topmenu getMenu() {
		return topmenu;

		//This is the change
	}


	public  String  ScreenShot(  ) throws IOException {

		Date date  = new Date();
		String updatedName = date.toString().replace(":","_").replace(" ","_");

		File scrFile;
		String path = Constants.USER_DIR+"\\screenshots\\"+updatedName+".png";

		System.out.println(path);
		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		FileUtils.copyFile(scrFile, new File(path));

		//Change

		test.log(LogStatus.INFO,"Adding the screens ",test.addScreenCapture(path));


		return "some";

	}

}
