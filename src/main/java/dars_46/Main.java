package dars_46;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        updateBook(4);
        //addBooks();
        showBooks();
    }

    public static void showBooks() throws SQLException {
        String sql = "select * from kitob";

        try(Connection connection = DBConnection.connect();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                System.out.println("Id=" + rs.getString("id")
                        + ", name=" + rs.getString("nomi")
                        + ", tarif=" + rs.getString("tarif"));
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void addBooks(){
        String sql = "insert into kitob(id, nomi, tarif) values(?,?,?)";

        try(Connection connection = DBConnection.connect();
            PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1, 4);
            pstmt.setString(2, "Mehrobdan chayon");
            pstmt.setString(3, "Bu asar badiy asar...");

            pstmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void updateBook(Integer id) throws SQLException {
        String sql = "update kitob set nomi=? where id=?";

        try (Connection connection = DBConnection.connect();
        PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1,"Yangi nom");
            pstmt.setInt(2, 3);

            pstmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
