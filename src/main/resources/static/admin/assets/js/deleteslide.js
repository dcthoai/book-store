const deleteSlideBtns = document.querySelectorAll(".delete-slide-btn");
    	
deleteSlideBtns.forEach(button => {
	button.addEventListener('click', () => {
		openPopupConfirm('Bạn có chắc chắn muốn xóa banner này không?', '', 'warning', function(isSuccess){
			if (isSuccess){
				closePopupNotify();
				
				fetch(`/bookstore/admin/dashboard/slide/delete?id=${button.dataset.id}`, {
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