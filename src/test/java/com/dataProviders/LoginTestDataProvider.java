package com.dataProviders;

import com.google.gson.Gson;
import com.pojos.LoginTestPojo;
import com.pojos.User;
import com.ui.utilities.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class LoginTestDataProvider {

    @DataProvider(name = "loginDataProviderJSON")
    public static Iterator<Object[]> loginDataProviderJSON() {

        try {
            Gson gson = new Gson();
            File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\LoginTest.json");
            FileReader fileHandler = new FileReader(file);
            LoginTestPojo loginTestPojo = gson.fromJson(fileHandler, LoginTestPojo.class);
            List<Object[]> testDataToReturn = new ArrayList<>();
            for (User user : loginTestPojo.getData()) {
                testDataToReturn.add(new Object[]{user});
            }
            return testDataToReturn.iterator();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @DataProvider(name = "loginDataProviderCSV")
    public static Iterator<User> loginDataProviderCSV() {
        return CSVReaderUtility.readCSVFile("LoginData");
    }

    @DataProvider(name = "loginDataProviderEXCEL")
    public static Iterator<User> loginDataProviderEXCEL() {
        return ExcelReaderUtility.readExcel();
    }
}
