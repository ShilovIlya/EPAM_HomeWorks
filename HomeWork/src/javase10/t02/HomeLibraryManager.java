package javase10.t02;

import javase10.t02.library.Book;

import java.util.ArrayList;
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
                    addBook(daoLibrary);
                    break;
                case "add author":
                    addAuthor(daoLibrary);
                    break;
                case "add genre":
                    addGenre(daoLibrary);
                    break;
                case "search book by name":
                    searchBookByName(daoLibrary);
                    break;
                case "search book by author":
                    searchBookByAuthor(daoLibrary);
                    break;
                case "search book by genre":
                    searchBookByGenre(daoLibrary);
                    break;
                case "delete book":
                    deleteBook(daoLibrary);
                    break;
                case "delete author":
                    deleteAuthor(daoLibrary);
                    break;
                case "delete genre":
                    deleteGenre(daoLibrary);
                    break;

            }
        } while(!exit);

        daoLibrary.endOfWork();

    }


    public static void printControlKeys(){

        System.out.println("Action:");
        System.out.println("info");
        System.out.println("add book");
        System.out.println("add author");
        System.out.println("add genre");
        System.out.println("delete book");
        System.out.println("delete author");
        System.out.println("delete genre");
        System.out.println("search book by name");
        System.out.println("search book by author");
        System.out.println("search book by genre");
        System.out.println("exit");

    }

    public static void addBook(DAOLibrary daoLibrary) {

        System.out.println("Please, enter book's name.");
        String book_name = sc.next();
        System.out.println("Please, enter book's author.");
        String author = sc.next();
        System.out.println("Please, enter book's genre.");
        String genre = sc.next();

        try {
            daoLibrary.addBook(book_name, author, genre);
        } catch (DAOLibraryException e) {
            System.out.println(e);
        }

    }

    public static void deleteBook(DAOLibrary daoLibrary) {

        System.out.println("Please, enter book's name.");
        String book_name = sc.next();
        System.out.println("Please, enter book's author.");
        String author = sc.next();
        System.out.println("Please, enter book's genre.");
        String genre = sc.next();

        try {
            daoLibrary.deleteBook(book_name, author, genre);
        } catch (DAOLibraryException e) {
            System.out.println(e);
        }

    }

    public static void addAuthor(DAOLibrary daoLibrary) {

        System.out.println("Please, enter author's name.");
        String author = sc.next();
        System.out.println("Please, enter author's country.");
        String country = sc.next();

        try {
            daoLibrary.addAuthor(author, country);
        } catch (DAOLibraryException e) {
            System.out.println(e);
        }
    }

    public static void deleteAuthor(DAOLibrary daoLibrary) {

        System.out.println("Please, enter author's name.");
        String author = sc.next();
        System.out.println("Please, enter author's country.");
        String country = sc.next();

        try {
            daoLibrary.deleteAuthor(author, country);
        } catch (DAOLibraryException e) {
            System.out.println(e);
        }
    }

    public static void addGenre(DAOLibrary daoLibrary) {

        System.out.println("Please, enter genre's name.");
        String genre = sc.next();

        try {
            daoLibrary.addGenre(genre);
        } catch (DAOLibraryException e) {
            System.out.println(e);
        }

    }

    public static void deleteGenre(DAOLibrary daoLibrary) {

        System.out.println("Please, enter genre's name.");
        String genre = sc.next();

        try {
            daoLibrary.deleteGenre(genre);
        } catch (DAOLibraryException e) {
            System.out.println(e);
        }

    }

    public static void searchBookByName(DAOLibrary daoLibrary) {

        System.out.println("Please, enter book's name.");
        String book_name = sc.nextLine();

        try {
            ArrayList<Book> books = daoLibrary.getBooksByName(book_name);

            if (books.size() == 0) {
                System.out.println("No books with this name");
            } else {
                for (Book book : books) {
                    System.out.println(book);
                }
            }
        } catch (DAOLibraryException e) {
            System.out.println(e);
        }


    }

    public static void searchBookByAuthor(DAOLibrary daoLibrary) {

        System.out.println("Please, enter author.");
        String author = sc.nextLine();

        try {
            ArrayList<Book> books = daoLibrary.getBooksByAuthor(author);
            for (Book book : books) {
                System.out.println(book);
            }
            if (books.size() == 0) {
                System.out.println("No books with this author");
            }
        } catch (DAOLibraryException e) {
            System.out.println(e);
        }

    }

    public static void searchBookByGenre(DAOLibrary daoLibrary) {

        System.out.println("Please, enter genre.");
        String genre = sc.nextLine();

        try {
            ArrayList<Book> books = daoLibrary.getBooksByGenre(genre);
            for (Book book : books) {
                System.out.println(book);
            }
            if (books.size() == 0) {
                System.out.println("No books with this genre");
            }
        } catch (DAOLibraryException e) {
            System.out.println(e);
        }

    }

}
