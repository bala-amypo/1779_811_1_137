package com.example.demo.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;

public class SaasUserRolePermissionManager extends HttpServlet {

    // 🔥 MUST BE PUBLIC – test calls it directly
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write("OK");
    }
}
