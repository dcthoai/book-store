<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>

<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title><decorator:title></decorator:title></title>
	
	<link rel="shortcut icon" href="./assets/images/favi.png" type="image/x-icon">
    <!-- Google Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap">
    <!-- CSS icon from Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <!-- CSS Bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <!-- CSS custom -->
    <link rel="stylesheet" href="assets/css/styles.css">
    <decorator:head></decorator:head>
</head>

<body>
	<!-- Header -->
    <header class="header navbar navbar-expand-md py-4">
        <div class="container">
            <a href="/bookstore/home" class="fs-3 fw-bold">BookStore.</a>

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#header-navbar" aria-controls="header-navbar" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="header-navbar">
                <ul class="custom-navbar-link navbar-nav ms-auto mt-4 mt-md-0">
                    <li class="mt-3 mt-md-0 me-2 me-lg-4 active"><a class="p-2" href="/bookstore/">Home</a></li>
                    <li class="mt-3 mt-md-0 me-2 me-lg-4"><a class="p-2" href="/bookstore/shop">Shop</a></li>
                    <li class="mt-3 mt-md-0 me-2 me-lg-4"><a class="p-2" href="/bookstore/blog">Blogs</a></li>
                    <li class="mt-3 mt-md-0 me-2 me-lg-4"><a class="p-2" href="/bookstore/about">About us</a></li>
                    <li class="mt-3 mt-md-0 me-2 me-lg-4"><a class="p-2" href="#">Contact us</a></li>
                </ul>

                <ul class="navbar-nav mt-2 mt-md-0 fs-5">
                    <li class="mt-4 mt-md-0 mx-md-2 mx-lg-4">
                        <a class="p-2 position-relative" href="/bookstore/shop/shopping-cart">
                            <i class="fa-solid fa-cart-shopping"></i>
                            <span class="quantity-cart fs-6">0</span>
                        </a>
                    </li>
                    <li class="mt-3 mt-md-0 ms-1">
                        <div id="user-button" class="p-2 text-light d-inline"><i class="fa-solid fa-user"></i></div>
                    </li>
                </ul>
            </div>
        </div>
    </header>

    <div class="header-margin"></div>
    <div class="popup" id="popup"></div>
	
	<decorator:body></decorator:body>
	
	<!-- Footer -->
    <footer class="footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <h3 class="mb-4 fs-4 opacity-75">
                        <i class="fa-regular fa-envelope me-2 opacity-50"></i>
                        <span class="fw-semibold">Đăng ký nhận tin tức và khuyến mãi</span>
                    </h3>

                    <form action="" class="row">
                        <div class="col-12 col-sm-8 col-md-5 mb-3 mb-md-0"><input class="w-100 w-sm-75 w-md-auto" type="text" name="name" id="" placeholder="Nhập tên"></div>
                        <div class="col-12 col-sm-8 col-md-5 mb-3 mb-md-0"><input class="w-100 w-sm-75 w-md-auto" type="email" name="email" id="" placeholder="Nhập email"></div>
                        <div class="col-12 col-sm-8 col-md-auto">
                            <button class="w-100 w-md-auto" type="button">
                                <span class="fa fa-paper-plane"></span>
                            </button>
                        </div>
                    </form>
                </div>
            </div>

            <div class="row pt-5 pb-2">
                <a href="index.html" class="footer__logo fs-2 fw-bold">BookStore.</a>
            </div>

            <div class="row">
                <div class="col-lg-6">
                    <p class="fs-6 fw-medium lh-lg" style="text-align: justify;">
                        Cảm ơn bạn đã ghé thăm cửa hàng của chúng tôi! 
                    	Chúng tôi hy vọng bạn đã tìm thấy những cuốn sách mà bạn đang tìm kiếm. 
                    	Đừng ngần ngại liên hệ với chúng tôi nếu bạn có bất kỳ câu hỏi nào hoặc cần hỗ trợ. 
                    	Chúng tôi luôn sẵn lòng giúp đỡ. Chúc bạn có những trải nghiệm đọc sách thú vị và bổ ích!
                    </p>
                    
                    <ul class="footer__social-link my-5">
                        <li class="d-inline-block">
                            <a href=""><span class="fa-brands fa-facebook-f fs-5"></span></a>
                        </li>
                        <li class="d-inline-block ms-2">
                            <a href=""><span class="fa-brands fa-github fs-5"></span></a>
                        </li>
                    </ul>
                </div>

                <div class="col-lg-6">
                    <div class="row">
                        <div class="col-0 col-lg-4"></div>

                        <div class="col-6 col-md-4">
                            <ul class="lh-lg">
                                <li><a href="">Về chúng tôi</a></li>
                                <li><a href="">Dịch vụ</a></li>
                                <li><a href="">Blog</a></li>
                                <li><a href="">Liên hệ</a></li>
                            </ul>
                        </div>

                        <div class="col-6 col-md-4">
                            <ul class="lh-lg">
                                <li><a href="">Hỗ trợ</a></li>
                                <li><a href="">Live chat</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row py-5 pt-lg-0">
                <div class="col-lg-6 col-xl-8">
                    <p class="mb-2 text-start">
                        Copyright &copy; 2024. All Rights Reserved &mdash; 
                        Created by <a href="https://github.com/dcthoai/book-shop-template">dcthoai</a>
                        based on the design of <a href="https://themewagon.github.io/furni">ThemeWagon.</a>
                    </p>
                </div>

                <div class="col-lg-6 col-xl-4 pt-4 pt-lg-0 text-center text-lg-end">
                    <ul class="d-inline-flex ms-auto flex-wrap">
                        <li class="me-4"><a href="">Điều khoản &amp; Điều kiện</a></li>
                        <li><a href="">Chính sách bảo mật</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="assets/js/main.js"></script>
</body>
</html>