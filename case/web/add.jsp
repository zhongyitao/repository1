<%--
  Created by IntelliJ IDEA.
  User: 逐梦
  Date: 2019/7/21
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>首页</title>

    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="/js/jquery.min.js"></script>

    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="/js/bootstrap.min.js"></script>

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container" style="width: 400px">
    <div>
        <h3 style="text-align: center">修改用户信息</h3>
    </div>
    <div>
        <form action="${pageContext.request.contextPath}/addServlet" method="post">
            <%--<!--  隐藏域 提交id-->
            <input type="hidden" name="id" value="${user.id}">--%>
            <div class="form-group">
                <label for="name">姓名：</label>
                <input type="text" name="name" class="form-control" id="name" placeholder="请输入姓名" >
            </div>
            <div class="form-group">
                <label>性别：</label>
                <label>
                    <input type="radio" name="gender" id="male" value="男" checked>男&nbsp;
                    <input type="radio" name="gender" id="female" value="女">女

                </label>
            </div>
            <div class="form-group">
                <label for="age">年龄：</label>
                <input type="text" name="age" class="form-control" id="age" placeholder="请输入年龄">
            </div>
            <div class="form-group">
                <label for="age">籍贯：</label>
                <select class="form-control" name="address" id="address">
                    <option value="北京">北京</option>
                    <option value="上海">上海</option>
                    <option value="南京">南京</option>
                    <option value="深圳">深圳</option>
                    <option value="苏州">苏州</option>
                </select>
            </div>
            <div class="form-group">
                <label for="qq">QQ：</label>
                <input type="text" name="qq" class="form-control" id="qq" placeholder="请输入qq号">
            </div>
            <div class="form-group">
                <label for="email">Email：</label>
                <input type="email" name="email" class="form-control" id="email" placeholder="请输入邮箱">
            </div>

            <div class="form-group" style="text-align: center">
                <button type="submit" class="btn btn-primary">提交</button>&nbsp;
                <a class="btn btn-default" href="${pageContext.request.contextPath}/add.jsp">
                    重置
                </a>&nbsp;
                <a class="btn btn-default" href="${pageContext.request.contextPath}/findUserByPageServlet">
                    返回
                </a>
            </div>
        </form>
    </div>
</div>

</body>
</html>
