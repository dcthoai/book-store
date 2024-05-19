<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ include file="/common/taglib.jsp" %>

<head>
	<title>Dashboard | Admin</title>
</head>

<body>
	<h4 class="p-3 ps-lg-0 fs-4 text-light fw-semibold">Quản lý sản phẩm</h4>

    <div class="w-100 d-flex flex-wrap justify-content-between my-4">
        <div class="d-flex form-search-book mb-4">
            <input type="text" class="flex-1 h-100 form-control form-search-input" id="search-book-input" placeholder="Nhập tên sách">
            <button type="button" class="ms-2 btn btn-primary py-0 fw-medium" id="search-book-button">Tìm kiếm</button>
        </div>

        <a href="/bookstore/admin/dashboard/product/add" class="text-decoration-none">
            <button type="button" class="btn btn-primary py-0 fw-medium add-new">Thêm sách</button>
        </a>
    </div>

    <div class="card mb-4 w-100">
        <div class="card-header d-flex flex-wrap justify-content-between align-items-center py-3">
            <div class="mb-3 fs-5 fw-medium opacity-75"><i class="fas fa-table me-3"></i>Danh sách sản phẩm</div>

            <div class="panigations-box ms-auto">
                <nav>
                    <ul class="pagination m-0">
                        <li class="page-item">
                            <a class="page-link" href="#">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li class="page-item active"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item">
                            <a class="page-link" href="#">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <div class="card-body">
            <table id="table-list-books" class="w-100 table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th class="col-auto"><input type="checkbox" name="table-select-all" id="table-select-all"></th>
                        <th class="col">Tên sản phẩm</th>
                        <th class="col">Tác giả</th>
                        <th class="col text-center">Giá bán</th>
                        <th class="col text-center">Giá gốc</th>
                        <th class="col text-center">Giảm giá</th>
                        <th class="col text-center">Tồn kho</th>
                        <th class="col text-center">Ngày thêm</th>
                        <th class="col text-center">Chỉnh sửa</th>
                    </tr>
                </thead>
                
                <tbody>
                	<c:set var="bookService" value="${ bookService }"></c:set>
                    <c:forEach var="book" items="${ books }">
                    	<tr>
	                        <td><input type="checkbox" name="table-select"></td>
	                        <td class="table-title">${ book.title }</td>
	                        <td class="table-author">${ book.author }</td>
	                        <td class="table-price text-center ">${ book.getSellPrice() }</td>
	                        <td class="table-cost text-center ">${ book.price }</td>
	                        <td class="table-discount text-center ">${ book.discount }%</td>
	                        <td class="table-stock text-center ">50</td>
	                        <td class="table-date text-center ">${ book.createdDate }</td>
	                        <td>
	                            <div class="w-100 h-100 d-flex justify-content-evenly">
	                                <a href="/bookstore/admin/dashboard/product/edit?id=${ book.id }" class="flex-fill edit-book"><i class="fa-regular fa-pen-to-square"></i></a>
	                                <a class="flex-fill delete-book"><i class="fa-regular fa-trash-can"></i></a>
	                            </div>
	                        </td>
	                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>