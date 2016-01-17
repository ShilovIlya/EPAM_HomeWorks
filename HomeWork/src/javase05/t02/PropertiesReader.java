package javase05.t02;

import com.sun.javafx.fxml.PropertyNotFoundException;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/**
 * Создать “универсальный” класс, позволяющий получить значение из любого properties-файла.
 * Физическое чтение файла должно происходить только один раз.
 * Обработайте следующие исключительные ситуации:
 *      нет файла *.properties
 *      нет ключа в properties-файле.
 */
public class PropertiesReader {

    private Properties properties;

    public PropertiesReader(String path){

        properties = new Properties();

        try (InputStream inputStream = new FileInputStream(path)){
            properties.load(inputStream);
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
