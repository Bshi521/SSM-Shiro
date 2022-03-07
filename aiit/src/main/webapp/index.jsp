<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>首页</title>
    <style type="text/css">
        a {
            text-decoration: none;
            color: black;
            font-size: 18px;
        }

        h3 {
            width: 180px;
            height: 38px;
            margin: 100px auto;
            text-align: center;
            line-height: 38px;
            background: deepskyblue;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    基于SSM框架的管理系统：简单实现增、删、改、查。
                </h1>
            </div>
        </div>
    </div>
</div>
<br><br>
<h3>
    　<shiro:hasRole name="admin">

    　　　　用户[<shiro:principal/>]拥有角色admin<br/>

    　　</shiro:hasRole>
    　　<shiro:hasPermission name="user:create">

    　　　　用户[<shiro:principal/>]拥有权限user:create<br/>

    　　</shiro:hasPermission>
    <shiro:guest>
        游客访问 <a href = "login.jsp"></a>
    </shiro:guest>

    user 标签：用户已经通过认证\记住我 登录后显示响应的内容
    <shiro:user>
        欢迎[<shiro:principal/>]登录 <a href = "logout">退出</a>
    </shiro:user>

    authenticated标签：用户身份验证通过，即 Subjec.login 登录成功 不是记住我登录的
    <shiro:authenticated>
        用户[<shiro:principal/>] 已身份验证通过
    </shiro:authenticated>

    notAuthenticated标签：用户未进行身份验证，即没有调用Subject.login进行登录,包括"记住我"也属于未进行身份验证
    <shiro:notAuthenticated>
        未身份验证(包括"记住我")
    </shiro:notAuthenticated>


    principal 标签：显示用户身份信息，默认调用
    Subjec.getPrincipal()获取，即Primary Principal
    <shiro:principal property = "username"/>

    hasRole标签：如果当前Subject有角色将显示body体内的内容
    <shiro:hasRole name = "teacher">
        <a  href="/login/doLogin">教学资源</a>
    </shiro:hasRole>

    hasAnyRoles标签：如果Subject有任意一个角色(或的关系)将显示body体里的内容
    <shiro:hasAnyRoles name = "admin,user">
        用户[<shiro:principal/>]拥有角色admin 或者 user
    </shiro:hasAnyRoles>

    lacksRole:如果当前 Subjec没有角色将显示body体内的内容
    <shiro:lacksRole name = "admin">
        用户[<shiro:principal/>]没有角色admin
    </shiro:lacksRole>

    hashPermission:如果当前Subject有权限将显示body体内容
    <shiro:hasPermission name = "teacher:query">
        <a  href="/login/doLogin">教学资源</a>
    </shiro:hasPermission>

    lacksPermission:如果当前Subject没有权限将显示body体内容
    <shiro:lacksPermission name = "org:create">
        用户[<shiro:principal/>] 没有权限org:create
    </shiro:lacksPermission>
    <a href="${path }/paper/allPaper">点击进入管理页面</a>
</h3>
</body>
</html>
