package com.abc.in.excelAndPropertiesFileReadWrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesFileUtilities {

    

    String data;

    public String readDataFromPropertiesFile(String filePath, String key) {
                try {
                    File file = new File(filePath);
                    FileInputStream fis = new FileInputStream(file);
                    Properties prop = new Properties();
                    prop.load(fis);

                    data = prop.get(key).toString();
                } catch (Exception e) {
                    e.getMessage();
                }
                return data;

            }

    public void writeDataToPropertiesFile(String filePath, String key, String value, String message) {
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            Properties prop = new Properties();
            prop.load(fis);
            prop.setProperty(key, value);

            FileOutputStream fos = new FileOutputStream(file);
            prop.store(fos, message);

        } catch (Exception e) {
            e.getMessage();
        }

    }

}
