package servlets;

import databaseOperations.CarOperations;
import factory.CarFactory;
import model.Car;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.*;

@WebServlet(name = "ShowAllCarsServlet", urlPatterns = {"/ShowAllCarsServlet"})
public class ShowAllCarsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        CarOperations carOperations = new CarOperations();
        List<Car> cars = new ArrayList<>();
        try {
            ResultSet resultSet = carOperations.fetchAllData();
            while(resultSet.next()) {
                Car car = CarFactory.createFromResultSet(resultSet);
                cars.add(car);
            }
            request.setAttribute("cars", cars);
            request.getRequestDispatcher("car_choose.jsp").forward(request, response);
        } catch(Exception e) {
            e.printStackTrace();
            out.println("Error while fetching the data from the database.");
        }
    }
}
