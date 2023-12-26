package dars_46;

import java.sql.*;

public class Yangiliklar {
    public static void main(String[] args) throws SQLException {
        //addNews();
        updateNews(1);
        deleteNews(1);
        showNews();
    }

    public static void addNews() throws SQLException {
        String sql = "INSERT INTO xabar(id, title, content, author, date) VALUES (?,?,?,?,?)";

        try(Connection connection = DBConnection.connect();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, 2);
            statement.setString(2, "Sport");
            statement.setString(3, "Ozbekiston Jahon chempiyonatiga chiqa oladimi?");
            statement.setString(4, "Vali");
            statement.setString(5, "18.09.2021");

            statement.setInt(1, 3);
            statement.setString(2, "Mahalliy");
            statement.setString(3, "Toshkentda olam shumil yangiliklar");
            statement.setString(4, "Sardor");
            statement.setString(5, "15.10.2023");

            statement.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void updateNews(int id){
        String sql = "UPDATE xabar SET title=? WHERE id=?;";

        try (Connection connection = DBConnection.connect();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1,"Dunyo");
            pstmt.setInt(2, id);

            pstmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void deleteNews(int id) throws SQLException {
        String sql = "delete from xabar where id=?;";

        try (Connection connection = DBConnection.connect();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);

            statement.executeUpdate();
            connection.close();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void showNews(){
        String sql = "SELECT * FROM xabar";

        try(Connection connection = DBConnection.connect();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                System.out.println("id=" + rs.getString("id")
                        + ", title=" + rs.getString("title")
                        + ", content=" + rs.getString("content")
                        + ", author=" + rs.getString("author")
                        + ", date=" + rs.getString("date"));
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
