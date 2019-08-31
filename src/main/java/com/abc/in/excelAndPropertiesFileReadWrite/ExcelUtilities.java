package com.abc.in.excelAndPropertiesFileReadWrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities {

    String data;

    public String readDataFromExcel(String filePath, String sheetName, int rowNo, int colNo) {
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);

            Workbook wb = WorkbookFactory.create(fis);
            Sheet s = wb.getSheet(sheetName);
            Row r = s.getRow(rowNo);
            Cell c = r.getCell(colNo);

            data = c.toString();
        } catch (Exception e) {

        }
        return data;
    }

    public void writeData(String filePath, String sheetName, int rowNo, int colNo, String value) {
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);

            Workbook wb = WorkbookFactory.create(fis);
            Sheet s = wb.getSheet(sheetName);
            Row r = s.getRow(rowNo);
            Cell c = r.getCell(colNo);
            c.setCellValue(value);

            FileOutputStream fos = new FileOutputStream(file);
            wb.write(fos);
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
