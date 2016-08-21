package com.automation.rough;

import com.automation.helper.Constants;
import com.automation.utils.ExcelUtil;

/**
 * Created by Lenovo on 8/21/2016.
 */
public class DataManager {
    public static void main(String a[]){
        ExcelUtil excelUtil = new ExcelUtil(Constants.USER_DIR+"//Resources//Data.xlsx");

        String sheet = "Test01";
//        int rowCount = excelUtil.getRowCount(sheet);
//        System.out.println(rowCount);
//
//        int colCount = excelUtil.getColumnCount(sheet);
//
//        System.out.println(colCount);

        String testName = "TestA";

        int testStartRow = 1;

        while (!excelUtil.getCellData(sheet,0,testStartRow).equals(testName)){
            testStartRow++;
        }

        int columnStartRow = testStartRow+1;
        int dataStartRow = testStartRow+2;

//        System.out.println("TestStatRow: "+testStartRow);

        int noOfRows =0;
        while(!excelUtil.getCellData(sheet,0,dataStartRow+noOfRows).equals("")){
            noOfRows++;
        }

        System.out.println("No of Rows for TestCase: "+testName+ " equals "+noOfRows);

        int noOfColumns = 0;
        while(!excelUtil.getCellData(sheet,noOfColumns,columnStartRow).equals("")){
            noOfColumns++;
        }

        for(int i=dataStartRow; i<dataStartRow+noOfRows;i++){

            for (int j=0;j<noOfColumns;j++){
                System.out.println(  excelUtil.getCellData(sheet,j,i));
            }
        }
//        System.out.println("No of Columns for testcase: "+testName+" is " +noOfColumns);
    }
}
