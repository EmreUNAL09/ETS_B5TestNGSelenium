package com.eurotech.test.day20_DDF;

import com.eurotech.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilDemo {

    @Test
    public void readExcelFile(){
        //Create an object from excel utils
        //It accepts two arguments
        //Argument 1 : Location of the file (path)
        //Argument 2 : Sheet that we want to open (sheetName)

        ExcelUtil testData = new ExcelUtil("src/test/resources/EurotechTestB5.xlsx",
                "Test Data");

        //How many rows in the sheet
        System.out.println("testData.rowCount() = " + testData.rowCount());

        //How many columns in the sheet
        System.out.println("testData.columnCount() = " + testData.columnCount());

        //Get all columns names
        System.out.println("testData.getColumnsNames() = " + testData.getColumnsNames());

        //Get all data in list of String
        List<Map<String, String>> dataList = testData.getDataList();

        //iter
        for (Map<String, String> oneRow : dataList) {
            System.out.println("oneRow = " + oneRow);
        }

        //How can I get third(3.) row
        System.out.println("dataList.get(2) = " + dataList.get(2));

        //Get Aycan's company
        System.out.println("dataList.get(6).get(\"Company\") = " + dataList.get(6).get("Company"));

        //Get gigi' title
        System.out.println("dataList.get(3).get(\"Title\") = " + dataList.get(3).get("Title"));

        //Get array
        String[][] dataArray = testData.getDataArray();
        System.out.println("Arrays.deepToString(dataArray) = " + Arrays.deepToString(dataArray));


    }
}
