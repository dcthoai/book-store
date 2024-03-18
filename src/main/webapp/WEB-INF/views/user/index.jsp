<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<title>Trang chủ - Book Store</title>

<body>

    <!-- Slider -->
    <div id="carouselExample" class="carousel slide slide-custom pb-5">
        <div class="container">
            <div class="carousel-inner">
                <div class="carousel-item py-5 active">
                    <div class="row justify-content-between">
                        <div class="col-sm-12 col-lg-5 d-flex align-items-center">
                            <div class="py-4 title">
                                <h1 class="mb-4 fw-bold fs-1 text-light">Khám phá khoa học</h1>
                                <p class="mb-4 opacity-50 fs-6 text-light">
                                	Kích thích sự tò mò và khám phá với cuốn sách khoa học đầy màu sắc,
                                	mang đến những hiểu biết mới mẻ và hấp dẫn cho các trẻ nhỏ!
                                </p>
                                <a href="" class="btn rounded-5 px-4 py-2 fs-5 fw-medium text-light explore">Xem ngay</a>
                            </div>
                        </div>
                        <div class="col-sm-12 col-lg-7">
                            <div class="slides__banner text-center">
                                <img src="./assets/img/science.png">
                            </div>
                        </div>
                    </div>
                </div>
    
                <div class="carousel-item py-5">
                    <div class="row justify-content-between">
                        <div class="col-sm-12 col-lg-5 d-flex align-items-center">
                            <div class="py-4 title">
                                <h1 class="mb-4 fw-bold fs-1 text-light">Truyện tranh hấp dẫn</h1>
                                <p class="mb-4 opacity-50 fs-6 text-light">
                                	Nhập vai vào thế giới phiêu lưu đầy màu sắc và hài hước với những trang truyện tranh tuyệt vời! 
                                	Khám phá những câu chuyện đầy phép thuật và nhân vật đầy cá tính, 
                                	sẵn sàng chờ đợi bạn trong những trang sách tranh tuyệt vời!
                                </p>
                                <a href="" class="btn rounded-5 px-4 py-2 fs-5 fw-medium text-light explore">Xem ngay</a>
                            </div>
                        </div>
                        <div class="col-sm-12 col-lg-7">
                            <div class="slides__banner text-center">
                                <img src="./assets/img/comic.png">
                            </div>
                        </div>
                    </div>
                </div>
    
                <div class="carousel-item py-5">
                    <div class="row justify-content-between">
                        <div class="col-sm-12 col-lg-5 d-flex align-items-center">
                            <div class="py-4 title">
                                <h1 class="mb-4 fw-bold fs-1 text-light">Cùng nhau vào bếp</h1>
                                <p class="mb-4 opacity-50 fs-6 text-light">
                                	Khám phá hương vị thế giới và học cách trở thành đầu bếp tài ba với những công thức đơn giản
                                	và ngon miệng từ cuốn sách nấu ăn độc đáo này! 
                                	Từ món ăn truyền thống đến những món mới lạ, tất cả đều sẽ được tiết lộ bí mật trong từng trang sách, 
                                	mang lại cho bạn trải nghiệm ẩm thực tuyệt vời nhất.
                                </p>
                                <a href="" class="btn rounded-5 px-4 py-2 fs-5 fw-medium text-light explore">Xem ngay</a>
                            </div>
                        </div>
                        <div class="col-sm-12 col-lg-7">
                            <div class="slides__banner text-center">
                                <img src="./assets/img/cooking.png">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <button class="carousel-control-prev d-none d-lg-block" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            </button>
            
            <button class="carousel-control-next d-none d-lg-block" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
            </button>
        </div>
    </div>

    <!-- Why choose us -->
    <div class="container why-choose-us">
        <div class="row justify-content-between">
            <div class="col-lg-6">
                <h2 class="text-dark">Tại sao chọn chúng tôi?</h2>
                <p>Donec vitae odio quis nisl dapibus malesuada. Nullam ac aliquet velit. Aliquam vulputate velit imperdiet dolor tempor tristique.</p>

                <div class="row my-5">
                    <div class="col-6 col-md-6 feature">
                        <div class="feature__icon">
                            <img src="./assets/img/truck.svg" alt="Image">
                        </div>
                        
                        <h3 class="fs-5 text-dark">Nhanh &amp; Miễn phí vận chuyển</h3>
                        <p>Donec vitae odio quis nisl dapibus malesuada. Nullam ac aliquet velit. Aliquam vulputate.</p>
                    </div>

                    <div class="col-6 col-md-6 feature">
                        <div class="feature__icon">
                            <img src="./assets/img/bag.svg" alt="Image">
                        </div>

                        <h3 class="fs-5 text-dark">Mua hàng nhanh chóng</h3>
                        <p>Donec vitae odio quis nisl dapibus malesuada. Nullam ac aliquet velit. Aliquam vulputate.</p>
                    </div>

                    <div class="col-6 col-md-6 feature">
                        <div class="feature__icon">
                            <img src="./assets/img/support.svg" alt="Image">
                        </div>

                        <h3 class="fs-5 text-dark">Hỗ trợ 24/7</h3>
                        <p>Donec vitae odio quis nisl dapibus malesuada. Nullam ac aliquet velit. Aliquam vulputate.</p>
                    </div>

                    <div class="col-6 col-md-6 feature">
                        <div class="feature__icon">
                            <img src="./assets/img/return.svg" alt="Image">
                        </div>
      
                        <h3 class="fs-5 text-dark">Hoàn trả miễn phí, dễ dàng</h3>
                        <p>Donec vitae odio quis nisl dapibus malesuada. Nullam ac aliquet velit. Aliquam vulputate.</p>
                    </div>

                </div>
            </div>

            <div class="col-lg-5 mt-5 mt-lg-0">
                <div class="pb-5 img-wrap">
                    <img class="w-100 h-auto rounded-4" src="./assets/img/why-choose-us-img.jpg" alt="Image">
                </div>
            </div>
        </div>
    </div>

    <!-- Season trending -->
    <div class="season-trending">
        <div class="container">
            <div class="row justify-content-between">
                <div class="col-lg-7 mb-5 mb-lg-0">
                    <div class="row align-items-start img-wrapper">
                        <div class="col-8"><img class="img-1 rounded-4" src="./assets/img/img-grid-1.jpg" alt="trending-img"></div>
                        <div class="col-4 position-relative">
                            <img class="img-2 rounded-4" src="./assets/img/img-grid-2.jpg" alt="trending-img">
                            <img class="img-3 rounded-4" src="./assets/img/img-grid-3.jpg" alt="trending-img">
                        </div>
                    </div>
                </div>

                <div class="col-lg-5 pt-5 pt-lg-0 ps-lg-5 mt-5 mt-lg-0">
                    <h2 class="mb-4 fs-1 text-dark">Xu hướng sách mùa này</h2>
                    <p>Donec facilisis quam ut purus rutrum lobortis. Donec vitae odio quis nisl dapibus malesuada. Nullam ac aliquet velit. Aliquam vulputate velit imperdiet dolor tempor tristique. Pellentesque habitant morbi tristique senectus et netus et malesuada</p>

                    <ul class="list-unstyled my-4">
                        <li>Donec vitae odio quis nisl dapibus malesuada</li>
                        <li>Donec vitae odio quis nisl dapibus malesuada</li>
                        <li>Donec vitae odio quis nisl dapibus malesuada</li>
                        <li>Donec vitae odio quis nisl dapibus malesuada</li>
                    </ul>

                    <a herf="" class="btn btn-dark mt-4 px-4 py-2 fs-5 fw-medium rounded-5">Xem ngay</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Recent blog -->
    <div class="blog">
        <div class="container">
            <div class="row mb-5">
                <div class="col-md-6">
                    <h2 class="fs-1 text-dark">Blog mới</h2>
                </div>
                <div class="col-md-6 pt-4 text-start text-md-end">
                    <a href="#" class="fs-6 text-decoration-none text-dark">Xem tất cả</a>
                </div>
            </div>

            <div class="row">

                <div class="col-12 col-sm-6 col-md-4 mb-4 mb-md-0">
                    <div class="post-entry">
                        <a href="#" class="post-thumbnail"><img src="./assets/img/post-1.jpg" alt="Image" class="img-fluid rounded-4"></a>
                        <div class="mt-4">
                            <h3><a class="text-decoration-none text-dark fs-4" href="#">First Time Home Owner Ideas</a></h3>
                            <div class="meta">
                                <span>by <a href="#">Kristin Watson</a></span> <span>on <a href="#">Dec 19, 2021</a></span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-12 col-sm-6 col-md-4 mb-4 mb-md-0">
                    <div class="post-entry">
                        <a href="#" class="post-thumbnail"><img src="./assets/img/post-2.jpg" alt="Image" class="img-fluid rounded-4"></a>
                        <div class="mt-4">
                            <h3><a class="text-decoration-none text-dark fs-4" href="#">How To Keep Your Furniture Clean</a></h3>
                            <div class="meta">
                                <span>by <a href="#">Robert Fox</a></span> <span>on <a href="#">Dec 15, 2021</a></span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-12 col-sm-6 col-md-4 mb-4 mb-md-0">
                    <div class="post-entry">
                        <a href="#" class="post-thumbnail"><img src="./assets/img/post-3.jpg" alt="Image" class="img-fluid rounded-4"></a>
                        <div class="mt-4">
                            <h3><a class="text-decoration-none text-dark fs-4" href="#">Small Space Furniture Apartment Ideas</a></h3>
                            <div class="meta">
                                <span>by <a href="#">Kristin Watson</a></span> <span>on <a href="#">Dec 12, 2021</a></span>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

    
</body>