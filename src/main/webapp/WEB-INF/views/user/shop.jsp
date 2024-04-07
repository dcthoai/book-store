<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<head>
	<title>Mua sắm - Book Store</title>
	<link rel="stylesheet" href="assets/css/shop.css">
</head>

<body>
    <!-- Sublink -->
    <div class="sublink py-4">
        <div class="container">
            <div class="fs-6">
                <h4 class="text-dark fw-bold">Shop</h4>

                <div>
                    <a class="text-decoration-none text-dark" href="/">Home</a>
                    <span><i class="fa-solid fa-angle-right px-2"></i>Shop</span>
                </div>
            </div>
        </div>
    </div>

    <!-- Shop -->
    <div class="shop">
        <div class="container pt-5">
            <div class="row">
                <div class="col-lg-3 pe-5">
                    <div class="row">
                        <form action="" class="form-search">
                            <input type="text" placeholder="Tìm tên sách hoặc tác giả">
                            <button type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                        </form>
                    </div>

                    <div class="nav-filter py-4">
                        <div class="filter mt-2">
                            <div class="py-2 d-flex justify-content-between align-items-center">
                                <h4 class="mb-0 fs-5">Thể loại</h4>

                                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#nav-category" aria-controls="nav-category" aria-expanded="false" aria-label="Toggle navigation">
                                    <span class="fa-solid fa-angle-down"></span>
                                </button>
                            </div>

                            <div class="filter__body collapse navbar-collapse" id="nav-category">
                                <ul class="mt-2 mb-4 lh-lg">
                                    <li><a href="#">Tất cả</a></li>
                                    <li><a href="#">Truyện tranh</a></li>
                                    <li><a href="#">Truyện ngôn tình</a></li>
                                    <li><a href="#">Tiểu thuyết</a></li>
                                    <li><a href="#">Khoa học</a></li>
                                    <li><a href="#">Tự truyện</a></li>
                                    <li><a href="#">Tiểu sử, hồi ký</a></li>
                                    <li><a href="#">Lịch sử</a></li>
                                    <li><a href="#">Tạp chí thể thao</a></li>
                                    <li><a href="#">Tạp chí thời trang</a></li>
                                    <li><a href="#">Sách dạy nấu ăn</a></li>
                                    <li><a href="#">Sách giáo khoa</a></li>
                                </ul>
                            </div>
                        </div>

                        <div class="filter mt-2">
                            <div class="py-2 d-flex justify-content-between align-items-center">
                                <h4 class="mb-0 fs-5">Ngôn ngữ</h4>

                                <button class="" type="button" data-bs-toggle="collapse" data-bs-target="#nav-language" aria-controls="nav-language" aria-expanded="false" aria-label="Toggle navigation">
                                    <span class="fa-solid fa-angle-down"></span>
                                </button>
                            </div>

                            <div class="filter__body collapse navbar-collapse" id="nav-language">
                                <ul class="mt-2 mb-4 lh-lg">
                                    <li><a href="#">Tất cả</a></li>
                                    <li><a href="#">Tiếng Việt</a></li>
                                    <li><a href="#">Tiếng Anh</a></li>
                                    <li><a href="#">Tiếng Pháp</a></li>
                                    <li><a href="#">Tiếng Đức</a></li>
                                    <li><a href="#">Tiếng Trung</a></li>
                                    <li><a href="#">Tiếng Hàn</a></li>
                                    <li><a href="#">Tiếng Nhật</a></li>
                                    <li><a href="#">Tiếng Nga</a></li>
                                </ul>
                            </div>
                        </div>

                        <div class="filter mt-2">
                            <div class="py-2 d-flex justify-content-between align-items-center">
                                <h4 class="mb-0 fs-5">Khoảng giá</h4>

                                <button class="" type="button" data-bs-toggle="collapse" data-bs-target="#nav-price" aria-controls="nav-price" aria-expanded="false" aria-label="Toggle navigation">
                                    <span class="fa-solid fa-angle-down"></span>
                                </button>
                            </div>

                            <div class="filter__body collapse navbar-collapse" id="nav-price">
                                <div class="d-flex justify-content-between align-items-center my-4">
                                    <input class="me-2 h-75" type="number" placeholder="0đ">
                                    <span>-</span>
                                    <input class="ms-2 h-75" type="number" placeholder="100.000đ">
                                </div>
                            </div>
                        </div>

                        <div class="filter mt-2">
                            <div class="py-2 d-flex justify-content-between align-items-center">
                                <h4 class="mb-0 fs-5">Đánh giá</h4>

                                <button class="" type="button" data-bs-toggle="collapse" data-bs-target="#nav-rating" aria-controls="nav-rating" aria-expanded="false" aria-label="Toggle navigation">
                                    <span class="fa-solid fa-angle-down"></span>
                                </button>
                            </div>

                            <div class="filter__body collapse navbar-collapse" id="nav-rating">
                                <ul class="mt-2 mb-4 lh-lg">
                                    <li><a href="#">Tất cả</a></li>
                                    <li><a href="#">Trên 5 sao</a></li>
                                    <li><a href="#">Trên 4 sao</a></li>
                                    <li><a href="#">Trên 3 sao</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-lg-9">
                    <div class="row">
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <p class="mb-0">Đang xem 1-12 trong 126 kết quả</p>
                        </div>

                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="d-flex justify-content-end">
                                <p class="mb-0 me-2">Sắp xếp theo:</p>

                                <select class="sortby">
                                    <option value="">Không sắp xếp</option>
                                    <option value="">Giá tăng dần</option>
                                    <option value="">Giá giảm dần</option>
                                    <option value="">Tên a-z</option>
                                    <option value="">Tên z-a</option>
                                    <option value="">Ngày ra mắt</option>
                                    <option value="">Lượt mua</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="row mt-5">
                        <c:forEach var="book" items="${ newestBooks }">
                        
                        	<div class="col-lg-3 col-md-4 col-6 mb-4">
	                            <div class="product">
	                                <a href="/bookstore/product?id=${ book.id }" class="product__link">
	                                	<c:set var="media" value="${mediaService.getMediaById(book.thumbnailId)}"/>
	                                    <div class="product__img"><img src="${ media.path }" alt="product image"></div>
	
	                                    <div class="product__info p-3 pt-2">
	                                        <h6 class="name mb-2">${ book.title }</h6>
	
	                                        <div class="rating mb-2">
	                                            <i class="fa-regular fa-star"></i>
	                                            <i class="fa-regular fa-star"></i>
	                                            <i class="fa-regular fa-star"></i>
	                                            <i class="fa-regular fa-star"></i>
	                                            <i class="fa-regular fa-star"></i>
	                                        </div>
	                                        
	                                        <div>Đã bán: <span>${ book.purchases }</span></div>
	
	                                        <div class="price">
	                                            ${ book.getSellPrice() } đ
	                                            <span class="discount">-${ book.discount }%</span>
	                                        </div>
	
	                                        <del class="cost">${ book.price }đ</del>
	                                    </div>
	                                </a>
	                            </div>
	                        </div>
	                        
                        </c:forEach>
                    </div>

                    <div class="row mt-5 text-center">
                        <div class="col-lg-12">
                            <div class="product__pagination">
                                <a class="mx-2 active" href="#">1</a>
                                <a class="mx-2" href="#">2</a>
                                <a class="mx-2" href="#">3</a>
                                <span>...</span>
                                <a class="mx-2" href="#">21</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>