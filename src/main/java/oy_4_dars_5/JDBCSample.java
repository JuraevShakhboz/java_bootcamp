package oy_4_dars_5;

import java.sql.*;

public class JDBCSample {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/uyga_vazifa";
        String username = "postgres";
        String password = "1996";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            String surov = "insert into users(username, password, phone, email, role)" +
                    "values ('Shahboz',1996,'+998993105718','shaxboz@gmail.com','candidate');";

            ResultSet resultSet = statement.executeQuery(surov);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
