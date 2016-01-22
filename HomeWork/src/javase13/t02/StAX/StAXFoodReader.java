package javase13.t02.StAX;


import javase13.t02.Food;
import javase13.t02.MenuTagName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StAXFoodReader {

    private String xmlFilePath;
    private List<Food> menu;

    public StAXFoodReader(String xmlFilePath) {
        this.xmlFilePath = xmlFilePath;
    }

    public boolean analyze() {

        boolean valid = true;
        try (InputStream input = new FileInputStream(xmlFilePath)) {

            XMLInputFactory inputFactory = XMLInputFactory.newInstance();


            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);

            menu = process(reader);

        } catch (XMLStreamException e) {
            valid = false;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return valid;
    }

    public List<Food> process(XMLStreamReader reader) throws XMLStreamException {

        List<Food> menu = new ArrayList<>();
        Food food = null;
        MenuTagName elementName = null;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = MenuTagName.valueOf(reader.getLocalName().toUpperCase().replace("-", "_"));
                    switch (elementName) {
                        case FOOD:
                            food = new Food();
                            food.setId(Integer.parseInt(reader.getAttributeValue(null, "id")));
                            break;
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();

                    if (text.isEmpty()) {
                        break;
                    }
                    switch (elementName) {
                        case NAME:
                            food.setName(text);
                            break;
                        case PRICE:
                            food.setPrice(text);
                            break;
                        case DESCRIPTION:
                            food.setDescription(text);
                            break;
                        case CALORIES:
                            food.setCalories(Integer.parseInt(text));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = MenuTagName.valueOf(reader.getLocalName().toUpperCase().replace("-","_"));
                    switch (elementName) {
                        case FOOD:
                            menu.add(food);
                    }
            }
        }
        return menu;

    }

    public void printMenu() {
        for (Food food : menu) {
            System.out.println(food);
        }
    }

}
