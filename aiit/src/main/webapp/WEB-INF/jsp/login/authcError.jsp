<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/3/1
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
当前用户没有登录！！！！<br/>
<a href="${path }/login/loginPage">点击进入系统登录页面</a>
</body>
</html>
