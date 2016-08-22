package com.automation.testcases;

import com.automation.helper.Constants;
import com.automation.pages.DisplayPage;
import com.automation.pages.LandingPage;
import com.automation.testcases.base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by omkarkul on 8/18/2016.
 */
public class testFlipkartFailure extends BaseTest {

@Test
public void test02(){
    init(Constants.BROWSERTYPE.CHROME);
    test = extentReports.startTest("Test02");

    LandingPage landingPage = new LandingPage(driver,test);
    PageFactory.initElements(driver,landingPage);

    DisplayPage displayPage = landingPage.gotoFlipkart();

    displayPage.getMenu().clickOnEletronics();













}


}
