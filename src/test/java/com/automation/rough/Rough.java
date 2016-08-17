package com.automation.rough;

import com.automation.helper.Constants;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by omkarkul on 8/17/2016.
 */
public class Rough {




    public void readExcel() throws IOException {
//        String FilePath = "d:\\.xlsx";
//        FileInputStream fs = new FileInputStream(FilePath);
//        XSSFWorkbook wb = new XSSFWorkbook(fs);


    }



    public static void main(String[] args) throws Throwable {


        //String FilePath = "d:\\Resources.xlsx";
        String FilePath = Constants.USER_DIR + "\\src\\test\\java\\Resources"+"\\Data.xlsx";
        //System.out.println(Constants.USER_DIR + "\\src\\test\\java\\Resources"+"\\Data.xlsx");
        FileInputStream fs = new FileInputStream(FilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        Sheet sheet= workbook.getSheetAt(0);

        Iterator<Row> rowiterator 	= sheet.iterator();

        while (rowiterator.hasNext()) {
            Row row =  rowiterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:

                        System.out.println(cell.getStringCellValue());

                        break;

                    default:
                        break;
                }

            }


        }



    }


}
