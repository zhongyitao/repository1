package com.cumt.web.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BasicServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取请求路径
        String uri = req.getRequestURI();
        //获取方法名称
        String methodName = "";
        if (uri.contains("?"))
        {
            methodName = uri.substring(uri.lastIndexOf("/") + 1,uri.indexOf("?"));
        }
        else
        {
            methodName = uri.substring(uri.lastIndexOf("/") + 1);

        }

        //获取方法
        try {
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //调用方法
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    /**
     * 将数据序列化到json并写回客户端
     * @param obj
     * @param response
     */
    public void writValue(Object obj, HttpServletResponse response) throws IOException {
        //将info对象序列化为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(obj);

        //将json数据写回客户端
        //设置content-type
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

}


