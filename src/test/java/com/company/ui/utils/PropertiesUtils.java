package com.company.ui.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

    public static String getProperty(String propertyName){
        Properties properties = new Properties();
        try (InputStream stream = PropertiesUtils.class.getResourceAsStream("/application.properties")) {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(propertyName);
    }
}
