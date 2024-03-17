
fetch('/api/data')
    .then(response => response.json())
    .then(image => {
        Document.querySelector('.container').innerHtml = `
        	${image[0]}
        `;
    });