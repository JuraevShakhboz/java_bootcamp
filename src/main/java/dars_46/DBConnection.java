package dars_46;

import java.sql.*;

public class DBConnection {
    private static final String url = "jdbc:postgresql://localhost:5432/yangiliklar";
    private static final String user = "postgres";
    private static final String password = "1996";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
