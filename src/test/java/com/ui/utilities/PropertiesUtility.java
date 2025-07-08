package com.ui.utilities;

import static com.ui.constants.Environments.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {

    public static String getProperty(String key)  {
        // Implementation to read property from a properties file
        // This is a placeholder method; actual implementation will depend on the properties file structure
        try {
        Properties properties = new Properties();
            File file = new File(System.getProperty("user.dir") +"\\configuration\\"+ QA + ".properties");
            properties.load(new FileInputStream(file));
            return properties.getProperty(key);
        } catch (FileNotFoundException e) {
            try {
                throw new FileNotFoundException("Properties file not found: " + e.getMessage());
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
