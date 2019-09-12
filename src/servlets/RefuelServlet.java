package servlets;

import databaseOperations.CarOperations;
import factory.CarFactory;
import model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet(name = "RefuelServlet", urlPatterns = {"/RefuelServlet"})
public class RefuelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String idOfChosenCar = request.getParameter("id");
        CarOperations carOperations = new CarOperations();
        if (idOfChosenCar.matches("^\\d+$")) {
            try {
                int id = Integer.parseInt(idOfChosenCar);
                ResultSet resultSet = carOperations.findById(id);
                if (resultSet.next()) {
                    Car car = CarFactory.createFromResultSet(resultSet);
                    if (!car.isStartedEngine() && !car.isBeingDriven() && car.getCurrentFuel() < car.getMaxFuel()) {
                        car.setCurrentFuel(car.getMaxFuel());
                        carOperations.updateData(car, id);
                    } else if (car.isBeingDriven()) {
                        request.setAttribute("error", "The car is being driven, you can't refuel.");
                    } else if (car.isStartedEngine()) {
                        request.setAttribute("error", "The car's engine is started, you can't refuel.");
                    } else if (car.getCurrentFuel() == car.getMaxFuel()) {
                        request.setAttribute("error", "This car has maximum fuel.");
                    }
                    request.setAttribute("car", car);
                    request.getRequestDispatcher("car_usage.jsp").forward(request, response);
                } else {
                    request.setAttribute("car", null);
                    request.getRequestDispatcher("car_usage.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
                out.println("Error while fetching the data from the database.");
            }
        } else {
            request.setAttribute("car", null);
            request.setAttribute("error", "Invalid id.");
            request.getRequestDispatcher("car_usage.jsp").forward(request, response);
        }
    }
}
