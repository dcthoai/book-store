<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ include file="/common/taglib.jsp" %>

<head>
	<title>Đơn hàng | Admin</title>
</head>

<body>
	<h4 class="p-3 ps-lg-0 fs-4 text-light fw-semibold">Quản lý đơn hàng của người dùng</h4>

    <div class="card mb-4 w-100">
        <div class="card-header d-flex flex-wrap justify-content-between align-items-center py-3">
            <div class="mb-3 fs-5 fw-medium opacity-75"><i class="fas fa-table me-3"></i>Danh sách đơn hàng</div>
        </div>

        <div class="card-body">
            <table id="table-list-slides" class="w-100 table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th class=""><input type="checkbox" name="table-select-all" id="table-select-all"></th>
                        <th class="">Tên khách hàng</th>
                        <th class="">Địa chỉ</th>
                        <th class="">Trạng thái đơn hàng</th>
                        <th class="">Trạng thái thanh toán</th>
                        <th class="">Trạng thái vận chuyển</th>
                        <th class="">Hình thức thanh toán</th>
                        <th class="text-center">Phí vận chuyển</th>
                        <th class="text-center">Giá tiền</th>
                        <th class="text-center">Chiết khấu</th>
                        <th class="text-center">Tổng thanh toán</th>
                        <th class="text-center">Ngày dặt hàng</th>
                        <th class="text-center">Ngày giao hàng</th>
                        <th class="text-center">Chỉnh sửa</th>
                    </tr>
                </thead>
                
                <tbody>
                	<c:set var="customerService" value="${ customerService }"></c:set>
                	<c:forEach var="order" items="${ orders }">
                		<tr>
	                        <td><input type="checkbox" name="table-select"></td>
	                        <td class="">${ customerService.getCustomerById(order.customerId).getFullname() }</td>
	                        <td class="">${ order.address }</td>
	                        <td class="">
							    <c:choose>
							        <c:when test="${order.orderStatus == 1}">Đã hoàn thành</c:when>
							        <c:when test="${order.orderStatus == 0}">Chưa hoàn thành</c:when>
							    </c:choose>
							</td>
							
							<td class="">
							    <c:choose>
							        <c:when test="${order.paymentStatus == 1}">Đã thanh toán</c:when>
							        <c:when test="${order.paymentStatus == 0}">Chưa thanh toán</c:when>
							    </c:choose>
							</td>
							
							<td class="">
							    <c:choose>
							        <c:when test="${order.shippingStatus == 1}">Đã giao hàng</c:when>
							        <c:when test="${order.shippingStatus == 0}">Đang giao hàng</c:when>
							    </c:choose>
							</td>

	                        <td class="">${ order.paymentMethod }</td>
	                        <td class="text-center">${ order.shippingCost }</td>
	                        <td class="text-center">${ order.totalPrice }</td>
	                        <td class="text-center ">${ order.discount }%</td>
	                        <td class="text-center ">${ order.totalPayment }</td>
	                        <td class="text-center ">${ order.orderDate }</td>
	                        <td class="text-center ">${ order.deliveredAt }</td>
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