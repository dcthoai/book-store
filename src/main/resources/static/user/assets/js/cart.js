
var listIncreaseQuantityButton = document.querySelectorAll('.cart .product .quantity .quantity__add');
var listDecreaseQuantityButton = document.querySelectorAll('.cart .product .quantity .quantity__sub');
var listInputQuantity = document.querySelectorAll('.cart .product .quantity .quantity__input');
var listDeleteButton = document.querySelectorAll('.cart .product .delete');

function updateCartProduct(cartProduct, inputIndex){
	console.log(cartProduct);
	
	fetch('/bookstore/cart/update', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(cartProduct)
	})
	.then(response => response.json())
	.then(status => {
		if (status.success){
			listInputQuantity[inputIndex].value = cartProduct.quantity;
		} else {
			openPopupNotify('Thất bại', 'Rất tiếc khi có lỗi, vui lòng thử lại sau.', 'error');
            console.log(status.message);
		}
	})
	.catch(error => {
        openPopupNotify('Thất bại', 'Rất tiếc khi có lỗi, vui lòng thử lại sau.', 'error');
		console.error(error);
	})
}

function deleteCartProduct(cartProductId){
	fetch('/bookstore/cart/delete', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify({
			'cartProductId': cartProductId
		})
	})
	.then(response => response.json())
	.then(status => {
		if (status.success){
			location.reload();
			openPopupNotify('Xóa sản phẩm thành công!', '', 'success');
		} else {
			openPopupNotify('Thất bại', 'Rất tiếc khi có lỗi, vui lòng thử lại sau.', 'error');
            console.log(status.message);
		}
	})
	.catch(error => {
        openPopupNotify('Thất bại', 'Rất tiếc khi có lỗi, vui lòng thử lại sau.', 'error');
		console.error(error);
	})
}

listIncreaseQuantityButton.forEach((button, index) => {
	button.addEventListener('click', function(){
		let cartProductId = button.dataset.id;
		let quantity = parseInt(listInputQuantity[index].value);

		let cartProduct = {
			'cartProductId': cartProductId,
			'quantity': quantity + 1
		}
		
		updateCartProduct(cartProduct, index);
	});
});

listDecreaseQuantityButton.forEach((button, index) => {
	button.addEventListener('click', function(){
		let cartProductId = button.dataset.id;
		let quantity = parseInt(listInputQuantity[index].value);

		if (quantity <= 1) {
			openPopupConfirm('Bạn có chắc chắn muốn xóa sản phẩm này không?', '', 'warning', function(success){
				if (success){
					closePopupNotify();
					deleteCartProduct(cartProductId);
				}
			});
		} else {
			let cartProduct = {
				'cartProductId': cartProductId,
				'quantity': quantity - 1
			}
			
			updateCartProduct(cartProduct, index);
		}
	});
});

listDeleteButton.forEach((button) => {
	button.addEventListener('click', function(){
		let cartProductId = button.dataset.id;
		
		openPopupConfirm('Bạn có chắc chắn muốn xóa sản phẩm này không?', '', 'warning', function(success){
			if (success){
				closePopupNotify();
				deleteCartProduct(cartProductId);
			}
		});
	});
});
