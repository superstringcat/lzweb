<%@page import="com.dao.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div>姓名：<input><input type="submit"></div>
<table class="table" border="1" cellpadding='0' cellspacing='0'>
<tr class="danger">
<td>编号</td>
<td>学号</td>
<td>用户名</td>
<td>密码</td>
<td>专业</td>
<td>操作</td>
</tr>
<c:forEach items="${ params}" var="st">
<tr class="success">
<td>${st.id }</td>
<td>${st.num }</td>
<td>${st.userName }</td>
<td>${st.psd }</td>
<td>${st.zy }</td>
<td>
<a href='DeleteStudentServlet?ids=${st.id }' class="btn btn-danger">删除</a>
<a href='UpdateStudentServlet?ids=${st.id }' class="btn btn-info">修改</a>
</td>
</tr>
</c:forEach>
</table>

</body>
</html>