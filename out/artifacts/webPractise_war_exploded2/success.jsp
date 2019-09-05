<%@ page import="cn.cumt.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: 逐梦
  Date: 2019/7/20
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>


    登录成功！欢迎你
    <%=
        ((User)(request.getSession().getAttribute("user"))).getUsername()
    %>

</body>
</html>
