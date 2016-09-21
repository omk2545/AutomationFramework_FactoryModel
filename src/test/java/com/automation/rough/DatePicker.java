package com.automation.rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by omkarkul on 9/13/2016.
 */
public class DatePicker {


    public static WebDriver driver;
    @Test
    public void TestDatePicker(){

        driver= new FirefoxDriver();
        driver.get("https://www.makemytrip.com/");
        driver.findElement(By.cssSelector("span[class='check-dates']")).click();


		/*List<WebElement > noofdays = driver.findElements(By.cssSelector("td[data-handler ='selectDay']"));

       System.out.println(	noofdays.size());*/

        selectdate("October", 23);







        //WebElement datepicker = driver.findElement(By.cssSelector("ui-datepicker-group ui-datepicker-group-first"));




    }

    public static void  selectdate(String Month, int Date ){

        String month_Available;

        do{

            WebElement DateMonth = driver.findElement(By.cssSelector("#ui-datepicker-div > div.ui-datepicker-group.ui-datepicker-group-first > div > div > span.ui-datepicker-month"));

            month_Available = DateMonth.getText();

            System.out.println("PRinted "+month_Available );
            if (month_Available.equalsIgnoreCase(Month))
                break;

            WebElement clicknext = driver.findElement(By.cssSelector("#ui-datepicker-div > div.ui-datepicker-group.ui-datepicker-group-last > div > a"));
            clicknext.click();

        }while (!month_Available.equalsIgnoreCase(Month));


        WebElement DatepickerTable1 = driver.findElement(By.cssSelector("div[class ='ui-datepicker-group ui-datepicker-group-first']"));


        List<WebElement > noofdays = DatepickerTable1.findElements(By.cssSelector("td[data-handler ='selectDay']"));

        for (WebElement webElement : noofdays) {

            String date =  webElement.getAttribute("fare-date").toString();
            System.out.println(date);

            String Datearray [] = date.split("\\-");

            System.out.println(Datearray[0]);

            int Returned_Date = Integer.parseInt(Datearray[0]);
            if (Returned_Date == Date) {

                System.out.println("Matched");
                webElement.click();
                break;
            }



        }











    }

}
