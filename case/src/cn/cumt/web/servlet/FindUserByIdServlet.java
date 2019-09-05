package cn.cumt.web.servlet;

import cn.cumt.domain.User;
import cn.cumt.service.UserService;
import cn.cumt.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserByIdServlet")
public class FindUserByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取参数id
        String id = request.getParameter("id");

        //调用service方法查询
        UserService userService = new UserServiceImpl();
        User user = userService.findUserById(Integer.parseInt(id));

        //将查询结果放入request域
        request.setAttribute("user",user);

        //转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
