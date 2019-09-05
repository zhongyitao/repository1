<%--
  Created by IntelliJ IDEA.
  User: 逐梦
  Date: 2019/7/20
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息表</title>

    <!-- Bootstrap -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="./js/jquery-2.1.0.min.js"></script>

    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="./js/bootstrap.min.js"></script>

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->

    <style>
        td,th{
            text-align: center;
            vertical-align: middle;
        }

    </style>
</head>
<body>
    <div class="container">
        <div><h3 style="text-align: center;margin-bottom: 15px">用户信息列表</h3></div>

        <div style="margin-bottom: 15px;float: left">
            <form class="form-inline" action="${pageContext.request.contextPath}/findUserByPageServlet" method="post">
                <div class="form-group">
                    <label for="name">姓名</label>
                    <input type="text" class="form-control" id="name" name="name" value="${parameterMap.name[0]}">
                </div>&nbsp;
                <div class="form-group">
                    <label for="address">籍贯</label>
                    <input type="text" class="form-control" id="address" name="address" value="${parameterMap.address[0]}">
                </div>&nbsp;
                <div class="form-group">
                    <label for="email">邮箱</label>
                    <input type="email" class="form-control" id="email" name="email" value="${parameterMap.email[0]}">
                </div>&nbsp;
                <button type="submit" class="btn btn-default">查询</button>
            </form>
        </div>

        <div style="margin-bottom: 15px;float: right">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加用户</a>
            <a id="deleteSelected" class="btn btn-primary" href="javascript:void(0);">删除选中</a>
        </div>
        <form id="selectedUser" action="${pageContext.request.contextPath}/deleteSelectedServlet" method="post">
            <table class="table table-hover table-bordered table-responsive">
                <tr class="success">
                    <th>
                        <input type="checkbox" id="selectAll">
                    </th>
                    <th>编号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>籍贯</th>
                    <th>QQ</th>
                    <th>邮箱</th>
                    <th>操作</th>
                </tr>

                <c:forEach items="${requestScope.pageBean.userList}" var="user" varStatus="s">
                    <tr class="text-center">
                        <td>
                            <input type="checkbox" name="userId" value="${user.id}">
                        </td>
                        <td>${s.count}</td>
                        <td>${user.name}</td>
                        <td>${user.gender}</td>
                        <td>${user.age}</td>
                        <td>${user.address}</td>
                        <td>${user.qq}</td>
                        <td>${user.email}</td>
                        <td>
                            <a class="btn btn-default btn-sm"
                               href="${pageContext.request.contextPath}/findUserByIdServlet?id=${user.id}">
                                修改
                            </a>&nbsp;
                            <a class="btn btn-default btn-sm"
                               href="${pageContext.request.contextPath}/deleteServlet?id=${user.id}">
                                删除
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                <%--<tr>
                    <td colspan="8">
                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加用户</a>
                    </td>
                </tr>--%>
            </table>
        </form>
        <div>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <c:if test="${pageBean.currentPage == 1}">
                        <li class="disabled">
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${pageBean.currentPage != 1}">
                        <li>
                            <a href="javascript:page(${pageBean.currentPage - 1});" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <c:forEach var="i" begin="1" end="${pageBean.totalPage}" step="1">
                        <c:if test="${pageBean.currentPage == i}">
                            <li class="active">
                        </c:if>
                        <c:if test="${pageBean.currentPage != i}">
                            <li>
                        </c:if>

                            <a href="javascript:void(0);" onclick="page(${i})">
                                ${i}
                            </a>
                        </li>
                    </c:forEach>
                    <c:if test="${pageBean.currentPage != pageBean.totalPage}">
                        <li>
                            <a href="javascript:void(0);" onclick="page(${pageBean.currentPage + 1})" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <c:if test="${pageBean.currentPage == pageBean.totalPage}">
                        <li class="disabled">
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>

                </ul>
            </nav>
        </div>

    </div>

<script>
    $(function () {

        $("#deleteSelected").onclick = function ()
        {
            if(confirm("您确定要删除选中条目吗？")) {
                var cbs = document.getElementsByName("userId");
                var flag = false;
                for (var i = 0; i < cbs.length; i++) {
                    if (cbs[i].checked) {
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    $("#selectedUser").submit();
                }
            }
        }


        if (${not empty flag})
        {
            if(${empty flag ? false : flag})
            {
                alert("操作成功");
                <%
                    request.getSession().removeAttribute("flag");
                %>
            }
            else
            {
                alert("操作失败");
                <%
                    request.getSession().removeAttribute("flag");
                %>
            }
        }

        $("#selectAll").onclick = function () {

            var cbs = document.getElementsByName("userId");
            for (var i = 0; i < cbs.length; i++)
            {
                cbs[i].checked = this.checked;
            }
        }
    });


    function page(i){

        window.location="${pageContext.request.contextPath}/findUserByPageServlet?currentPage="+ i +"&rows=5"

    }


</script>

</body>
</html>
