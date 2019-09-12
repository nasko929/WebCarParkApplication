package factory;

import model.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarFactory {
    public static Car createFromForm(HttpServletRequest request) {
        Car newCar = new Car();
        String brand = request.getParameter("brand");
        String type = request.getParameter("type");
        String color = request.getParameter("color");
        newCar.setColor(color);
        newCar.setBrand(brand);
        newCar.setType(type);
        if (type.equals("Cabrio")) {
            String openedOrNot = request.getParameter("openedRoof");
            if (openedOrNot.equals("opened")) {
                newCar.setOpenedRoof(true);
            } else
                newCar.setOpenedRoof(false);
            newCar.setMaxSpeed(200);
            newCar.setMaxCapacity(800);
        } else if (type.equals("Sport")) {
            newCar.setMaxCapacity(400);
            newCar.setMaxSpeed(280);
        } else {
            newCar.setMaxCapacity(1500);
            newCar.setMaxSpeed(140);
        }
        return newCar;
    }

    public static Car createFromResultSet(ResultSet resultSet) throws SQLException {
        Car newCar = new Car();
        int id = resultSet.getInt("id");
        String brand = resultSet.getString("brand");
        String type = resultSet.getString("type");
        String color = resultSet.getString("color");
        int max_speed = resultSet.getInt("max_speed");
        int max_capacity = resultSet.getInt("max_capacity");
        int current_fuel = resultSet.getInt("current_fuel");
        int max_fuel = resultSet.getInt("max_fuel");
        boolean started_engine = resultSet.getBoolean("started_engine");
        boolean being_driven = resultSet.getBoolean("being_driven");
        newCar.setId(id);
        newCar.setColor(color);
        newCar.setBrand(brand);
        newCar.setType(type);
        newCar.setMaxSpeed(max_speed);
        newCar.setMaxCapacity(max_capacity);
        newCar.setCurrentFuel(current_fuel);
        newCar.setMaxFuel(max_fuel);
        newCar.setStartedEngine(started_engine);
        newCar.setBeingDriven(being_driven);

        if (type.equals("Cabrio")) {
            Boolean openedOrNot = resultSet.getBoolean("has_opened_roof");
            newCar.setOpenedRoof(openedOrNot);
        }
        return newCar;
    }
}
