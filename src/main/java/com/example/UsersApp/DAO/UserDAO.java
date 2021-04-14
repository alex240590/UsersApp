package com.example.UsersApp.DAO;

import com.example.UsersApp.DB_Connection.DBConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class UserDAO {

    public static void showUserList(HttpServletResponse response) throws IOException {
        PrintWriter pw = response.getWriter();


        Connection connection = null;
        try {
            connection = DBConnection.getDBConncection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            assert connection != null;
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nameuser, job, age from users");

            while (rs.next()) {
                pw.println(rs.getString("nameuser"));
                String name = rs.getString("nameuser");
                pw.println(rs.getString("job"));
                String job = rs.getString("job");
                pw.println(rs.getString("age"));
                String age = rs.getString("age");
            }

            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String nameuser = request.getParameter("name");
        String job = request.getParameter("job");
        int age = Integer.parseInt(request.getParameter("age"));
//        response.sendRedirect();

        Connection connection = null;
        try {
            connection = DBConnection.getDBConncection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            assert connection != null;
            String sqlCommand = "INSERT INTO users (nameuser, job, age) Values (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand);
            preparedStatement.setString(1, nameuser);
            preparedStatement.setString(2, job);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pw.println("Added: "+nameuser+" "+job+" "+age);
    }

    public static void kafka(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String nameuser=request.getParameter("name");
        response.sendRedirect("localhost:2181");


        pw.println("Sent: "+nameuser);
    }

    public static void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String nameuser = request.getParameter("name");

        Connection connection = null;
        try {
            connection = DBConnection.getDBConncection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            assert connection != null;
            String sqlCommand = "DELETE FROM users WHERE nameuser=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand);
            preparedStatement.setString(1, nameuser);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pw.println("Deleted: "+nameuser);
    }

}
