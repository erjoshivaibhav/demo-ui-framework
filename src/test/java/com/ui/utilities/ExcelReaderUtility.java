package com.ui.utilities;

import com.pojos.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {

    public static Iterator<User> readExcel() {
        File xssfFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\LoginTest.xlsx");
        List<User> userList = new ArrayList<>();
        XSSFWorkbook xssfWorkbook;
        XSSFSheet xssfSheet;
        Iterator<Row> rowIterator;
        try {
            xssfWorkbook = new XSSFWorkbook(xssfFile);
            xssfSheet = xssfWorkbook.getSheet("Sheet1");
            rowIterator = xssfSheet.rowIterator();
            rowIterator.next();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                userList.add(new User(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue()));

            }
        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException(e);
        }
        return userList.iterator();
    }
}
