package cn.cumt.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieServlet")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        //获取cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if (null != cookies && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                if ("lastTime".equals(cookieName)) {
                    flag = true;
                    String lastTime = cookie.getValue();
                    //url解码
                    String lastTimeDecode = URLDecoder.decode(lastTime, "utf-8");


                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String date_str = sdf.format(date);
                    String date_str_encode = URLEncoder.encode(date_str, "utf-8");
                    cookie.setValue(date_str_encode);
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    response.addCookie(cookie);


                    response.getWriter().write("<h1>欢迎回来！您上次的访问时间是" + lastTimeDecode + "</hi>");
                    break;

                }

            }
        }
        if (null == cookies || cookies.length == 0 || !flag)
        {
            //第一次访问

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String date_str = sdf.format(date);
            String date_str_encode = URLEncoder.encode(date_str, "utf-8");

            Cookie cookie = new Cookie("lastTime",date_str_encode);
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);


            response.getWriter().write("<h1>您好，欢迎您首次访问本站</hi>");

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
