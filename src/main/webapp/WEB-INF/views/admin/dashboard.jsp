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

        <a href="add-book.html" class="text-decoration-none">
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
                        <th class=""><input type="checkbox" name="table-select-all" id="table-select-all"></th>
                        <th class="col-4">Tên sản phẩm</th>
                        <th class="col-2">Tác giả</th>
                        <th class="col-1 text-center">Giá bán</th>
                        <th class="col-1 text-center">Giá gốc</th>
                        <th class="col-1 text-center">Giảm giá</th>
                        <th class="col-1 text-center">Tồn kho</th>
                        <th class="col-1 text-center">Ngày thêm</th>
                        <th class="col-1 text-center">Chỉnh sửa</th>
                    </tr>
                </thead>
                
                <tbody>
                    <tr>
                        <td><input type="checkbox" name="table-select"></td>
                        <td class="table-title">Hail Mary</td>
                        <td class="table-author">Eric Paul</td>
                        <td class="table-price text-center ">124.500</td>
                        <td class="table-cost text-center ">124.500</td>
                        <td class="table-discount text-center ">5%</td>
                        <td class="table-stock text-center ">61</td>
                        <td class="table-date text-center ">2011/04/25</td>
                        <td>
                            <div class="w-100 h-100 d-flex justify-content-evenly">
                                <a href="" class="flex-fill edit-book"><i class="fa-regular fa-pen-to-square"></i></a>
                                <a href="" class="flex-fill delete-book"><i class="fa-regular fa-trash-can"></i></a>
                            </div>
                        </td>
                    </tr>
                    
                    <tr>
                        <td><input type="checkbox" name="table-select"></td>
                        <td class="table-title">Hail Mary</td>
                        <td class="table-author">Eric Paul</td>
                        <td class="table-price text-center ">124.500</td>
                        <td class="table-cost text-center ">124.500</td>
                        <td class="table-discount text-center ">5%</td>
                        <td class="table-stock text-center ">61</td>
                        <td class="table-date text-center ">2011/04/25</td>
                        <td>
                            <div class="w-100 h-100 d-flex justify-content-evenly">
                                <a href="" class="flex-fill edit-book"><i class="fa-regular fa-pen-to-square"></i></a>
                                <a href="" class="flex-fill delete-book"><i class="fa-regular fa-trash-can"></i></a>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td><input type="checkbox" name="table-select"></td>
                        <td class="table-title">Hail Mary Hail Mary Hail Mary</td>
                        <td class="table-author">Eric Paul</td>
                        <td class="table-price text-center ">124.500</td>
                        <td class="table-cost text-center ">124.500</td>
                        <td class="table-discount text-center ">5%</td>
                        <td class="table-stock text-center ">61</td>
                        <td class="table-date text-center ">2011/04/25</td>
                        <td>
                            <div class="w-100 h-100 d-flex justify-content-evenly">
                                <a href="" class="flex-fill edit-book"><i class="fa-regular fa-pen-to-square"></i></a>
                                <a href="" class="flex-fill delete-book"><i class="fa-regular fa-trash-can"></i></a>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</body>