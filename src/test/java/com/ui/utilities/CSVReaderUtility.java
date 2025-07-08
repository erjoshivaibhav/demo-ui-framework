package com.ui.utilities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.pojos.User;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVReaderUtility {

    /**
     * Reads a CSV file and returns an iterator of User objects.
     *
     * @param fileName the name of the CSV file (without extension)
     * @return an iterator of User objects
     */
    public static Iterator<User> readCSVFile(String fileName) {
        File file = new File(System.getProperty("user.dir") + "/src/test/resources/testData/"+fileName+".csv");
        FileReader fileReader = null;
        CSVReader csvReader = null;
        String[] line = null;
        User userData;
        List<User> userlist = new ArrayList<>();

        try {
            fileReader = new FileReader(file);
            csvReader = new CSVReader(fileReader);
            csvReader.readNext(); // Skip header row
            while((line = csvReader.readNext())!=null){
                userData = new User(line[0],line[1]);
                userlist.add(userData);
            }

        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
        return userlist.iterator();


    }
}

