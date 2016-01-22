package javase13.t02.DOM;


import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import javase13.t02.Food;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMFoodReader {

    private String xmlFilePath;
    private List<Food> menu;

    public DOMFoodReader(String xmlFilePath) {
        this.xmlFilePath = xmlFilePath;
    }


    public boolean analyze() {

        boolean valid = true;
        try {
            DOMParser parser = new DOMParser();
            parser.parse(xmlFilePath);
            Document document = parser.getDocument();
            Element root = document.getDocumentElement();
            menu = new ArrayList<>();
            NodeList foodNodes = root.getElementsByTagName("food");
            Food food = null;
            for (int i = 0; i < foodNodes.getLength(); i++) {
                food = new Food();
                Element foodElement = (Element) foodNodes.item(i);
                food.setId(Integer.parseInt(foodElement.getAttribute("id")));
                food.setName(getSingleChild(foodElement, "name").getTextContent().trim());
                food.setDescription(getSingleChild(foodElement, "description").getTextContent().trim());
                food.setPrice(getSingleChild(foodElement, "price").getTextContent().trim());

                menu.add(food);
            }

        } catch (SAXException e) {
            valid = false;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return valid;

    }

    private static Element getSingleChild(Element element, String childName) {
        NodeList nodeList = element.getElementsByTagName(childName);
        Element child = (Element) nodeList.item(0);
        return child;
    }

    public void printMenu() {
        for (Food food : menu) {
            System.out.println(food);
        }
    }

}
