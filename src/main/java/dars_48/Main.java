package dars_48;

import java.sql.*;

public class Main extends DorixonaOperations{
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            // CREATE
            String insertSQL1 = "INSERT INTO dorixona (dori_nomi, narxi, ishlab_chiqarilgan_sana, yaroqlilik_muddati, yaroqliylik) VALUES " +
                    "('Parasetamol', 1500.0, '2021-12-03', 36, true)";
            String insertSQL2 = "INSERT INTO dorixona (dori_nomi, narxi, ishlab_chiqarilgan_sana, yaroqlilik_muddati, yaroqliylik) VALUES " +
                    "('Setiramon', 1000.0, '2021-01-20', 36, true)";
            String insertSQL3 = "INSERT INTO dorixona (dori_nomi, narxi, ishlab_chiqarilgan_sana, yaroqlilik_muddati, yaroqliylik) VALUES " +
                    "('Trimol', 2500.0, '2020-01-25', 36, true)";
            String insertSQL4 = "INSERT INTO dorixona (dori_nomi, narxi, ishlab_chiqarilgan_sana, yaroqlilik_muddati, yaroqliylik) VALUES " +
                    "('Kyupen', 1000.0, '2015-05-05', 36, true)";
            stmt.executeUpdate(insertSQL1);
            stmt.executeUpdate(insertSQL2);
            stmt.executeUpdate(insertSQL3);
            stmt.executeUpdate(insertSQL4);

            // READ
            String selectSQL = "SELECT * FROM dorixona";
            ResultSet resultSet = stmt.executeQuery(selectSQL);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String dori_nomi = resultSet.getString("dori_nomi");
                double narxi = resultSet.getDouble("narxi");
                Date ishlab_chiqarilgan_sana = resultSet.getDate("ishlab_chiqarilgan_sana");
                int yaroqlilik_muddati = resultSet.getInt("yaroqlilik_muddati");
                boolean yaroqliylik = resultSet.getBoolean("yaroqliylik");

                System.out.println("ID: " + id + ", Dori nomi: " + dori_nomi + ", Narxi: " + narxi +
                        ", Ishlab chiqarilgan sana: " + ishlab_chiqarilgan_sana +
                        ", Yaroqlilik muddati: " + yaroqlilik_muddati +
                        ", Yaroqliylik: " + yaroqliylik);
            }

            // DELETE
            String deleteSQL = "DELETE FROM dorixona WHERE '2023' - EXTRACT(YEAR FROM ishlab_chiqarilgan_sana) > 3";
            stmt.executeUpdate(deleteSQL);

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
