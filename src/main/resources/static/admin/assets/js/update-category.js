
const updateCategoryBtn = document.getElementById('update-category-btn');
const categoryInput = document.getElementById('category');

updateCategoryBtn.addEventListener('click', () => {
	fetch('/bookstore/admin/dashboard/category/update', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify({
			"category": categoryInput.value.trim(),
			"id": updateCategoryBtn.dataset.id
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