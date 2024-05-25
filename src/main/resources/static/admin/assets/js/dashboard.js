const loadingAnimation = document.getElementById('popup-loader');

function openLoadingAnimation(){
    loadingAnimation.style.display = 'block';
    
    setTimeout(function(){
		closeLoadingAnimation();
	}, 1500);
}

function closeLoadingAnimation(){
    loadingAnimation.style.display = 'none';
}

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