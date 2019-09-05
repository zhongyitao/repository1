package com.cumt.web.servlet;


import com.cumt.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteSelectedServlet")
public class DeleteSelectedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] userIds = request.getParameterValues("userId");
        UserServiceImpl userService = new UserServiceImpl();

        boolean flag = userService.deleteSelectedUser(userIds);

        request.getSession().setAttribute("flag",flag);


        response.sendRedirect(request.getContextPath() + "/findUserByPageServlet");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
