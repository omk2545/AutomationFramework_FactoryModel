package com.automation.testcases;

import com.automation.helper.Constants;
import com.automation.testcases.base.BaseTest;
import com.automation.utils.ExcelUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Created by Lenovo on 8/25/2016.
 */
public class Test003 extends BaseTest {


    @Test(dataProvider = "getdata")
    public void test001(Hashtable<String,String> data ) {

         System.out.println("****** "+data.get("RunMode") );

    }

//    public static void main(){
//
//
//
//
//
//    }

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


}
