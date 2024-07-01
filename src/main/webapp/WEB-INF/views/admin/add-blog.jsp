<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ include file="/common/taglib.jsp" %>

<head>
	<title>Thêm bài viết mới | Admin</title>
	<link rel="stylesheet" href="${BASE_URL}/static/admin/assets/css/add-book.css">
</head>

<body>
	<h4 class="p-3 ps-lg-0 fs-4 text-light fw-semibold">Quản lý blog</h4>

     <div class="form-add-book mt-4 px-3 px-lg-4 pb-5 rounded">
         <h5 class="mb-4 pt-4 text-center text-md-start">Thêm một bài viết mới</h5>

         <div class="row mt-5 mb-3">
             <div class="col-12">
                 <label for="thumbnail" class="form-label mb-4 fs-6 fw-medium opacity-75">Ảnh thumbnail</label>
                 <br>
                 <!-- <div class="img-wrapper">
                     <img class="rounded img-fluid" src="/bookstore/admin/assets/images/hail-mary.jpg" alt="thumbnail" id="thumbnail-img">
                 </div> -->
             </div>

             <div class="col-12 col-lg-8 col-xxl-6">
                 <input type="file" class="form-control mt-4" id="thumbnail" name="thumbnail">
             </div>
         </div>

         <div class="row mt-5">
             <div class="col-12 col-lg-8 col-xxl-6 mb-3">
                 <label for="title" class="form-label fs-6 fw-medium opacity-75">Tiêu đề</label>
                 <input type="text" class="form-control" id="title" name="title">
             </div>
         </div>

         <div class="row mt-3">
             <div class="col-12 col-lg-8 col-xxl-6 mb-3">
                 <label for="description" class="form-label fs-6 fw-medium opacity-75">Nội dung</label>
                 <textarea class="form-control" id="description" name="description" rows="6"></textarea>
             </div>
         </div>

         <div class="row justify-content-center justify-content-md-start">
             <div class="col-auto">
                 <button type="button" id="upload-slide" class="btn btn-primary fw-medium px-4 w-auto">Xác nhận</button>
                 <button type="button" id="cancell" class="btn btn-danger fw-medium px-4 w-auto">Hủy</button>
             </div>    
         </div>
     </div>
</body>