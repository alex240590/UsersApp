<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 14.04.2021
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Msg to kafka</title>
</head>
<body>
<form name="test" method="post" action="/UsersApp/kafka">
    <p><b>Name:</b><br>
        <input type="text" name="name" size="40">
    </p>

    <p><input type="submit" value="kafka">
        <input type="reset" value="Clear">
        <a href="index.jsp">
            <input type="button" value="Main page" />
        </a>
    </p>
</form>
</body>
</html>
