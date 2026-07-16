package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;
    static {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(file);
        } catch (IOException hata) {
            System.out.println("Config dosyası bulunamadı");
        }
    }
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
