package com.cumt.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {


        System.out.println("过滤器执行了");
        ServletRequest proxyReq = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                if ("getParameterMap".equals(method.getName())) {
                    Map<String, String[]> map = (Map<String, String[]>) method.invoke(req, args);
                    Map proxyMap = new HashMap(map);

                    if (null != map) {
                        Set<String> keys = map.keySet();
                        for (String key : keys) {
                            String values = map.get(key)[0];
                            if (null != values && !"".equals(values)) {

                                for (String sensitiveWord : list) {
                                    if (values.contains(sensitiveWord)) {
                                        values = values.replace(sensitiveWord, "***");
                                    }
                                }
                            }
                            String[] valuesArray = {values};

                            proxyMap.replace(key,valuesArray);
                        }
                    }


                    return proxyMap;
                }


                return method.invoke(req, args);
            }
        });


        chain.doFilter(proxyReq, resp);
    }

    private List<String> list = new ArrayList<String>();
    public void init(FilterConfig config) throws ServletException {

        String realPath = config.getServletContext().getRealPath("/WEB-INF/classes/敏感词汇.txt");
        System.out.println(realPath);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(realPath),"UTF-8"));
            String line = null;
            while((line = bufferedReader.readLine()) != null)
            {
                list.add(line);
            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
