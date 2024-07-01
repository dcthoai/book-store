<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ include file="/common/taglib.jsp" %>

<head>
	<title>Chỉnh sửa sản phẩm | Admin</title>
	<link rel="stylesheet" href="${BASE_URL}/static/admin/assets/css/add-book.css" />
</head>

<body>
	<c:set var="mediaService" value="${ mediaService }"></c:set>

	<h4 class="p-3 ps-lg-0 fs-4 text-light fw-semibold">Quản lý sản phẩm</h4>

    <div class="form-add-book mt-4 px-3 px-lg-4 pb-5 rounded">
        <h5 class="mb-4 pt-4 text-center text-md-start">Chỉnh sửa thông tin sản phẩm</h5>

        <div class="row mt-5 mb-3">
            <div class="col-12 col-lg-8">
                <label for="thumbnail" class="form-label mb-4 fs-6 fw-medium opacity-75">Ảnh thumbnail</label>
                <br>
                <div class="img-wrapper">
                    <img id="thumbnail-demo" class="rounded img-fluid" src="${BASE_URL}/${ mediaService.getMediaById(book.thumbnailId).getPath() }" alt="thumbnail" id="thumbnail-img">
                </div>
            </div>

            <div class="col-12 col-md-8 col-xxl-6">
                <input type="file" class="form-control mt-4" id="thumbnail" name="thumbnail">
            </div>
        </div>

        <div class="row mt-5 mb-3">
            <div class="col-12 col-lg-8">
                <label for="files" class="form-label mb-4 fs-6 fw-medium opacity-75">Hình ảnh sản phẩm</label>
                
                <div class="d-flex w-100 flex-wrap">
                    <!-- <div class="img-wrapper me-3 mb-3">
                        <img class="rounded img-fluid" src="/bookstore/admin/assets/images/doi-thua.jpg" alt="product-img">
                    </div>

                    <div class="img-wrapper me-3 mb-3">
                        <img class="rounded img-fluid" src="/bookstore/admin/assets/images/hail-mary.jpg" alt="product-img">
                    </div> -->
                </div>
            </div>

            <div class="col-12 col-md-8 col-xxl-6">
                <input type="file" class="form-control mt-2" name="files[]" id="files" multiple>
            </div>
        </div>

        <div class="row mt-5">
            <div class="col-12 col-xl-8 col-xxl-6 mb-3">
                <label for="title" class="form-label fs-6 fw-medium opacity-75">Tên sách</label>
                <input type="text" class="form-control" id="title" name="title" value="${ book.title }">
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-12 col-xl-8 col-xxl-6 mb-3">
                <label for="description" class="form-label fs-6 fw-medium opacity-75">Mô tả</label>
                <textarea class="form-control" id="description" name="description" rows="6">${ book.description }</textarea>
            </div>
        </div>

        <div class="row mt-4">
            <label for="publisher" class="form-label fs-6 fw-medium opacity-75">Tác giả</label>
            
            <div class="col-12 col-sm-6 col-md-7 col-lg-6 col-xl-5 col-xxl-4 pe-2 pe-sm-0">
                <input type="text" class="form-control flex-sm-1 mb-3 mb-sm-0 me-sm-2 py-1" 
                		id="author" name="author" value="${ book.author }">
            </div>
        </div>

        <div class="row mt-4">
            <label for="publisher" class="form-label fs-6 fw-medium opacity-75">Nhà xuất bản</label>
            
            <div class="col-12 col-sm-6 col-md-7 col-lg-6 col-xl-5 col-xxl-4 pe-2 pe-sm-0">
                <input type="text" class="form-control flex-sm-1 mb-3 mb-sm-0 me-sm-2 py-1" 
                		id="publisher" name="publisher" value="${ book.publisher }">
            </div>
        </div>

        <div class="row mt-4">
            <label for="category" class="form-label fs-6 fw-medium opacity-75">Thể loại</label>
            
            <select id="category" class="form-control ms-3 mt-2" style="width: 260px">
            	<c:forEach var="category" items="${ categories }">
            		<option value="${ category.id }">${ category.name }</option>
            	</c:forEach>
	        </select>
        </div>

        <div class="row mt-4">
            <label for="language" class="form-label fs-6 fw-medium opacity-75">Ngôn ngữ</label>
            
            <select id="language" class="form-control ms-3 mt-2" style="width: 260px">
            	<c:forEach var="language" items="${ languages }">
            		<option value="${ language.id }">${ language.name }</option>
            	</c:forEach>
	        </select>
        </div>

        <div class="row mt-5 align-items-center">
            <label for="pages" class="col-6 col-md-3 col-lg-3 col-xl-2 form-label m-0 fs-6 fw-medium opacity-75">Số trang</label>
            <div class="col-6 col-md-4 col-lg-3 col-xxl-2">
                <input id="pages" type="number" class="form-control" name="pages" min="0" placeholder="0" value="${ book.pages }">
            </div>
        </div>

        <div class="row mt-4 align-items-center">
            <label for="weight" class="col-6 col-md-3 col-lg-3 col-xl-2 form-label m-0 fs-6 fw-medium opacity-75">Trọng lượng</label>
            <div class="col-6 col-md-4 col-lg-3 col-xxl-2">
                <input id="weight" type="number" class="form-control" name="weight" min="0" placeholder="0g" value="${ book.weight }">
            </div>
        </div>

        <div class="row mt-4 align-items-center">
            <label for="cost" class="col-6 col-md-3 col-lg-3 col-xl-2 form-label m-0 fs-6 fw-medium opacity-75">Giá gốc</label>
            <div class="col-6 col-md-4 col-lg-3 col-xxl-2">
                <input id="price" type="number" class="form-control" name="cost" min="0" placeholder="0đ" value="${ book.price }">
            </div>
        </div>

        <div class="row mt-4 align-items-center">
            <label for="discount" class="col-6 col-md-3 col-lg-3 col-xl-2 form-label m-0 fs-6 fw-medium opacity-75">Giảm giá</label>
            <div class="col-6 col-md-4 col-lg-3 col-xxl-2">
                <input id="discount" type="number" class="form-control" name="discount" min="0" max="100" placeholder="0%" value="${ book.discount }">
            </div>
        </div>

        <div class="row mt-4 align-items-center">
            <label for="stock" class="col-6 col-md-3 col-lg-3 col-xl-2 form-label m-0">Tồn kho</label>
            <div class="col-6 col-md-4 col-lg-3 col-xxl-2">
                <input id="stock" type="number" class="form-control" name="stock" min="0" placeholder="0" value="${ book.stock }">
            </div>
        </div>

        <div class="row mt-5">
            <div class="col-12 col-md-6 col-xxl-4 mb-4">
                <label for="dimension" class="form-label fs-6 fw-medium opacity-75">Kích thước</label>
                <input type="text" class="form-control" 
                		id="size" name="dimension" placeholder="Dài x rộng x cao (mm)" value="${ book.size }">
            </div>
        </div>

        <div class="row">
            <div class="col-12 col-md-6 col-xxl-4 mb-5">
                <label for="release-date" class="form-label fs-6 fw-medium opacity-75">Ngày phát hành</label>
                <input type="date" class="form-control" id="releaseDate" name="release-date" value="${ book.releaseDate }">
            </div>
        </div>

        <div class="row justify-content-center justify-content-md-start">
            <div class="col-auto">
                <button data-id="${ book.id }" id="submit-book" type="button" class="btn btn-primary fw-medium px-4 w-auto">Xác nhận</button>
                <button type="button" id="cancell-edit" class="btn btn-danger fw-medium px-4 w-auto">Hủy</button>
            </div>    
        </div>
    </div>
    
    <script type="text/javascript" src="${BASE_URL}/static/admin/assets/js/editbook.js"></script>
</body>