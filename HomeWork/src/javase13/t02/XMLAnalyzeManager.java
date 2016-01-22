package javase13.t02;

import javase13.t02.DOM.DOMFoodReader;
import javase13.t02.SAX.SAXFoodReader;
import javase13.t02.StAX.StAXFoodReader;

public class XMLAnalyzeManager {

    public static void main(String[] args) {
        System.out.println("analyze by SAX:");
        SAXAnalyze();
        System.out.println("analyze by StAX:");
        StAXAnalyze();
        System.out.println("analyze by DOM:");
        DOMAnalyze();
    }

    public static void SAXAnalyze() {

        SAXFoodReader reader = new SAXFoodReader(".//src//javase13//t02//menu.xml");
        if (reader.analyze()) {
            reader.printMenu();
        } else {
            System.out.println("Bad xml.");
        }

    }

    public static void StAXAnalyze() {

        StAXFoodReader reader = new StAXFoodReader(".//src//javase13//t02//menu.xml");
        if (reader.analyze()) {
            reader.printMenu();
        } else {
            System.out.println("Bad xml.");
        }

    }

    public static void DOMAnalyze() {

        DOMFoodReader reader = new DOMFoodReader(".//src//javase13//t02//menu.xml");
        if (reader.analyze()) {
            reader.printMenu();
        } else {
            System.out.println("Bad xml.");
        }

    }

}
