<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title><decorator:title></decorator:title></title>
	<link href="<c:url value="assets/styles.css"/>" rel="stylesheet">
</head>

<body>
	<header><h1>Trang web cho người dùng thông thường.</h1></header>
	
	<decorator:body></decorator:body>
</body>
</html>