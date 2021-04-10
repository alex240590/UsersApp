<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 07.04.2021
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
<form name="test" method="post" action="/UsersApp/adduser">
    <p><b>Name:</b><br>
        <input type="text" name="name" size="40">
    </p>
    <p><b>Job:</b><br>
        <input type="text" name="job" size="40">
    </p>
    <p><b>Age:</b><br>
        <input type="text" name="age" size="40">
    </p>

    <p><input type="submit" value="Add user">
        <input type="reset" value="Clear">
        <a href="index.jsp">
            <input type="button" value="Main page" />
        </a>
    </p>
</form>
</body>
</html>
