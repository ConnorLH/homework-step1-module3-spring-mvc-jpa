<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: connor.h.liu
  Date: 2020/8/10
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页</title>
</head>
<body>
<div>
    <form method="post" action="/login/processLogin">
        <c:if test="${not empty message}">
            <p style="color: red"><c:out value="${message}"/></p>
        </c:if>
        用户名：<input type="text" name="username"><br/>
        密码：<input type="text" name="password"><br/>
        <input type="submit" value="登录"/>
    </form>
</div>
</body>
</html>
