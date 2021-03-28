package com.example.UsersApp.Servlets;

import com.example.UsersApp.DB_Connection.DBConnection;
import com.example.UsersApp.DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


public class AddUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            DBConnection.getDBConncection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        UserDAO.addUser(request, response);

    }

}
