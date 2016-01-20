package javase10.t02;

import java.util.Scanner;

/**
Спроектируйте БД, хранящую информацию, например, о домашней библиотеке.
Реализуйте функциональность добавления, поиска и удаления разнообразной информации из этой БД.
При реализации используйте (напишите) пул соединений и DAO.
*/

public class HomeLibraryManager {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        DAOLibrary daoLibrary = new DAOLibrary();
        System.out.println("\nWelcome. It is Home Library App.\n");

        printControlKeys();
        boolean exit = false;
        String input;
        do {
            System.out.println("Enter command:");
            input = sc.nextLine();
            switch (input) {
                case "exit":
                    exit = true;
                    break;
                case "info":
                    printControlKeys();
                    break;
                case "add book":
                    addBook();
                    break;
                case "add author":
                    addAuthor();
                    break;
                case "add genre":
                    addGenre();
                    break;
                case "search book by name":
                    searchBookByName();
                    break;
                case "search book by author":
                    searchBookByAuthor();
                    break;
                case "search book by genre":
                    searchBookByGenre();
                    break;
            }
        } while(!exit);
    }

    public static void printControlKeys(){

        System.out.println("Action:");
        System.out.println("info");
        System.out.println("add book");
        System.out.println("add author");
        System.out.println("add genre");
        System.out.println("search book by name");
        System.out.println("search book by author");
        System.out.println("search book by genre");
        System.out.println("exit");

    }

    public static void addBook() {

    }

    public static void addAuthor() {

    }

    public static void addGenre() {

    }

    public static void searchBookByName() {

    }

    public static void searchBookByAuthor() {

    }

    public static void searchBookByGenre() {

    }

}
