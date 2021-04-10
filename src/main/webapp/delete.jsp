<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 10.04.2021
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete user</title>
</head>
<body>
<form name="test" method="post" action="/UsersApp/deleteuser">
    <p><b>Name:</b><br>
        <input type="text" name="name" size="40">
    </p>
        <p><input type="submit" value="Delete user">
        <input type="reset" value="Clear">
            <a href="index.jsp">
                <input type="button" value="Main page" />
            </a></p>
</form>
</body>
</html>
