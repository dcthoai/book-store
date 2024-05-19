<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<head>
	<title>Blog - Book Store</title>
 	<link rel="stylesheet" href="assets/css/blog.css">
</head>

<body>
    <div class="banner">
        <img class="w-100" src="assets/images/img-grid-1.jpg" alt="" class="banner__img">
        <h1 class="banner__heading">Our Blogs</h1>
    </div>

    <div class="blogs">
        <div class="container">
            <div class="row">
                <c:forEach var="blog" items="${ blogs }">
                	<div class="col-6 col-md-4">
	                    <div class="blog w-100">
	                        <img class="w-100" style="aspect-ratio: 7/5;" src="${ mediaService.getMediaById(blog.thumbnailId).getPath() }" alt="" class="blog__thumbnail">
	                        <div class="blog__info">
	                            <div class="blog__info-date">
	                                <i class="fa-regular fa-calendar-check me-2"></i>
	                                <span>${ blog.createdDate }</span>
	                            </div>
	    
	                            <h4 class="blog__info-title">${ blog.title }</h4>
	                            
	                            <a href="/bookstore/blog?id=${ blog.id }" class="blog__info-link">Xem thêm</a>
	                        </div>
	                    </div>
	                </div>
                </c:forEach>
            </div>
        </div>
    </div>
</body>