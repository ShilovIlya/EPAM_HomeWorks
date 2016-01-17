package javase05.test.t02;

import javase05.t02.PropertiesReader;
import org.junit.Test;

public class PropertiesReaderTest {

    @Test
    public void PopertiesFileNotFoundTest() {

        PropertiesReader propertiesReader = new PropertiesReader("D:\\GitHub\\EPAM\\HomeWork\\src\\resources\\exception.properties");

    }

    @Test
    public void PopertiesNotFoundTest() {

        PropertiesReader propertiesReader = new PropertiesReader("D:\\GitHub\\EPAM\\HomeWork\\src\\resources\\my.properties");
        System.out.println(propertiesReader.getProperty("key2"));

    }


    @Test
    public void PopertiesGetValidPropertyTest() {

        PropertiesReader propertiesReader = new PropertiesReader("D:\\GitHub\\EPAM\\HomeWork\\src\\resources\\my.properties");
        System.out.println(propertiesReader.getProperty("key1"));

    }
}
