package com.cumt.web.servlet;



import com.cumt.domain.User;
import com.cumt.service.UserService;
import com.cumt.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取数据
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用service方法添加用户信息
        UserService userService = new UserServiceImpl();
        boolean flag = userService.addUser(user);

        //成功设置flag为true，失败则false
        request.getSession().setAttribute("flag",flag);

        //返回列表
        //request.getRequestDispatcher("/findUserByPageServlet").forward(request,response);
        response.sendRedirect(request.getContextPath() + "/findUserByPageServlet");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
