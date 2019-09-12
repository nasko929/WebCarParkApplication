package servlets;

import databaseAccess.DatabaseAccess;
import databaseOperations.CarOperations;
import factory.CarFactory;
import model.Car;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FormProcessServlet", urlPatterns = {"/FormProcessServlet"})
public class FormProcessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        Car currCar = CarFactory.createFromForm(request);
        out.println("<html><body>");
        CarOperations carOperations = new CarOperations();
        try {
            carOperations.insertData(currCar);
        } catch (Exception e) {
            out.println("There was an error with submitting the form into the database. Please try again.");
        }
        out.println("Form submitted successfully. Redirecting you to home page...");

        out.println("</body></html>");
        response.sendRedirect("index.jsp");

    }
}
