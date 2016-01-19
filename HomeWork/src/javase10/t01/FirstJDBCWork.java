package javase10.t01;

import com.mysql.jdbc.*;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/*
  Создайте таблицу в БД и с помощью JDBC выполните следующие действия
 	извлеките информацию из таблицы с помощью подготовленного запроса;
 	обновите несколько записей в таблице;
 	выберите конкретную запись в таблице;
 	вставьте новую запись в таблицу;
 	удалите таблицу
*/

public class FirstJDBCWork {

    public static void printBooks(Connection conn, Statement st, ResultSet rs) throws SQLException {
        String query = "SELECT * FROM books";
        st = conn.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " +
                    rs.getString(2) + " " + rs.getInt(3)+ " " + rs.getInt(4));
        }
    }

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String updateQuery1 = "UPDATE books SET book=\"Ruslan i Ludmila\" WHERE id_book =1";
        String updateQuery2 = "UPDATE books SET book=\"Skazki\" WHERE id_book =4";
        String newRecord = "INSERT INTO genres VALUES(\"5\", \"short story\")";
        String newTable = "CREATE TABLE newtable (id_word int(10), word varchar(20))";
        String deleteNewTable = "DROP table newtable";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/home_library", "root", "root");

            preparedStatement = connection.prepareStatement("SELECT * FROM genres WHERE id_genre > ? OR genre = ?");
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "novel");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Номер в выборке " + resultSet.getRow() + ", номер в базе " +
                        resultSet.getInt("id_genre") + ", genre : " + resultSet.getString("genre"));
            }

            printBooks(connection, statement, resultSet);

            statement = connection.createStatement();
            statement.executeUpdate(updateQuery1);
            statement.executeUpdate(updateQuery2);

            System.out.println("After update:");
            printBooks(connection, statement, resultSet);

            resultSet = statement.executeQuery("SELECT * FROM genres WHERE id_genre = 2");
            while (resultSet.next()) {
                System.out.println("Номер в выборке " + resultSet.getRow() + ", номер в базе " +
                        resultSet.getInt("id_genre") + ", genre : " + resultSet.getString("genre"));
            }

            statement.executeUpdate(newRecord);
            resultSet = statement.executeQuery("SELECT * FROM genres");
            while (resultSet.next()) {
                System.out.println("Номер в выборке " + resultSet.getRow() + ", номер в базе " +
                        resultSet.getInt("id_genre") + ", genre : " + resultSet.getString("genre"));
            }

            statement.executeUpdate(newTable);
            statement.executeUpdate(deleteNewTable);

        } catch (ClassNotFoundException e) {
            System.out.println("no MySQL JDBC Driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            try {
                if (resultSet != null) { resultSet.close(); }
                if (statement != null) { statement.close(); }
                if (preparedStatement != null) { preparedStatement.close(); }
                if (connection != null) { connection.close(); }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

}
