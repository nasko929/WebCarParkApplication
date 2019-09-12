package databaseAccess;

        import java.sql.*;

public class DatabaseAccess {
    public static Connection makeConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training_all_stuff",
                    "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
