package javase06.t02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Создать “универсальный” класс, позволяющий получить значение из любого properties-файла.
 * Физическое чтение файла должно происходить только один раз.
 * Результаты чтения храните в коллекции типа Map.
 * Ответьте на вопрос: как ведет себя map-коллекция если в нее добавить элемент с ключом, который уже присутствует?
 */

public class MapPropertiesReader {

    private HashMap<String, String> propertiesMap;

    public MapPropertiesReader(String path){

        Properties properties = new Properties();

        try (InputStream inputStream = new FileInputStream(path)){
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        propertiesMap = new HashMap<>();

        for (Map.Entry<Object, Object>  entry : properties.entrySet()) {
            propertiesMap.put((String)entry.getKey(), (String)entry.getValue());
        }

    }

    public String getProperty(String key) {

        return propertiesMap.get(key);

    }


}
