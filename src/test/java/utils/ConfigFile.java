package utils;

import java.io.*;
import java.util.Properties;

public class ConfigFile {


    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUserName() {
        return properties.getProperty("userName");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }

    public static String getEndpoint() {
        return properties.getProperty("endpoint");
    }

}
