<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title><decorator:title></decorator:title></title>
	
	<link rel="shortcut icon" href="assets/img/favi.png" type="image/x-icon">
	<!-- Google Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap">
    <!-- CSS icon from Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <!-- CSS Bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/css/home.css">
</head>

<body>
	<!-- Header navbar -->
    <nav class="header-navbar navbar navbar-expand-md pb-4" arial-label="navigation bar">
        <div class="container pt-2">
            <a class="navbar-brand text-white fs-2 fw-bold" href="">Book Store</a>

            <button class="navbar-toggler text-white" type="button" data-bs-toggle="collapse" data-bs-target="#navbar-main" aria-controls="navbar-main" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbar-main">
                <ul class="custom-nav navbar-nav ms-auto mb-2 mb-md-0">
                    <li class="mx-lg-3 fw-bold nav-item active">
                        <a class="nav-link px-2 text-white" href="">Home</a>
                    </li>
                    <li class="mx-lg-3 fw-bold"><a class="nav-link px-2 text-white" href="">Shop</a></li>
                    <li class="mx-lg-3 fw-bold"><a class="nav-link px-2 text-white" href="">Blog</a></li>
                    <li class="mx-lg-3 fw-bold"><a class="nav-link px-2 text-white" href="">About us</a></li>
                    <li class="mx-lg-3 fw-bold"><a class="nav-link px-2 text-white" href="">Contact us</a></li>
                </ul>

                <ul class="custom-nav-2 navbar-nav mb-2 mb-md-0 ms-lg-5 px-2 px-lg-0 fs-5">
                    <li class="me-4"><a class="nav-link text-white" href=""><i class="fa-solid fa-user"></i></a></li>
                    <li class="">
                        <a class="nav-link text-white position-relative" href="">
                            <i class="fa-solid fa-cart-shopping"></i>
                            <span class="quantity-cart">0</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
	
	<decorator:body></decorator:body>
	
	<!-- Footer -->
    <footer class="footer">
        <div class="container relative">
            <div class="row">
                <div class="col-lg-8">
                    <div class="subscription-form">
                        <h3 class="d-flex align-items-center mb-4">
                            <i class="fa-regular fa-envelope me-2 opacity-50"></i>
                            <span>Nhận tin tức và khuyến mãi</span>
                        </h3>

                        <form action="" class="row g-3">
                            <div class="col-auto">
                                <input type="text" class="form-control" placeholder="Tên của bạn">
                            </div>
                            <div class="col-auto">
                                <input type="email" class="form-control" placeholder="Email nhận thông báo">
                            </div>
                            <div class="col-auto">
                                <button class="btn btn-primary">
                                    <span class="fa fa-paper-plane"></span>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <div class="row my-5">
                <a href="#" class="fs-2 fw-bold footer-logo">Book Store<span>.</span></a>
            </div>

            <div class="row g-5 mb-5">
                <div class="col-lg-4">
                    <p class="fs-6 mb-4">Donec facilisis quam ut purus rutrum lobortis. Donec vitae odio quis nisl dapibus malesuada. Nullam ac aliquet velit. Aliquam vulputate velit imperdiet dolor tempor tristique. Pellentesque habitant</p>

                    <ul class="list-unstyled custom-social">
                        <li class="d-inline-block"><a href="#"><span class="fa-brands fa-facebook-f fs-5"></span></a></li>
                        <li class="d-inline-block"><a href="#"><span class="fa-brands fa-github fs-5"></span></a></li>
                    </ul>
                </div>

                <div class="col-lg-8">
                    <div class="row footer__link">
                        <div class="col-6 col-sm-6 col-md-3">
                            <ul class="list-unstyled">
                                <li><a href="#">About us</a></li>
                                <li><a href="#">Services</a></li>
                                <li><a href="#">Blog</a></li>
                                <li><a href="#">Contact us</a></li>
                            </ul>
                        </div>

                        <div class="col-6 col-sm-6 col-md-3">
                            <ul class="list-unstyled">
                                <li><a href="#">Support</a></li>
                                <li><a href="#">Knowledge base</a></li>
                                <li><a href="#">Live chat</a></li>
                            </ul>
                        </div>

                        <div class="col-6 col-sm-6 col-md-3">
                            <ul class="list-unstyled">
                                <li><a href="#">Jobs</a></li>
                                <li><a href="#">Our team</a></li>
                                <li><a href="#">Leadership</a></li>
                                <li><a href="#">Privacy Policy</a></li>
                            </ul>
                        </div>

                        <div class="col-6 col-sm-6 col-md-3">
                            <ul class="list-unstyled">
                                <li><a href="#">Nordic Chair</a></li>
                                <li><a href="#">Kruzo Aero</a></li>
                                <li><a href="#">Ergonomic Chair</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <div class="border-top copyright">
                <div class="row pt-4 pb-5">
                    <div class="col-lg-8">
                        <p class="mb-2 text-center text-lg-start">
                            Copyright &copy; 2024. All Rights Reserved. &mdash; 
                            Created by <a href="https://github.com/dcthoai/book-shop-template">dcthoai</a> based on the design of 
                            <a href="https://themewagon.github.io/furni">ThemeWagon.</a>
                        </p>
                    </div>

                    <div class="col-lg-4 text-center text-lg-end">
                        <ul class="list-unstyled d-inline-flex ms-auto">
                            <li class="me-4"><a href="#">Terms &amp; Conditions</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                        </ul>
                    </div>

                </div>
            </div>

        </div>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>