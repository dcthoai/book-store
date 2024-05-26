
const submitSlideBtn = document.getElementById('edit-slide');
const thumbnailSlideInput = document.getElementById('thumbnail-demo');

document.getElementById('thumbnail').addEventListener('change', function(e) {
    thumbnailSlideInput.src = URL.createObjectURL(e.target.files[0]);
});

submitSlideBtn.addEventListener('click', () => {
	let formData = new FormData();

    // Fetch các giá trị từ form và thêm vào FormData
    formData.append('caption', document.getElementById('caption').value);
    formData.append('content', document.getElementById('content').value);
    formData.append('link', document.getElementById('link').value);
    
	let thumbnailFile = document.getElementById('thumbnail').files[0];
    
	if (thumbnailFile)
	    formData.append('thumbnail', thumbnailFile);
    
    formData.append('id', submitSlideBtn.dataset.id);
    
    fetch('/bookstore/admin/dashboard/slide/update', {
        method: 'POST',
        body: formData
    })
    .then(response => response.json())
    .then(status => {
        if (status.success) {
			openPopupNotify('Thành công', '', 'success');
			
			setTimeout(() => {
				location.reload();
			}, 1500);
		} else {
			openPopupNotify('Thất bại', status.message, 'error');
		}
    })
    .catch(error => {
		openPopupNotify('Thất bại', 'Rất tiếc khi có lỗi, vui lòng thử lại sau.', 'error');
        console.error('Error:', error);
    });
});


document.getElementById('cancell-slide').addEventListener('click', () => {
	window.location.href = '/bookstore/admin/dashboard/slide';
})