<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 
<head>
    <title>练习</title>
</head>
<body>
<form action="http://localhost:8080/MyWebTest/uploadServlet" enctype="multipart/form-data" method="post">
    <input type="text" name="username">
    <input type="password" name="pwd">
    <input type="file" name="pic">
    <input type="submit">
</form>
 
</body>
