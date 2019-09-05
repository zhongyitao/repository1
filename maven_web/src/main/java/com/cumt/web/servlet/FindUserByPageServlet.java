package com.cumt.web.servlet;

import com.cumt.domain.PageBean;
import com.cumt.domain.User;
import com.cumt.service.UserService;
import com.cumt.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");


        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        if (null == currentPage || "".equals(currentPage))
        {
            currentPage = "1";
        }
        if (null == rows || "".equals(rows))
        {
            rows = "5";
        }


        Map<String, String[]> parameterMap = request.getParameterMap();
        UserService userService = new UserServiceImpl();


        PageBean<User> pageBean = userService.findUserByFactor(currentPage,rows,parameterMap);



        //把查询结果放到request域中
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("parameterMap",parameterMap);

        //转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
