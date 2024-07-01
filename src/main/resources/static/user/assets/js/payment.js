
var priceProducts = document.querySelectorAll('.price__total');
const totalPayment = document.getElementById('total-payment');
const paymentConfirmBtn = document.getElementById('payment-confirm');

function getTotalPrice() {
	let total = 0;
	
	priceProducts.forEach(button => {
		let temp = button.textContent.trim();
        total += Number(temp.replace(/đ/g, ''));
	});
	
	return total;
}

totalPayment.innerText = getTotalPrice() + "đ";

paymentConfirmBtn.addEventListener('click', () => {
	let fullname = document.querySelector('input[name="payment-name"]').value.trim();
	let phone = document.querySelector('input[name="payment-phone"]').value.trim();
	let address = document.querySelector('input[name="payment-address"]').value.trim();
	
	fetch(BASE_URL + '/payment/add', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify({
			"fullname": fullname,
			"phone": phone,
			"address": address,
			"paymentMethod": "Tiền mặt"
		})
	})
	.then(response => response.json())
	.then(status => {
		if (status.success){
			openPopupNotify('Đặt hàng thành công', '', 'success');
			
			setTimeout(() => {
				window.location.href = BASE_URL + "/cart";
			}, 2000);
		} else {
			openPopupNotify('Thất bại', 'Rất tiếc khi có lỗi, vui lòng thử lại sau.', 'error');
            console.log(status.message);
		}
	})
	.catch(error => {
        openPopupNotify('Thất bại', 'Rất tiếc khi có lỗi, vui lòng thử lại sau.', 'error');
		console.error(error);
	})
});
