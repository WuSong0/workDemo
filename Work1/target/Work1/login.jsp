<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016-12-8 0008
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login2" method="post">
    账号：<input name="name"/><br/>
    密码：<input type="password" name="pwd" /><br/>
    <input type="submit" name="submit" value="登录"/>
</form>

</body>
</html>
