package com.automation.rough;

import com.automation.helper.Constants;
import com.automation.utils.ExcelUtil;

import java.util.Hashtable;

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

        String testName = "TestB";

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

        System.out.println("No of Rows for TestCase: "+testName+ " equals: "+noOfRows);

        int noOfColumns = 0;
        while(!excelUtil.getCellData(sheet,noOfColumns,columnStartRow).equals("")){
            noOfColumns++;
        }

        Object data[][] = new Object[noOfRows][noOfColumns];
        int dataRow =0;

        for(int i=dataStartRow; i<dataStartRow+noOfRows;i++){
            Hashtable<String,String> dataHashTable = new Hashtable<String, String>();

            for (int j=0;j<noOfColumns;j++){

                System.out.println(  excelUtil.getCellData(sheet,j,i));

                data[dataRow][j] = excelUtil.getCellData(sheet,j,i);
               // dataHashTable.put(excelUtil.getCellData(sheet),excelUtil.getCellData(sheet,j,i));

            }

            dataRow++;
        }


        int x= data.length;
        int y = data[0].length;




        for (int q =0; q < x;q++)
        {

            for (int w = 0; w < y; w++) {

                System.out.println( " Data "+data[q][w]);
            }
        }

////        System.out.println("No of Columns for testcase: "+testName+" is " +noOfColumns);
    }
}
