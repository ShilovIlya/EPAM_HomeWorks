package javase07.t02;

import com.sun.javafx.fxml.PropertyNotFoundException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SynchronizedPropertiesReader {

    private Properties properties;

    public SynchronizedPropertiesReader(String path){

        properties = new Properties();

        try (InputStream inputStream = new FileInputStream(path)){
            synchronized (inputStream) {
                properties.load(inputStream);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getProperty(String key) {
        String value;
        try {
            value = properties.getProperty(key);
            if (value == null) {
                throw new PropertyNotFoundException();
            }
            return value;
        } catch (PropertyNotFoundException e) {
            System.out.println("Properties not found");
        }

        return null;
    }

}
