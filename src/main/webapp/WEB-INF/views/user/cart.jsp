<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<head>
	<title>Giỏ hàng - Book Store</title>
	<link rel="stylesheet" href="assets/css/cart.css">
</head>

<body>
	<!-- Sublink -->
    <div class="sublink py-4">
        <div class="container">
            <div class="fs-6">
                <h4 class="text-dark fw-bold">Shop</h4>

                <div>
                    <a class="text-decoration-none text-dark" href="/bookstore/home">Home</a>
                    <a class="text-decoration-none text-dark" href="/bookstore/shop">
                    	<i class="fa-solid fa-angle-right px-2"></i>
                    	Shop
                    </a>
                    <span><i class="fa-solid fa-angle-right px-2"></i>Cart</span>
                </div>
            </div>
        </div>
    </div>

	<!-- Shopping cart -->
    <div class="container mt-5 cart">
        <div class="row align-items-center py-4 fs-5 fw-normal cart__header">
            <div class="col-7">
                <div class="row">
                    <div class="col-2 col-lg-1 ps-4 d-flex align-items-center text-center">
                        <input type="checkbox" name="select-all" id="select-all">
                    </div>
    
                    <div class="col-10 p-0">
                        <p class="m-0">Chọn tất cả (<span id="quantity-cart">${ quantityCart }</span> sản phẩm)</p>
                    </div>
                </div>
            </div>

            <div class="d-none d-lg-block col-5">
                <div class="row">
                    <div class="col-6 text-center"><p class="m-0">Số lượng</p></div>
                    <div class="col-4 text-center"><p class="m-0">Thành tiền</p></div>
                </div>
            </div>
        </div>

        <div class="row cart__wrapper">
        
        	<c:forEach var="pair" items="${cartProductPairs}">
        		<c:set var="book" value="${pair.first}"/>  
	    		<c:set var="cartProduct" value="${pair.second}"/>
	    		<c:set var="media" value="${mediaService.getMediaById(book.thumbnailId)}"/>
        	
	            <div class="col-12">
	                <div class="row py-4">
	                    <div class="col-9 col-md-8 col-lg-7">
	                        <div class="row align-items-center">
	                            <div class="col-2 col-lg-1 ps-4 pe-0 d-flex align-items-center text-center">
	                                <input type="checkbox" name="select">
	                            </div>
	            
	                            <div class="col-10 col-lg-11 p-0">
	                                <a class="d-flex product" href="/bookstore/product?id=${ book.id }">
	                                    <div class="product__img">
	                                        <img src="${ media.path }" alt="product-img">
	                                    </div>
	            
	                                    <div class="d-flex flex-column justify-content-between ps-3 px-lg-4 product__info">
	                                        <div>
	                                            <h5 class="text-black">${ book.title }</h5>
	                                            <p class="m-0 d-none d-md-block">
	                                            	Tác giả: 
	                                            	<span class="fw-normal">${ bookService.getBookAuthor(book.authorId) }</span>
	                                            </p>
	                                            <p class="m-0 description">
	                                            	Mô tả: 
	                                            	<span class="fw-normal">${ book.description }</span>
	                                            </p>
	                                        </div>
	
	                                        <span class="pb-2 fs-5 fw-bold text-danger">
	                                        	${ book.getSellPrice() } đ 
	                                        	<del class="fs-6 fw-medium text-secondary">${ book.price } đ</del>
	                                        </span>
	                                    </div>
	                                </a>
	                            </div>
	                        </div>
	                    </div>
	    
	                    <div class="col-md-4 col-lg-5 col-3">
	                        <div class="row h-100 align-items-center">
	                            <div class="col-12 col-md-8 col-lg-6 d-flex justify-content-center">
	                                <div class="quantity">
	                                    <button type="button" class="quantity__sub"><i class="fa-solid fa-minus"></i></button>
	                                    <input disabled class="quantity__input" type="text" id="quantity" name="quantity" min="1" value="${ cartProduct.quantity }">
	                                    <button type="button" class="quantity__add"><i class="fa-solid fa-plus"></i></button>
	                                </div>
	                            </div>
	            
	                            <div class="col-4 d-none d-lg-block text-center">
	                            	<span class="fs-5 fw-bold text-danger">${ cartProduct.quantity * book.getSellPrice() } đ</span>
	                            </div>
	                        
	                            <div class="col-4 col-lg-2 d-none d-md-block text-center">
	                                <button class="delete"><i class="fs-5 fa-solid fa-trash-can"></i></button>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>

			</c:forEach>
        </div>
    </div>
</body>