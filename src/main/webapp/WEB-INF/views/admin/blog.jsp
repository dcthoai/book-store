<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ include file="/common/taglib.jsp" %>

<head>
	<title>Blogs | Admin</title>
</head>

<body>
	<h4 class="p-3 ps-lg-0 fs-4 text-light fw-semibold">Quản lý các blog</h4>

    <div class="card mb-4 w-100">
        <div class="card-header d-flex flex-wrap justify-content-between align-items-center py-3">
            <div class="mb-3 fs-5 fw-medium opacity-75"><i class="fas fa-table me-3"></i>Danh sách bài viết</div>
        </div>

        <div class="card-body">
            <table id="table-list-slides" class="w-100 table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th class=""><input type="checkbox" name="table-select-all" id="table-select-all"></th>
                        <th class="text-center">Tiêu đề</th>
                        <th class="text-center">Tác giả</th>
                        <th class="text-center">Ngày tạo</th>
                        <th class="text-center">Ngày cập nhật</th>
                        <th class="text-center">Chỉnh sửa</th>
                    </tr>
                </thead>
                
                <tbody>
                	<c:set var="customerService" value="${ customerService }"></c:set>
                	<c:forEach var="blog" items="${ blogs }">
                		<tr>
	                        <td><input type="checkbox" name="table-select"></td>
	                        <td class="">${ blog.title }</td>
	                        <td class="">${ customerService.getCustomerById(blog.authorId).getFullname() }</td>
	                        <td class="text-center ">${ blog.createdDate }</td>
	                        <td class="text-center ">${ blog.modifiedDate }</td>
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