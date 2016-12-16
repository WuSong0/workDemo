<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016-12-9 0009
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    <h3>${name}</h3>恭喜您，登录成功！！

        <table>
            <tr>
                <td>name</td><td>age</td>
            </tr>
            <c:forEach var="stu" items="${list}" >
            <tr>
                <td>${stu.name}</td><td>${stu.age}</td>
            </tr>
            </c:forEach>
        </table>

</body>
</html>
