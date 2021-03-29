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
                pw.println(rs.getString("job"));
                pw.println(rs.getString("age"));
            }

            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pw.println("<button onclick=\"window.history.back()\""+"type=\"button\">Cancel</button>");
    }

    public static void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String nameuser = request.getParameter("nameuser");
        String job = request.getParameter("job");
        int age = Integer.parseInt(request.getParameter("age"));

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

    public static void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String nameuser = request.getParameter("nameuser");

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

//    public static int showUserNumber() throws IOException {
//
//        int numberOfUsers = 0;
//
//        Connection connection = null;
//        try {
//            connection = DBConnection.getDBConncection();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        try {
//            assert connection != null;
//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS count FROM users");
//
//            numberOfUsers = Integer.parseInt(rs.getString("count"));
//            stmt.close();
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return numberOfUsers;
//    }

//    public static void addUser() throws IOException {
//
//        String nameuser = "nameuser";
//        String job = "job";
//        int age = 10;
//
//        Connection connection = null;
//        try {
//            connection = DBConnection.getDBConncection();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        try {
//            assert connection != null;
//            String sqlCommand = "INSERT INTO users (nameuser, job, age) Values (?, ?, ?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand);
//            preparedStatement.setString(1, nameuser);
//            preparedStatement.setString(2, job);
//            preparedStatement.setInt(3, age);
//            preparedStatement.executeUpdate();
//
//            preparedStatement.close();
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }


