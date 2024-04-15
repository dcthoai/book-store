
const searchButton = document.getElementById('search-button');
const inputSearch = document.getElementById('search-input');
const bookResultsContainer = document.getElementById('book-results');
const totalResults = document.getElementById('total-results');

function getDataBook(book){
    const html = `<div class="col-lg-3 col-md-4 col-6 mb-4">
                    <div class="product">
                        <a href="/bookstore/product?id=${ book.id }" class="product__link">
                            <div class="product__img"><img src="${ book.thumbnailPath }" alt="product image"></div>

                            <div class="product__info p-3 pt-2">
                                <h6 class="name mb-2">${ book.title }</h6>

                                <div class="rating mb-2">
                                    <i class="fa-regular fa-star"></i>
                                    <i class="fa-regular fa-star"></i>
                                    <i class="fa-regular fa-star"></i>
                                    <i class="fa-regular fa-star"></i>
                                    <i class="fa-regular fa-star"></i>
                                </div>
                                
                                <div>Đã bán: <span>${ book.purchases }</span></div>

                                <div class="price">
                                    ${ book.sellPrice } đ
                                    <span class="discount">-${ book.discount }%</span>
                                </div>

                                <del class="cost">${ book.cost }đ</del>
                            </div>
                        </a>
                    </div>
                </div>`;

    return html;
}

function searchBookByKeyword(){
    let keyword = inputSearch.value.trim();

    fetch(`/bookstore/shop/search?name=${keyword}`)
    .then(response => response.json())
    .then(data => {
		
		console.log(data);

        let resultsHtml = 'Không tìm thấy sản phẩm nào.';

        if (data) {
            if (Array.isArray(data)) {
                if (data.length > 0) {
                    resultsHtml = '';

                    data.forEach(book => {
                        resultsHtml += getDataBook(book);
                    });

                    totalResults.innerHTML = data.length;
                }
            }
        }

        bookResultsContainer.innerHTML = resultsHtml;
    })
    .catch(error => {
        // openPopupNotify('Không thể tìm kiếm', 'Đã có lỗi xảy ra, vui lòng thử lại sau', 'error');
        console.error(error);
    })
}

// Search when click button
searchButton.addEventListener('click', function(){
    searchBookByKeyword();
});

// Search when enter
inputSearch.addEventListener('keydown', function(event){
    if (event.key === 'Enter' || event.code === 13) {
        searchBookByKeyword();
    }
});