package dars_46;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDars {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/students";
        String username = "postgres";
        String password = "1996";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE DATABASE kutubxona");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
