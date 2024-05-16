
document.getElementById('thumbnail').addEventListener('change', function(event) {
    const file = event.target.files[0];
    
    if (file) {
        const reader = new FileReader();
        reader.onload = function(e) {
            document.getElementById('thumbnail-img').src = e.target.result;
        }
        reader.readAsDataURL(file);
    }
});

document.getElementById('upload-slide').addEventListener('click', async function() {
    const formData = new FormData();
    
    const fileInput = document.getElementById('thumbnail');
    const titleInput = document.getElementById('title');
    const descriptionInput = document.getElementById('description');
    const productLinkInput = document.getElementById('slide-product-link');
    
    if (fileInput.files.length > 0) {
        formData.append('thumbnail', fileInput.files[0]);
    }
    
    formData.append('title', titleInput.value);
    formData.append('description', descriptionInput.value);
    formData.append('slideProductLink', productLinkInput.value);
    console.log(formData);
    try {
        const response = await fetch('/bookstore/admin/dashboard/slide/upload', {
            method: 'POST',
            body: formData
        });
        
        if (response.ok) {
            const result = await response.json();
            alert('Upload successful: ' + result.message);
        } else {
            alert('Upload failed: ' + response.statusText);
        }
    } catch (error) {
        console.error('Error during upload:', error);
        alert('Error during upload: ' + error.message);
    }
});

document.getElementById('cancell').onlick = () => {
	window.location.href = '/';
}
