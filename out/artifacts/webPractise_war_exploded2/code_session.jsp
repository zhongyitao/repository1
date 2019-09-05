<%--
  Created by IntelliJ IDEA.
  User: 逐梦
  Date: 2019/7/20
  Time: 6:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session</title>
</head>


<style>

    *{
        margin: 0px;
        padding: 0px;
        box-sizing: border-box;
    }

    body{
        background: url("images/register_bg.png") no-repeat center;
        padding-top: 25px;
    }

    .rg_layout{
        background: white;
        width: 900px;
        height: 500px;
        margin: auto;
        border: 5px solid #eeeeee;
        /*margin-top: 50px;*/

    }

    .rg_left > p:first-child{
        font-size: 20px;
        color: #FFD026;
    }
    .rg_left > p:last-child{
        font-size: 20px;
        color: #A6A6A6;
    }

    .rg_left{
        float: left;
        /*border: 3px solid red;*/
        margin: 15px;
    }

    .rg_center{
        float: left;


    }


    .rg_right > p{
        font-size: 15px;
    }

    .rg_right p a{
        color: hotpink;

    }
    .rg_right{
        float: right;

        margin: 15px;
    }

    .td_left{
        width: 100px;
        height: 45px;
        text-align: right;
    }

    .td_right{
        padding-left: 50px;

    }

    #username,#password,#name,#email,#birthday,#tel,#checkcode{
        padding-left: 10px;
        border: #A6A6A6 solid 1px;
        height: 32px;
        width: 251px;
        border-radius: 5px;



    }

    #checkcode{
        width: 110px;
    }

    #img_check{
        height: 32px;
        width: 100px;
        vertical-align: middle;
    }


    #btn_submit{
        border: #FFD026 solid 1px;
        background: #FFD026;
        width: 100px;
        height: 40px;
    }

    .error{
        color: red;
        vertical-align: middle;
    }

    #td_sub{
        padding-left: 150px;
    }




</style>

<body>

<div class="rg_layout">
    <div class="rg_left">
        <p>新用户注册</p>
        <p>USER REGISTER</p>
    </div>

    <div class="rg_center">
        <div class="form">
            <form id="form" action="/loginServlet1" method="post">

                <table>
                    <tr>
                        <td class="td_left"><label for="username">用户名</label></td>
                        <td class="td_right">
                            <input type="text" name="username" id="username" placeholder="请输入用户名">
                            <span id="s_username" class="error"></span>
                        </td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="password">密码</label></td>
                        <td class="td_right">
                            <input type="password" name="password" id="password" placeholder="请输入密码">
                            <span id="s_password" class="error"></span>
                        </td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="email">Email</label></td>
                        <td class="td_right"><input type="email" name="email" id="email" placeholder="请输入email"></td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="name">姓名</label></td>
                        <td class="td_right"><input type="text" name="username" id="name" placeholder="请输入姓名"></td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="tel">手机号</label></td>
                        <td class="td_right"><input type="text" name="name" id="tel" placeholder="请输入手机号"></td>
                    </tr>

                    <tr>
                        <td class="td_left"><label>性别</label></td>
                        <td class="td_right">
                            <input type="radio" name="sex" value="male" checked>男
                            <input type="radio" name="sex" value="female">女
                        </td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="birthday">出生日期</label></td>
                        <td class="td_right"><input type="date" name="birthday" id="birthday" placeholder="请输入出生日期"></td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="checkcode">验证码</label></td>
                        <td class="td_right">
                            <input type="text" name="checkcode" id="checkcode" placeholder="请输入验证码">
                            <img id="img_check" src="/checkCodeServlet1">
                        </td>
                    </tr>

                    <tr>
                        <td id="td_sub" colspan="2"><input id="btn_submit" type="submit" value="注册"></td>
                    </tr>


                </table>
            </form>
            <div>
                <span class="error">
                    <%=
                        null == request.getAttribute("error") ? "" : request.getAttribute("error")
                    %>
                </span>
            </div>
        </div>
    </div>

    <div class="rg_right">
        <P>已有账号？&nbsp;<a href="#">立即登录</a></P>
    </div>
</div>


<script>
    window.onload = function(){
        document.getElementById("form").onsubmit = function () {
            var flag1 = checkUsername();
            var flag2 = checkPassword();
            return flag1 && flag2;
        }
        document.getElementById("username").onblur = checkUsername;
        document.getElementById("password").onblur = checkPassword;
        var image_check = document.getElementById("img_check");

        image_check.onclick = function () {

            var date = new Date().getTime();
            image_check.setAttribute("src","/checkCodeServlet1?lastTime=" + date)
        }

    }

    function checkUsername(){
        var userName = document.getElementById("username").value;
        var reg_username = /^\w{6,12}$/;
        var flag = reg_username.test(userName);
        //alert(flag);
        var s_username = document.getElementById("s_username");
        if (flag)
        {
            s_username.innerHTML = "<img width='25px' height='32px' src='images/gou.png'>";
        }
        else{
            s_username.innerHTML = "用户名格式错误";
        }
        return flag;
    }

    function checkPassword(){
        var password = document.getElementById("password").value;
        var reg_password = /^\w{6,12}$/;
        var flag = reg_password.test(password);
        //alert(flag);
        var s_password = document.getElementById("s_password");
        if (flag)
        {
            s_password.innerHTML = "<img src='images/gou.png'>";
        }
        else{
            s_password.innerHTML = "密码格式错误";
        }
        return flag;
    }



</script>

</body>
</html>