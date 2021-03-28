package com.example.UsersApp.DB_Connection;
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

        Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.43.52:5432/postgres",
                    "postgres",
                    "1234567");

        return connection;
    }

}
