
function welcomeWebsite(){
	const currentState = getAuthenticationSate();
    const welcomeStatus = sessionStorage.getItem('welcomeStatus');

    if (welcomeStatus !== 'true') {
        if (currentState) {
            openPopupNotify('Hello', 
            				'Rất vui khi bạn quay lại, cùng nhau mua sắm sách thỏa thích nào.', 'notify');
        } else {
            openPopupNotify('Chào mừng bạn đến với BookStore', 
            				'Hãy đăng nhập để sử dụng đầy đủ tiện ích của chúng tôi.', 'notify');
        }
        sessionStorage.setItem('welcomeStatus', 'true');
    }
}

// Check authentication state when user visit website
function authenticate(){
    const token = localStorage.getItem('jwtToken');

    if(token){
        fetch(`/bookstore/authenticate`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            }
        })
        .then(response => response.json())
        .then(status => {
            closeLoadingAnimation();
            
			if (status.success) {
                setLoginState();
                setViewsByAuthenticationState();
            } else {
                setLogoutState();
                console.log(status.message);
            }
            
            welcomeWebsite();
        })
        .catch(error => {
			setLogoutState();
			closeLoadingAnimation();
			welcomeWebsite();
            console.error(error);
        });
    } else {
		setLogoutState();
		closeLoadingAnimation();
		welcomeWebsite();
        console.log('Not found token! User is not logged in.');
    }
}

function validateRegister(){

    Validator({
        form: 'form-register',
        formInput: '.input-box',
        errorMessage: '.label-error',
        rules: [
            Validator.isRequired('#username', 'Vui lòng nhập tên người dùng!'),
            Validator.isRequired('#email', 'Vui lòng nhập email của bạn!'),
            Validator.isRequired('#password', 'Vui lòng nhập mật khẩu của bạn!'),
            Validator.isRequired('#repeat-password', 'Vui lòng nhập lại mật khẩu của bạn!'),
            Validator.isEmail('#email', 'Vui lòng nhập một email hợp lệ!'),
            Validator.minLength('#password', 8, 'Vui lòng nhập tối thiểu 8 kí tự!'),
            Validator.minLength('#repeat-password', 8, 'Vui lòng nhập tối thiểu 8 kí tự!'),
            Validator.isConfirmed('#repeat-password', '#password', 'Vui lòng nhập lại đúng mật khẩu!')
        ],
        onSubmit: function(data){
            const user = {
                username: data['username'],
                email: data['email'],
                password: data['password']
            }

			register(user);   // Register when validate success 
        }
    });
}

function validateLogin(){

    Validator({
        form: 'form-login',
        formInput: '.input-box',
        errorMessage: '.label-error',
        rules: [
            Validator.isRequired('#username', 'Vui lòng nhập username hoặc email!'),
            Validator.isRequired('#password', 'Vui lòng nhập mật khẩu của bạn!'),
            Validator.minLength('#password', 8, 'Vui lòng nhập tối thiểu 8 kí tự!'),
        ],
        onSubmit: function(data){
            let user = {
				username: data['username'],
                password: data['password']
            }
        
			login(user);
        }
    });
}

function register(user){
    openLoadingAnimation();

    fetch('/bookstore/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user),
    })
    .then(response => response.json())
	.then(status => {
        closeLoadingAnimation();

		if (status.success){
			openPopupNotify('Đăng ký thành công!', 'Đăng nhập để trải nghiệm ngay nào.', 'success');
            changeToLogin();
		} else {
			openPopupNotify('Đăng ký thất bại!', 'Rất tiếc khi xảy ra lỗi, vui lòng thử lại sau.', 'error');
			console.log(status.message);
		}
	})
    .catch(error => {
        closeLoadingAnimation();
        openPopupNotify('Đăng ký thất bại!', 'Rất tiếc khi xảy ra lỗi, vui lòng thử lại sau.', 'error');
        console.log(error);
    });
}

function login(user){
    openLoadingAnimation();

    fetch('/bookstore/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user),
    })
    .then(response => {
	    const authorizationHeader = response.headers.get('Authorization');
	    
	    if(authorizationHeader){
			const token = authorizationHeader.split(' ')[1];
			localStorage.setItem('jwtToken', token);
		} else {
			console.error("Missing Authorization header in response.");
		}
	    
	    return response.json();
	})
    .then(status => {
        closeLoadingAnimation();

        if (status.success){
			openPopupNotify('Đăng nhập thành công', 
							'Chào mừng bạn đến với Bookstore, chúc bạn có một trải nghiệm thật tốt với dịch vụ của chúng tôi.', 
							'success');
            setLoginState();
            setViewsByAuthenticationState();
            setTimeout(() => {
				window.location.reload();
			}, 2000);
        } else {
            openPopupNotify('Đăng nhập thất bại!', 'Rất tiếc khi xảy ra lỗi, vui lòng thử lại sau.', 'error');
            console.log(status.message);
        }
    })
    .catch(error => {
        closeLoadingAnimation();
        openPopupNotify('Đăng nhập thất bại!', 'Rất tiếc khi xảy ra lỗi, vui lòng thử lại sau.', 'error');
        console.log(error);
    })
}

function logout(){
    openLoadingAnimation();
    const token = localStorage.getItem('jwtToken');
	
    fetch(`/bookstore/logout`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`
        }
    })
    .then(response => response.json())
    .then(status => {
        closeLoadingAnimation();

        if(status.success){
			openPopupNotify('Đăng xuất thành công!', 
							'Rất tiếc khi bạn rời đi, nếu có gì không hài lòng vui lòng cho chúng tôi biết hoặc liên hệ trợ giúp để được hướng dẫn.', 
							'success');
            setLogoutState();
            setViewsByAuthenticationState();
            setTimeout(() => {
				window.location.reload();
			}, 2000);
        } else {
            openPopupNotify('Đăng xuất thất bại!', 'Rất tiếc khi xảy ra lỗi, vui lòng thử lại sau.', 'error');
            console.log(status.message);
        }
    })
    .catch(error => {
        closeLoadingAnimation();
        openPopupNotify('Đăng xuất thất bại!', 'Rất tiếc khi xảy ra lỗi, vui lòng thử lại sau.', 'error');
        console.error(error);
    })
}

openLoadingAnimation();
setViewsByAuthenticationState();

function getQuantityCart() {
	fetch(`/bookstore/cart/quantity-cart`)
    .then(response => response.json())
    .then(status => {
        if(status.success){
			let quantityCart = parseInt(status.message);
			
			document.getElementById('quantity-cart-header').innerText = quantityCart;
        } else {
            console.log(status.message);
        }
    })
    .catch(error => {
        console.error(error);
    })
}

document.addEventListener('DOMContentLoaded', function(){
    // Check authentication state when user visit site
    authenticate();
    getQuantityCart();
});
