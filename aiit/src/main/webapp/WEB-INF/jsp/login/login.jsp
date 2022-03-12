<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/2/24
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <script src="<%=basePath %>/js/jquery-3.6.0.min.js"></script>
    <title>Title</title>
    <script type="text/javascript">
        function doLogin() {
            $.ajax({
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "/login/doLogin" ,//url
                data: $('#userForm').serialize(),
                success: function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if (result.resultCode == 200) {
                        alert("SUCCESS");
                    }
                    ;
                },
                error : function() {
                    alert("异常！");
                }
            });
        }
    </script>
</head>
<body>
<form action="<%=basePath %>doLogin" method="post" id="userForm">
     登录用户名：<input type="text" name="loginname"><br><br><br>
    登录密码：<input type="text" name="password"><br><br><br>
    <input type="submit" value="提交"  >
</form>
<a href="<%=basePath %>regist">点我跳转注册页面</a>



</body>
</html>
