package javase06.test.t02;

import javase06.t02.MapPropertiesReader;
import org.junit.Test;


public class MapPropertiesReaderTest {

    @Test
    public void getValueTest(){

        MapPropertiesReader mapPropertiesReader = new MapPropertiesReader("D:\\GitHub\\EPAM\\HomeWork\\src\\resources\\my.properties");
        System.out.println("value for key1 = " + mapPropertiesReader.getProperty("key1"));
        System.out.println("value for key2 = " + mapPropertiesReader.getProperty("key2"));
        System.out.println("value for key3 = " + mapPropertiesReader.getProperty("key3"));

    }

}
