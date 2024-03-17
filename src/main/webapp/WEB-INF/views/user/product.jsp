<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<title>Product</title>

<body>
	<div class="container">
		<div class="list-product">
			<c:forEach var="book" items="${ books }">
				<div class="product">
					<h4>Tên: ${ book.title }</h4>
					<h4>Ảnh: ${ book.thumbnail }</h4>
					<h4>Giá: ${ book.price }</h4>
					<h4>Mô tả: ${ book.descriptions }</h4>
					<h4>Tác giả: ${ book.author }</h4>
					<h4>Thể loại: ${ book.categoryId }</h4>
					<h4>Ngôn ngữ: ${ book.languageId }</h4>
					<h4>Mã giảm giá: ${ book.voucherId }</h4>
					<h4>Giới hạn tuổi: ${ book.ageLimit }</h4>
					<h4>Số trang: ${ book.pages }</h4>
					<h4>Giảm giá: ${ book.discount }</h4>
					<h4>Kích thước: ${ book.size }</h4>
					<h4>Trọng lượng: ${ book.weight }</h4>
					<h4>Nhà xuất bản: ${ book.publisher }</h4>
					<h4>Ngày phát hành: ${ book.releaseDate }</h4>
				</div>
			</c:forEach>
		</div>
	</div>
</body>