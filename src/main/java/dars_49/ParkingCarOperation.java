package dars_49;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ParkingCarOperation extends ParkingCar {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();

            String createTable = "CREATE TABLE parking_car(id SERIAL, avto_number VARCHAR(50), price numeric(7,2), started_time timestamp default current_timestamp, end_time timestamp, payment numeric(7, 2))";
            statement.execute(createTable);

            String insertSQL1 = "INSERT INTO parking_car(avto_number, price) VALUES('10 A100 AAA', 10)";
            String insertSQL2 = "INSERT INTO parking_car(avto_number, price) VALUES('30 Z777 ZZZ', 10)";
            String insertSQL3 = "INSERT INTO parking_car(avto_number, price) VALUES('01 X222 PAA', 10)";
            statement.executeUpdate(insertSQL1);
            statement.executeUpdate(insertSQL2);
            statement.executeUpdate(insertSQL3);

//            String selectSQL = "SELECT * FROM parking_car";
//            ResultSet resultSet = statement.executeQuery(selectSQL);
//            while (resultSet.next()){
//
//            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
