package com.example.UsersApp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


public class UserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter pw = response.getWriter();

        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java_ee_db",
                    "postgres",
                    "root");

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nameuser, job, age from users");

            while(rs.next()){
                pw.println(rs.getString("nameuser"));
                pw.println(rs.getString("job"));
                pw.println(rs.getString("age"));
            }

            stmt.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

}
