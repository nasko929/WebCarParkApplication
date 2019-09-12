package servlets;

import java.sql.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;


@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training_all_stuff",
                    "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM names");
            while(resultSet.next()) {
                out.println(resultSet.getInt(1) + " " + resultSet.getString(2)
                 + " " + resultSet.getString(3) + "<br>");
            }
            out.println("Everything is fine.");
        } catch(Exception e) {
            out.println("Sadly there is a problem with the connection to the database.<br>");
        }
    }
}
