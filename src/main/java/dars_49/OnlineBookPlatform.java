package dars_49;

import java.sql.*;

public class OnlineBookPlatform {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/kutubxona";
    static final String USER = "postgres";
    static final String PASS = "1996";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            // Foydalanuvchi jadvalini yaratish
            String createUserTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                    "id SERIAL PRIMARY KEY," +
                    "username VARCHAR(255) NOT NULL," +
                    "subscription_expiration_date DATE NOT NULL," +
                    "UNIQUE (username)" +
                    ")";
            stmt.executeUpdate(createUserTableSQL);

            // Foydalanuvchilarni qo'shish
//            String insertUserSQL = "INSERT INTO users (username, subscription_expiration_date) " +
//                    "VALUES ('Shahboz', '2023-12-31'), " +
//                    "('Hasanjon', '2023-11-15'), " +
//                    "('Zuxra', '2022-01-10'), " +
//                    "('Saidafzalxon', '2023-10-01')";
//            stmt.executeUpdate(insertUserSQL);

            // Foydalanuvchini tekshirish va kirish
            String checkUserSQL = "SELECT * FROM users WHERE username = 'Saidafzalxon' AND subscription_expiration_date >= CURRENT_DATE";
            ResultSet resultSet = stmt.executeQuery(checkUserSQL);
            if (resultSet.next()) {
                System.out.println("Obuna muddati tugamagan. Kirish mumkin.");
            } else {
                System.out.println("Obuna muddati tugagan. Kirish mumkin emas.");
            }

            // Resource'lar tozalash
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
