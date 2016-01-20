package javase10.t02;

import javase10.t02.connectionpool.*;
import javase10.t02.library.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOLibrary {

    public Connection connection;

    public DAOLibrary() {

        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            connectionPool.initPooldData();
            connection = connectionPool.takeConnection();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Book> getBooksByName(String book_name) throws DAOLibraryException{

        ArrayList<Book> booksByName = null;
        String selectBooksByName = "SELECT * FROM books WHERE book = ?";
        String searchAuthorById = "SELECT * FROM authors WHERE id_author = ?";
        String searchGenreById = "SELECT * FROM genres WHERE id_genre = ?";
        ResultSet rsBook;
        ResultSet rsAuthor;
        ResultSet rsGenre;
        PreparedStatement psBook;
        PreparedStatement psAuthor;
        PreparedStatement psGenre;
        try {
            booksByName = new ArrayList<Book>();
            psBook = connection.prepareStatement(selectBooksByName);
            psAuthor = connection.prepareStatement(searchAuthorById);
            psGenre = connection.prepareStatement(searchGenreById);
            psBook.setString(1, book_name);
            rsBook = psBook.executeQuery();

            while (rsBook.next()) {
                psAuthor.setString(1, rsBook.getString("id_author"));
                rsAuthor = psAuthor.executeQuery();
                psGenre.setString(1, rsBook.getString("id_genre"));
                rsGenre = psGenre.executeQuery();
                booksByName.add(new Book(rsBook.getInt("id_book"), rsBook.getString("book"),
                                                rsAuthor.getString(2), rsGenre.getString(2)));
            }

        } catch (SQLException e) {
            throw new DAOLibraryException("Exception with searching books by name ", e);
        }

        return booksByName;

    }

    public ArrayList<Book> getBooksByAuthor(String author) throws DAOLibraryException{

        ArrayList<Book> booksByAuthor = null;
        String selectBooksByAuthor = "SELECT * FROM books WHERE id_author = ?";
        String searchAuthorByName = "SELECT * FROM authors WHERE author = ?";
        String searchGenreById = "SELECT * FROM genres WHERE id_genre = ?";
        ResultSet rsBook;
        ResultSet rsAuthor;
        ResultSet rsGenre;
        PreparedStatement psBook;
        PreparedStatement psAuthor;
        PreparedStatement psGenre;
        try {
            booksByAuthor = new ArrayList<Book>();
            psBook = connection.prepareStatement(selectBooksByAuthor);
            psAuthor = connection.prepareStatement(searchAuthorByName);
            psGenre = connection.prepareStatement(searchGenreById);
            psAuthor.setString(1, author);
            rsAuthor = psAuthor.executeQuery();
            psBook.setString(1, rsAuthor.getString("id_author"));
            rsBook = psBook.executeQuery();

            while (rsBook.next()) {
                psGenre.setString(1, rsBook.getString("id_genre"));
                rsGenre = psGenre.executeQuery();
                booksByAuthor.add(new Book(rsBook.getInt("id_book"), rsBook.getString("book"),
                        author, rsGenre.getString(2)));
            }

        } catch (SQLException e) {
            throw new DAOLibraryException("Exception with searching books by author.", e);
        }

        return booksByAuthor;
    }

    public ArrayList<Book> getBooksByGenre(String genre) throws DAOLibraryException{

        ArrayList<Book> booksByGenre = null;
        String selectBooksByGenre = "SELECT * FROM books WHERE id_genre = ?";
        String searchAuthorById = "SELECT * FROM authors WHERE id_author = ?";
        String searchGenreByName = "SELECT * FROM genres WHERE genre = ?";
        ResultSet rsBook;
        ResultSet rsAuthor;
        ResultSet rsGenre;
        PreparedStatement psBook;
        PreparedStatement psAuthor;
        PreparedStatement psGenre;
        try {
            booksByGenre = new ArrayList<Book>();
            psBook = connection.prepareStatement(selectBooksByGenre);
            psAuthor = connection.prepareStatement(searchAuthorById);
            psGenre = connection.prepareStatement(searchGenreByName);
            psGenre.setString(1, genre);
            rsGenre = psGenre.executeQuery();
            psBook.setString(1, rsGenre.getString("id_genre"));
            rsBook = psBook.executeQuery();

            while (rsBook.next()) {
                psAuthor.setString(1, rsBook.getString("id_author"));
                rsAuthor = psAuthor.executeQuery();
                booksByGenre.add(new Book(rsBook.getInt("id_book"), rsBook.getString("book"),
                        rsAuthor.getString(2), genre));
            }

        } catch (SQLException e) {
            throw new DAOLibraryException("Exception with searching books by genre.", e);
        }

        return booksByGenre;
    }

    public ArrayList<Book> getBooksByCountry(String country) throws DAOLibraryException {

        //todo: make body

        return null;

    }

    public void addBook(String name, String author, String genre) throws DAOLibraryException {

        String insertBook = "INSERT INTO books VALUES (?,?,?,?)";
        PreparedStatement psInsert;
        try {
            psInsert = connection.prepareStatement(insertBook);
            psInsert.setString(1, "10");
            psInsert.setString(2, name);
            psInsert.setString(3, author);
            psInsert.setString(4, genre);
            psInsert.executeUpdate();
        } catch (SQLException e) {
            throw new DAOLibraryException("Exception with adding book.", e);
        }

    }

    public void addGenre(String genre) throws DAOLibraryException{

        String insertBook = "INSERT INTO genres VALUES (?,?)";
        PreparedStatement psInsert;
        try {
            psInsert = connection.prepareStatement(insertBook);
            psInsert.setString(1, "10");
            psInsert.setString(2, genre);
            psInsert.executeUpdate();
        } catch (SQLException e) {
            throw new DAOLibraryException("Exception with adding genre.", e);
        }

    }

    public void addAuthor(String name, String country) throws DAOLibraryException{

        String insertBook = "INSERT INTO authors VALUES (?,?,?)";
        PreparedStatement psInsert;
        try {
            psInsert = connection.prepareStatement(insertBook);
            psInsert.setString(1, "10");
            psInsert.setString(2, name);
            psInsert.setString(3, country);
            psInsert.executeUpdate();
        } catch (SQLException e) {
            throw new DAOLibraryException("Exception with adding genre.", e);
        }
    }

}
