package databaseOperations;

import databaseAccess.DatabaseAccess;
import model.Car;

import java.sql.*;

public class CarOperations {
    private static Connection connection;
    private static Statement statement;
    private static String preparedStatementUpdate;

    static {
        preparedStatementUpdate = "";
        try {
            connection = DatabaseAccess.makeConnection();
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet fetchAllData() throws SQLException {
        return statement.executeQuery("SELECT * FROM cars");
    }

    public ResultSet findById(int id) throws SQLException {
        return statement.executeQuery("SELECT * FROM cars WHERE id=" + id);
    }

    public void insertData(Car car) throws SQLException {
        String sqlColumns = "INSERT INTO cars (brand,type,color,max_speed,max_capacity,current_fuel,max_fuel" +
                ",started_engine,being_driven";
        String query = sqlColumns;

        String sqlValues = "VALUES('" + car.getBrand() + "','" + car.getType() + "','" + car.getColor()
                + "'," + car.getMaxSpeed() + "," + car.getMaxCapacity() + "," + car.getCurrentFuel()
                + "," + car.getMaxFuel() + "," + car.isStartedEngine() + "," + car.isBeingDriven();
        if (car.getType().equals("Cabrio")) {
            query += ",has_opened_roof) ";
            query += sqlValues;
            query += "," + car.isOpenedRoof() + ")";
        } else {
            query += ") ";
            query += sqlValues;
            query += ")";
        }
        try {
            int result = statement.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateData(Car car, int id) throws SQLException {
        String updateQuery = "UPDATE cars SET brand='" + car.getBrand() + "',type='" + car.getType() + "',color='"
                + car.getColor() + "',current_fuel="+car.getCurrentFuel()+",started_engine=";
        updateQuery += (car.isStartedEngine()) ? ("1,") : ("0,");
        updateQuery += "being_driven=";
        updateQuery += (car.isBeingDriven()) ? ("1 ") : ("0 ");
        updateQuery += "WHERE id=" + id;
        statement.executeUpdate(updateQuery);
    }

    public int deleteData(int id) throws SQLException {
        String query = "DELETE FROM cars WHERE id = " + id;
        return statement.executeUpdate(query);
    }
}
