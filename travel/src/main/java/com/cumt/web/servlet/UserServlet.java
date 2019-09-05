package com.cumt.web.servlet;

import com.cumt.domain.ResultInfo;
import com.cumt.domain.User;
import com.cumt.service.UserService;
import com.cumt.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BasicServlet {

    private UserService userService = new UserServiceImpl();

    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取验证码
        String checkCode = request.getParameter("checkcode");
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode");
        session.removeAttribute("checkCode");
        ResultInfo resultInfo = new ResultInfo();
        if (checkCode.equalsIgnoreCase(checkCode_session))
        {
            //获取参数
            Map<String, String[]> parameterMap = request.getParameterMap();
            //封装到实体类
            User user = new User();
            try {
                BeanUtils.populate(user, parameterMap);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            //调用service方法注册
            resultInfo = userService.register(user);
        }
        else
        {
            resultInfo.setFlag(false);
            resultInfo.setErrorMessage("验证码不正确");
        }


        //将info对象序列化为json
        writValue(resultInfo, response);

    }

    public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //获取激活码
        String code = request.getParameter("code");
        if (null != code)
        {
            String msg = "";
            boolean flag = userService.active(code);
            if (flag)
            {
                //激活成功
                msg = "激活成功，请<a href='../login.html'>登录</a>";
            }
            else
            {
                msg = "激活失败，请联系管理员!";
            }

            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }

    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取验证码
        String checkCode = request.getParameter("checkcode");
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode");
        session.removeAttribute("checkCode");
        ResultInfo resultInfo = new ResultInfo();
        if (checkCode.equalsIgnoreCase(checkCode_session))
        {
            //获取数据
            Map<String, String[]> parameterMap = request.getParameterMap();
            User user = new User();
            try {
                BeanUtils.populate(user,parameterMap);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            User u = userService.login(user);
            if (null == u)
            {
                resultInfo.setFlag(false);
                resultInfo.setErrorMessage("用户名或密码错误");
            }
            if (null != u && "Y".equals(u.getStatus()))
            {
                //登录成功
                resultInfo.setFlag(true);
                request.getSession().setAttribute("user",u);
            }
            if (null != u && !"Y".equals(u.getStatus()))
            {
                resultInfo.setFlag(false);
                resultInfo.setErrorMessage("您尚未激活，请激活");
            }
        }
        else
        {
            resultInfo.setFlag(false);
            resultInfo.setErrorMessage("验证码不正确");
        }


        //将info对象序列化为json
        writValue(resultInfo, response);

    }

}
