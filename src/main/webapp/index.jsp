<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>UsersApp</title>
</head>
<body>
<h1><%= "UsersApp" %>
</h1>
<br/>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<a href="<%=request.getContextPath()%>/users">List of Users</a>
<a href="<%=request.getContextPath()%>/adduser">Add new user</a>
<a href="<%=request.getContextPath()%>/deleteuser">Delete user</a>
</body>
</html>