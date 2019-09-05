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

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取参数id
        String id = request.getParameter("id");
        //调用service方法deleteUser(id)
        UserService userService = new UserServiceImpl();
        boolean flag = userService.deleteUser(Integer.parseInt(id));

        //成功设置flag为true，失败则false
        request.getSession().setAttribute("flag",flag);

        //request.getRequestDispatcher("/findUserByPageServlet").forward(request,response);
        response.sendRedirect(request.getContextPath() + "/findUserByPageServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
