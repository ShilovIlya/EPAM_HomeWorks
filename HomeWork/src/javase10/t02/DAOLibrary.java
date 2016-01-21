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
    private ConnectionPool connectionPool;

    public DAOLibrary() {

        connectionPool = ConnectionPool.getInstance();
        try {
            connectionPool.initPooldData();
            connection = connectionPool.takeConnection();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }

    }

    public void endOfWork() {
        connectionPool.dispose();
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

                if (!rsAuthor.next()) {
                    throw new DAOLibraryException("No this author. Please add author.");
                }
                if (!rsGenre.next()) {
                    throw new DAOLibraryException("No this genre. Please add genre.");
                }
                booksByName.add(new Book(rsBook.getInt("id_book"), rsBook.getString("book"),
                                                rsAuthor.getString("author"), rsGenre.getString("genre")));
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
            if (!rsAuthor.next()) {
                throw new DAOLibraryException("No this author. Please add author.");
            }

            psBook.setString(1, rsAuthor.getString("id_author"));
            rsBook = psBook.executeQuery();

            while (rsBook.next()) {
                psGenre.setString(1, rsBook.getString("id_genre"));
                rsGenre = psGenre.executeQuery();

                if (!rsGenre.next()) {
                    throw new DAOLibraryException("No this genre. Please add genre.");
                }

                booksByAuthor.add(new Book(rsBook.getInt("id_book"), rsBook.getString("book"),
                        author, rsGenre.getString("genre")));
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
            if (!rsGenre.next()) {
                throw new DAOLibraryException("No this genre. Please add genre.");
            }

            psBook.setString(1, rsGenre.getString("id_genre"));
            rsBook = psBook.executeQuery();

            while (rsBook.next()) {
                psAuthor.setString(1, rsBook.getString("id_author"));
                rsAuthor = psAuthor.executeQuery();

                if (!rsAuthor.next()) {
                    throw new DAOLibraryException("No this author. Please add author.");
                }

                booksByGenre.add(new Book(rsBook.getInt("id_book"), rsBook.getString("book"),
                        rsAuthor.getString("author"), genre));
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

        String insert = "INSERT INTO books (book, id_author, id_genre) VALUES (?,?,?)";
        PreparedStatement psInsert;
        String selectIdAuthor = "SELECT id_author FROM authors WHERE author = ?";
        String selectIdGenre = "SELECT id_genre FROM genres WHERE genre = ?";
        ResultSet rsAuthor;
        ResultSet rsGenre;
        PreparedStatement psAuthor;
        PreparedStatement psGenre;
        try {
            psAuthor = connection.prepareStatement(selectIdAuthor);
            psGenre = connection.prepareStatement(selectIdGenre);

            psAuthor.setString(1, author);
            rsAuthor = psAuthor.executeQuery();
            if (!rsAuthor.next()) {
                throw new DAOLibraryException("No this author. Please add author.");
            }

            psGenre.setString(1, genre);
            rsGenre = psGenre.executeQuery();
            if (!rsGenre.next()) {
                throw new DAOLibraryException("No this genre. Please add genre.");
            }

            psInsert = connection.prepareStatement(insert);
            psInsert.setString(1, name);
            psInsert.setString(2, rsAuthor.getString("id_author"));
            psInsert.setString(3, rsGenre.getString("id_genre"));
            psInsert.executeUpdate();
        } catch (SQLException e) {
            throw new DAOLibraryException("Exception with adding book.", e);
        }

    }

    public void addGenre(String genre) throws DAOLibraryException{

        String insert = "INSERT INTO genres (genre) VALUES (?)";
        PreparedStatement psInsert;
        try {
            psInsert = connection.prepareStatement(insert);
            psInsert.setString(1, genre);
            psInsert.executeUpdate();
        } catch (SQLException e) {
            throw new DAOLibraryException("Exception with adding genre.", e);
        }

    }

    public void addAuthor(String name, String country) throws DAOLibraryException{

        String insert = "INSERT INTO authors (author, country) VALUES (?,?)";
        PreparedStatement psInsert;
        try {
            psInsert = connection.prepareStatement(insert);
            psInsert.setString(1, name);
            psInsert.setString(2, country);
            psInsert.executeUpdate();
        } catch (SQLException e) {
            throw new DAOLibraryException("Exception with adding genre.", e);
        }
    }

    public void deleteBook(String name, String author, String genre) throws DAOLibraryException {

        String delete = "DELETE FROM books WHERE book = ? AND id_author = ? AND id_genre = ?";
        PreparedStatement psDelete;
        String selectIdAuthor = "SELECT id_author FROM authors WHERE author = ?";
        String selectIdGenre = "SELECT id_genre FROM genres WHERE genre = ?";
        ResultSet rsAuthor;
        ResultSet rsGenre;
        PreparedStatement psAuthor;
        PreparedStatement psGenre;
        try {
            psAuthor = connection.prepareStatement(selectIdAuthor);
            psGenre = connection.prepareStatement(selectIdGenre);

            psAuthor.setString(1, author);
            rsAuthor = psAuthor.executeQuery();
            if (!rsAuthor.next()) {
                throw new DAOLibraryException("No book with this author.");
            }

            psGenre.setString(1, genre);
            rsGenre = psGenre.executeQuery();
            if (!rsGenre.next()) {
                throw new DAOLibraryException("No book with genre.");
            }

            psDelete = connection.prepareStatement(delete);
            psDelete.setString(1, name);
            psDelete.setString(2, rsAuthor.getString("id_author"));
            psDelete.setString(3, rsGenre.getString("id_genre"));
            psDelete.executeUpdate();
        } catch (SQLException e) {
            throw new DAOLibraryException("Exception with deleting book.", e);
        }

    }

    public void deleteAuthor(String name, String country) throws DAOLibraryException{

        String deleteAuthor = "DELETE FROM authors WHERE author = ? AND country = ?";
        String selectBookDelete = "SELECT * FROM books WHERE id_author = ?";
        String selectIdAuthor = "SELECT id_author FROM authors WHERE author = ? AND country = ?";
        String selectBookAuthorById = "SELECT author FROM authors WHERE id_authors = ?";
        String selectBookGenreById = "SELECT genre FROM genres WHERE id_genre = ?";

        PreparedStatement psDeleteAuthor;
        PreparedStatement psDeleteBook;
        PreparedStatement psIdAuthor;
        PreparedStatement psSelectBookAuthorById;
        PreparedStatement psSelectBookGenreById;

        ResultSet rsDeleteBook;
        ResultSet rsIdAuthor;
        ResultSet rsSelectBookAuthorById;
        ResultSet rsSelectBookGenreById;


        try {
            psDeleteAuthor = connection.prepareStatement(deleteAuthor);
            psDeleteBook = connection.prepareStatement(selectBookDelete);
            psIdAuthor = connection.prepareStatement(selectIdAuthor);
            psSelectBookAuthorById = connection.prepareStatement(selectBookAuthorById);
            psSelectBookGenreById = connection.prepareStatement(selectBookGenreById);

            psIdAuthor.setString(1, name);
            psIdAuthor.setString(2, country);
            rsIdAuthor = psIdAuthor.executeQuery();
            while (rsIdAuthor.next()) {
                psDeleteBook.setString(1, rsIdAuthor.getString("id_author"));
                rsDeleteBook = psDeleteBook.executeQuery();

                while (rsDeleteBook.next()) {

                    psSelectBookAuthorById.setString(1, rsDeleteBook.getString("id_author"));
                    psSelectBookGenreById.setString(1, rsDeleteBook.getString("id_genre"));

                    rsSelectBookAuthorById = psSelectBookAuthorById.executeQuery();
                    rsSelectBookGenreById = psSelectBookGenreById.executeQuery();

                    if (rsSelectBookAuthorById.next() && rsSelectBookGenreById.next()) {
                        deleteBook(rsDeleteBook.getString("book"), rsSelectBookAuthorById.getString("author"),
                                                                    rsSelectBookGenreById.getString("genre"));
                    }
                }
            }

            psDeleteAuthor = connection.prepareStatement(deleteAuthor);
            psDeleteAuthor.setString(1, name);
            psDeleteAuthor.setString(2, country);
            psDeleteAuthor.executeUpdate();
        } catch (SQLException e) {
            throw new DAOLibraryException("Exception with adding genre.", e);
        }
    }

    public void deleteGenre(String genre) throws DAOLibraryException{

        String deleteGenre = "DELETE FROM genres WHERE genre = ?";
        String selectBookDelete = "SELECT * FROM books WHERE id_genre = ?";
        String selectIdGenre = "SELECT id_genre FROM genres WHERE genre = ?";
        String selectBookAuthorById = "SELECT author FROM authors WHERE id_authors = ?";
        String selectBookGenreById = "SELECT genre FROM genres WHERE id_genre = ?";

        PreparedStatement psDeleteGenre;
        PreparedStatement psDeleteBook;
        PreparedStatement psIdGenre;
        PreparedStatement psSelectBookAuthorById;
        PreparedStatement psSelectBookGenreById;

        ResultSet rsDeleteBook;
        ResultSet rsIdGenre;
        ResultSet rsSelectBookAuthorById;
        ResultSet rsSelectBookGenreById;


        try {
            psDeleteGenre = connection.prepareStatement(deleteGenre);
            psDeleteBook = connection.prepareStatement(selectBookDelete);
            psIdGenre = connection.prepareStatement(selectIdGenre);
            psSelectBookAuthorById = connection.prepareStatement(selectBookAuthorById);
            psSelectBookGenreById = connection.prepareStatement(selectBookGenreById);

            psIdGenre.setString(1, genre);
            rsIdGenre = psIdGenre.executeQuery();
            while (rsIdGenre.next()) {
                psDeleteBook.setString(1, rsIdGenre.getString("id_genre"));
                rsDeleteBook = psDeleteBook.executeQuery();

                while (rsDeleteBook.next()) {

                    psSelectBookAuthorById.setString(1, rsDeleteBook.getString("id_author"));
                    psSelectBookGenreById.setString(1, rsDeleteBook.getString("id_genre"));

                    rsSelectBookAuthorById = psSelectBookAuthorById.executeQuery();
                    rsSelectBookGenreById = psSelectBookGenreById.executeQuery();

                    if (rsSelectBookAuthorById.next() && rsSelectBookGenreById.next()) {
                        deleteBook(rsDeleteBook.getString("book"), rsSelectBookAuthorById.getString("author"),
                                rsSelectBookGenreById.getString("genre"));
                    }
                }
            }

            psDeleteGenre = connection.prepareStatement(deleteGenre);
            psDeleteGenre.setString(1, genre);
            psDeleteGenre.executeUpdate();
        } catch (SQLException e) {
            throw new DAOLibraryException("Exception with deleting genre.", e);
        }
    }

}
