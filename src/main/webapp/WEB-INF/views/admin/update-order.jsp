<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ include file="/common/taglib.jsp" %>

<head>
	<title>Cập nhật đơn hàng | Admin</title>
	<link rel="stylesheet" href="/bookstore/admin/assets/css/add-book.css">
</head>

<body>
	<h4 class="p-3 ps-lg-0 fs-4 text-light fw-semibold">Quản lý đơn hàng</h4>

     <div class="form-add-book mt-4 px-3 px-lg-4 pb-5 rounded">
         <h5 class="mb-4 pt-4 text-center text-md-start">Cập nhật trạng thái đơn hàng</h5>

         <div class="row mt-5">
             <div class="col-12 col-lg-8 col-xxl-6 mb-3">
                 <label for="status" class="form-label fs-6 fw-medium opacity-75">Trạng thái đơn hàng</label>
                 <input type="text" class="form-control" id="status" name="status">
             </div>
         </div>

         <div class="row mt-3">
             <div class="col-12 col-lg-8 col-xxl-6 mb-3">
                 <label for="shipper" class="form-label fs-6 fw-medium opacity-75">Số điện thoại shipper</label>
                 <input type="text" class="form-control" id="shipper" name="shipper">
             </div>
         </div>

         <div class="row mt-3 mb-5">
             <div class="col-12 col-lg-8 col-xxl-6 mb-4">
                 <label for="estimatedDate" class="form-label fs-6 fw-medium opacity-75">Ngày giao hàng dự kiến</label>
                 <input type="date" class="form-control" id="estimatedDate">
             </div>
         </div>
         
         <div class="row mt-3 mb-5">
             <button class="btn btn-primary">Đã giao hàng</button>
         </div>

         <div class="row justify-content-center justify-content-md-start">
             <div class="col-auto">
                 <button type="button" id="upload-slide" class="btn btn-primary fw-medium px-4 w-auto">Xác nhận</button>
                 <button type="button" id="cancell" class="btn btn-danger fw-medium px-4 w-auto">Hủy</button>
             </div>    
         </div>
     </div>
</body>