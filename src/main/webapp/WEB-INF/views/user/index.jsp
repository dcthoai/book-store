<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<title>Trang chủ - Book Store</title>

<body>
	<div class="container">
		<h3>Slide:</h3>
		<c:forEach var="slide" items="${ slides }">
			<h5>id: ${ slide.id }</h5>
			<h5>image: ${ slide.slideMedia }</h5>
			<h5>caption: ${ slide.caption }</h5>
			<h5>content: ${ slide.content }</h5>
		</c:forEach>
		
		<h3>Category:</h3>
		<c:forEach var="category" items="${ categories }">
			<h5>id: ${ category.id }</h5>
			<h5>categoryName: ${ category.categoryName }</h5>
			<h5>description: ${ category.descriptions }</h5>
		</c:forEach>
	</div>
</body>