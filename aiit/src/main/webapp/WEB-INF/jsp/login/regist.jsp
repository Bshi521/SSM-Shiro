<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/3/2
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>注册用户</title>
</head>
<body>
<form action="<%=basePath %>doRegist" method="POST" id="userForm">
  注册用户名：<input type="text" name="loginname"><br><br><br>
    注册密码：<input type="text" name="password"><br><br><br>
  <input type="submit" value="提交"  >
</form>
<div>${msg}</div>
</body>
</html>
