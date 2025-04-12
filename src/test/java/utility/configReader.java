package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {
    private static Properties properties;
    static{
        try{
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties= new Properties();
            properties.load(fis);
        }
        catch(IOException e){
            throw new RuntimeException("Failed to load properties file");
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
