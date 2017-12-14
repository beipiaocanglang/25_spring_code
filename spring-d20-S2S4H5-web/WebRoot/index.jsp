<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>主页</title>
	</head>
	<body>
		<!-- 整合web的请求 -->
		<a href="${pageContext.request.contextPath}/servlet/AccountServlt">查询一个用户信息</a>
		<br>
		<!-- 整合struts2的请求 -->
		<a href="${pageContext.request.contextPath}/account/findActionById.action">struts2查询一个用户信息</a>
	</body>
</html>
