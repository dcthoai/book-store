const addToCart = document.getElementById('add-to-cart');
const buyNow = document.getElementById('buy-now');

const increaseNumber = document.querySelector('.product .product__quantity .quantity .quantity__add');
const decreaseNumber = document.querySelector('.product .product__quantity .quantity .quantity__sub');
const productQuantity = document.querySelector('.product .product__quantity .quantity .quantity__input');

increaseNumber.addEventListener('click', function(){
    let quantity = parseInt(productQuantity.value);

    productQuantity.value = quantity + 1;
});

decreaseNumber.addEventListener('click', function(){
    let quantity = parseInt(productQuantity.value);

    if (quantity > 1){
        productQuantity.value = quantity - 1;
    } else {
        productQuantity.value = 1;
    }
})

addToCart.addEventListener('click', function(){
	let bookId = addToCart.dataset.product;
	
	fetch('/bookstore/cart/add', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify({
			'bookId': bookId,
			'quantity': productQuantity.value
		})
	})
	.then(response => response.json())
	.then(status => {
		if (status.success){
			openPopupNotify('Thêm vào giỏ hàng thành công', 'Tiếp tục mua sắm nào.', 'success');
		} else {
			openPopupNotify('Thêm thất bại', 'Rất tiếc khi có lỗi, vui lòng thử lại sau.', 'error');
            console.log(status.message);
		}
	})
	.catch(error => {
        openPopupNotify('Thêm thất bại', 'Rất tiếc khi có lỗi, vui lòng thử lại sau.', 'error');
		console.error(error);
	})
});

buyNow.addEventListener('click', function(){
    let bookId = addToCart.dataset.product;
    
})