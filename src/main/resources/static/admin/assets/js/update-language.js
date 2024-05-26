
const updateLanguegeBtn = document.getElementById('update-language-btn');
const languageInput = document.getElementById('language');

updateLanguegeBtn.addEventListener('click', () => {
	fetch('/bookstore/admin/dashboard/language/update', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify({
			"language": languageInput.value.trim(),
			"id": updateLanguegeBtn.dataset.id
		})
	})
	.then(response => response.json())
	.then(status => {
		if (status.success){
			openPopupNotify('Cập nhật thành công', '', 'success');
			
			setTimeout(() => {
				location.reload();
			}, 1000);
		} else {
			openPopupNotify('Thất bại', status.message, 'error');
		}
	})
	.catch(error => {
        openPopupNotify('Thất bại', 'Rất tiếc khi có lỗi, vui lòng thử lại sau.', 'error');
		console.error(error);
	})
});