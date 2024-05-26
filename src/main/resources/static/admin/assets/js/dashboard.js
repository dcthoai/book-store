
function logout() {
	const token = localStorage.getItem('AdminToken');
	
	fetch('/bookstore/admin/logout', {
		method: 'POST',
		headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`
        }
	})
	.then(response => response.json())
	.then(status => {
		if (status.success){
			openPopupNotify('Đăng xuất thành công', '', 'success');
			localStorage.removeItem('AdminToken');
			
			setTimeout(() => {
				window.location.href = '/bookstore/admin';
			}, 1000);
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

document.getElementById('logout-admin-btn').addEventListener('click', () => {
	logout();
})

var deleteBookBtns = document.querySelectorAll('#table-list-books .delete-book');

deleteBookBtns.forEach(button => {
	button.addEventListener('click', () => {
		openPopupConfirm('Bạn có chắc chắn muốn xóa sản phẩm này không?', '', 'warning', function(isSuccess){
			if (isSuccess){
				closePopupNotify();
				
				fetch(`/bookstore/admin/dashboard/product/delete?id=${button.dataset.id}`, {
					method: 'DELETE'
				})
				.then(response => response.json())
				.then(status => {
					if (status.success){
						openPopupNotify('Xóa thành công', '', 'success');
						
						setTimeout(() => {
							location.reload();
						}, 2000);
					} else {
						openPopupNotify('Thất bại', status.message, 'error');
					}
				})
				.catch(error => {
					openPopupNotify('Thất bại', 'Rất tiếc khi có lỗi, vui lòng thử lại sau.', 'error');
					console.error(error);
				})
			}
		});
	})
})