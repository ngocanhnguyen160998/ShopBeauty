package com.shop.controller;

import com.shop.model.entity.EmailSubEntity;
import com.shop.repository.impl.EmailSubRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("/subemail")
public class EmailSubController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            new EmailSubRepositoryImpl().insert(new EmailSubEntity(null,request.getParameter("email"), LocalDate.now()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/index");
    }
}
