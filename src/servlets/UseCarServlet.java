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

@WebServlet(name = "UseCarServlet", urlPatterns = {"/UseCarServlet"})
public class UseCarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        CarOperations carOperations = new CarOperations();
        String idOfChosenCar = request.getParameter("id");
        if(idOfChosenCar.matches("^\\d+$")) {
            try {
                ResultSet resultSet = carOperations.findById(Integer.parseInt(idOfChosenCar));
                if(resultSet.next()) {
                    Car car = CarFactory.createFromResultSet(resultSet);
                    request.setAttribute("car",car);
                    request.getRequestDispatcher("car_usage.jsp").forward(request,response);
                }
                else {
                    request.setAttribute("car", null);
                    request.getRequestDispatcher("car_usage.jsp").forward(request, response);
                }
            } catch(Exception e) {
                e.printStackTrace();
                out.println("Error while fetching the data from the database.");
            }
        } else {
            request.setAttribute("car",null);
            request.getRequestDispatcher("car_usage.jsp").forward(request,response);
        }
    }
}
