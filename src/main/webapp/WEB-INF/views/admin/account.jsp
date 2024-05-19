<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ include file="/common/taglib.jsp" %>

<head>
	<title>Quản lý tài khoản | Admin</title>
</head>

<body>

	<h4 class="p-3 ps-lg-0 fs-4 text-light fw-semibold">Quản lý tài khoản người dùng</h4>

    <div class="w-100 d-flex flex-wrap justify-content-between my-4">
        <div class="d-flex form-search-book mb-4">
            <input type="text" class="flex-1 h-100 form-control form-search-input" id="search-book-input" placeholder="Nhập username">
            <button type="button" class="ms-2 btn btn-primary py-0 fw-medium" id="search-book-button">Tìm kiếm</button>
        </div>

        <a href="" class="text-decoration-none">
            <button type="button" class="btn btn-primary ms-auto py-0 fw-medium add-new">Thêm tài khoản</button>
        </a>
    </div>

    <div class="card mb-4 w-100">
        <div class="card-header d-flex flex-wrap justify-content-between align-items-center py-3">
            <div class="mb-3 fs-5 fw-medium opacity-75"><i class="fas fa-table me-3"></i>Danh sách tài khoản</div>
        </div>

        <div class="card-body">
            <table id="table-list-slides" class="w-100 table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th class=""><input type="checkbox" name="table-select-all" id="table-select-all"></th>
                        <th class="col-2">Username</th>
                        <th class="col-2">Tên đầy đủ</th>
                        <th class="col-2">Email</th>
                        <th class="col-1 text-center">Số điện thoại</th>
                        <th class="col-2 text-center">Loại tài khoản</th>
                        <th class="col-1 text-center">Người tạo</th>
                        <th class="col-2 text-center">Ngày tạo</th>
                        <th class="col-1 text-center">Chỉnh sửa</th>
                    </tr>
                </thead>
                
                <tbody>
                	<c:forEach var="user" items="${ users }">
                		<tr>
	                        <td><input type="checkbox" name="table-select" data-account-id="${ user.id }"></td>
	                        <td class="">${ user.username }</td>
	                        <td class="">${ user.fullname }</td>
	                        <td class="">${ user.email }</td>
	                        <td class="text-center">${ user.phone }</td>
	                        <td class="text-center">${ user.role }</td>
	                        <td class="text-center">${ customer.getCreatedBy() }</td>
	                        <td class="text-center">${ customer.getCreatedDate() }</td>
	                        <td>
	                            <div class="w-100 h-100 d-flex justify-content-evenly">
	                                <a href="" class="flex-fill edit-book"><i class="fa-regular fa-pen-to-square"></i></a>
	                                <a href="" class="flex-fill delete-book"><i class="fa-regular fa-trash-can"></i></a>
	                            </div>
	                        </td>
	                    </tr>
                	</c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>