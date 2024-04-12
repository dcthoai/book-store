const addCartButton = document.getElementById('add-to-cart');
const buyNowButton = document.getElementById('buy-now');

addCartButton.addEventListener('click', function(){
	let bookId = addCartButton.dataset.product;
	console.log(bookId);
	
	fetch('/bookstore/cart/add', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify({
			'bookId': bookId,
			'cartId': 1,
			'quantity': 1
		})
	})
	.then(response => response.json())
	.then(status => {
		if (status.success){
			console.log('success');
		} else {
			console.log(status.message);
		}
	})
	.catch(error => {
		console.error(error);
	})
});