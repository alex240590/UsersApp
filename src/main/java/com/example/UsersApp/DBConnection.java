package com.example.UsersApp;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class DBConnection {

    public static Connection getDBConncection() throws SQLException{

        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java_ee_db",
                    "postgres",
                    "root");

        return connection;
    }

}
