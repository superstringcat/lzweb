<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="regist">
<input value="${stu.id }" type="hidden" name="id">
用户名：<input name="userName" value="${stu.userName }"><br>
学号：<input name="stuNo" value="${stu.num }"><br>
密码：<input name="psd" value="${stu.psd }"><br>
专业：<input name="zy" value="${stu.zy }"><br>
<input type="submit">
</form>
</body>
</html>