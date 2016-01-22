package javase13.t02.SAX;


import javase13.t02.Food;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class SAXFoodReader {

    private String xmlFilePath;
    private List<Food> menu;

    public SAXFoodReader(String xmlFilePath) {
        this.xmlFilePath = xmlFilePath;
    }

    public boolean analyze() {

        boolean valid = true;
        try {

            XMLReader reader = XMLReaderFactory.createXMLReader();
            MenuSaxHandler handler = new MenuSaxHandler();
            reader.setContentHandler(handler);
            reader.parse(new InputSource(xmlFilePath));

            reader.setFeature("http://xml.org/sax/features/validation", true);
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/string-interning", true);
            reader.setFeature("http://apache.org/xml/features/validation/schema", false);

            menu = handler.getFoodList();

        } catch (SAXException e) {
            valid = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return valid;
    }

    public void printMenu() {
        for (Food food : menu) {
            System.out.println(food);
        }
    }


}
