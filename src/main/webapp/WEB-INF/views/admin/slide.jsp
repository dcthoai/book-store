<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ include file="/common/taglib.jsp" %>

<head>
	<title>Banner quảng cáo | Admin</title>
</head>

<body>
	<h4 class="p-3 ps-lg-0 fs-4 text-light fw-semibold">Banner quảng cáo</h4>

    <div class="w-100 d-flex justify-content-end my-4">
        <a href="/bookstore/admin/dashboard/slide/add" class="text-decoration-none">
            <button type="button" class="btn btn-primary ms-auto py-0 fw-medium add-new">Thêm banner</button>
        </a>
    </div>

    <div class="card mb-4 w-100">
        <div class="card-header d-flex flex-wrap justify-content-between align-items-center py-3">
            <div class="mb-3 fs-5 fw-medium opacity-75"><i class="fas fa-table me-3"></i>Danh sách banner</div>
        </div>

        <div class="card-body">
            <table id="table-list-slides" class="w-100 table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th class=""><input type="checkbox" name="table-select-all" id="table-select-all"></th>
                        <th class="col-4">Tiêu đề</th>
                        <th class="col-1 text-center">Đường dẫn sản phẩm</th>
                        <th class="col-1 text-center">Người thêm</th>
                        <th class="col-1 text-center">Ngày thêm</th>
                        <th class="col-1 text-center">Người sửa</th>
                        <th class="col-1 text-center">Ngày sửa</th>
                        <th class="col-1 text-center">Chỉnh sửa</th>
                    </tr>
                </thead>
                
                <tbody>
                	<c:forEach var="slide" items="${ slides }">
	                    <tr>
	                        <td><input type="checkbox" name="table-select"></td>
	                        <td class="">${ slide.caption }</td>
	                        <td class="">${ slide.link }</td>
	                        <td class="text-center">${ slide.createdBy }</td>
	                        <td class="text-center">${ slide.createdDate }</td>
	                        <td class="text-center ">${ slide.modifiedBy }</td>
	                        <td class="text-center ">${ slide.modifiedDate }</td>
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