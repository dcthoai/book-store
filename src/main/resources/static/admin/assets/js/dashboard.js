
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
});

const adminSearchBookButton = document.getElementById("search-book-button");
const adminSearchBookInput = document.getElementById('search-book-input');
const resultsBookadmin = document.getElementById('search-book-container');

adminSearchBookButton.addEventListener('click', () => {
	let key = adminSearchBookInput.value.trim();
	fetch(`/bookstore/admin/dashboard/product/search?name=${ key }`)
	.then(response => response.json())
	.then(data => {
		let resultsHtml1 = 'Không tìm thấy sản phẩm nào.';
		
		if (data) {
            if (Array.isArray(data)) {
                if (data.length > 0) {
                    resultsHtml1 = '';

                    data.forEach(book => {
                        resultsHtml1 += `
	                        <tr>
		                        <td class="table-title" style="width: max-content; max-width: 20rem; overflow-x:hidden; text-wrap: nowrap;">
		                        	${ book.title }</td>
		                        <td class="table-author">${ book.author }</td>
		                        <td class="table-price text-center ">${ book.sellPrice }</td>
		                        <td class="table-cost text-center ">${ book.cost }</td>
		                        <td class="table-discount text-center ">${ book.discount }%</td>
		                        <td class="table-stock text-center ">${ book.stock }</td>
		                        <td class="table-date text-center ">${ book.createdDate }</td>
		                        <td>
		                            <div class="w-100 h-100 d-flex justify-content-evenly">
		                                <a href="/bookstore/admin/dashboard/product/edit?id=${ book.id }" class="flex-fill edit-book"><i class="fa-regular fa-pen-to-square"></i></a>
		                                <a data-id="${ book.id }" class="flex-fill delete-book"><i class="fa-regular fa-trash-can"></i></a>
		                            </div>
		                        </td>
		                    </tr>
						`;
                    });
                }
            }
        }
        
        resultsBookadmin.innerHTML = resultsHtml1;
	})
	.catch(error => {
		openPopupNotify('Thất bại', 'Rất tiếc khi có lỗi, vui lòng thử lại sau.', 'error');
		console.error(error);
	})
})