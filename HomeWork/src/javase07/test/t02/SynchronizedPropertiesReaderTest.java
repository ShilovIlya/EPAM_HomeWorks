package javase07.test.t02;

import javase07.t02.SynchronizedPropertiesReader;
import org.junit.Test;

public class SynchronizedPropertiesReaderTest {

    @Test
    public void PopertiesGetValidPropertyTest() {
        SynchronizedPropertiesReader propertiesReader = new SynchronizedPropertiesReader("D:\\GitHub\\EPAM\\HomeWork\\src\\resources\\my.properties");
        System.out.println(propertiesReader.getProperty("key1"));
    }

    @Test
    public void ThreadTest() {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                SynchronizedPropertiesReader propertiesReader =
                        new SynchronizedPropertiesReader("D:\\GitHub\\EPAM\\HomeWork\\src\\resources\\my.properties");
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(propertiesReader.getProperty("key2"));
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                SynchronizedPropertiesReader propertiesReader =
                        new SynchronizedPropertiesReader("D:\\GitHub\\EPAM\\HomeWork\\src\\resources\\my.properties");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(propertiesReader.getProperty("key3"));
            }
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
