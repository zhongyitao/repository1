package cn.cumt.servlet;

import cn.cumt.dao.UserDao;
import cn.cumt.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet1")
public class LoginServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        String checkcode = request.getParameter("checkcode");
        System.out.println(checkcode);
        Map<String, String[]> parameterMap = request.getParameterMap();
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(loginUser);
        String checkcode_session = (String) request.getSession().getAttribute("checkCode");
        System.out.println(checkcode_session);
        request.getSession().removeAttribute("checkcode");
        if (checkcode_session.equalsIgnoreCase(checkcode))
        {
            UserDao dao = new UserDao();
            User login = dao.login(loginUser);
            if (null == login)
            {
                //登录失败，用户名或密码错误
                request.setAttribute("error","用户名或密码错误");
                request.getRequestDispatcher("/code_session.jsp").forward(request,response);
            }
            else
            {
                //登录成功
                HttpSession session = request.getSession();
                session.setAttribute("user",login);
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            }
        }
        else
        {
            //验证码错误
            request.setAttribute("error","验证码错误");
            request.getRequestDispatcher("/code_session.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
