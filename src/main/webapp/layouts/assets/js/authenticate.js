const popup = document.getElementById('popup');
const popupContent = document.getElementById('popup-content');
const popupCloseButton = document.getElementById('popup-close-button');
const userControls = document.getElementById('user-controls');
const userButton = document.getElementById('user-button');
const userNav = document.getElementById('user-nav');
const logoutButton = document.getElementById('logout');
var authenticationState = false;

const formSignInHtml = `
    <div id="form-signin" class="form">
        <h2>Đăng nhập</h2>

        <form id="form-login" action="#" class="mt-4">
            <div class="input-box">
                <span class="label-error"></span>
                <input type="text" placeholder="Nhập username" id="username" name="username">
            </div>
            <div class="input-box">
                <span class="label-error"></span>
                <input type="password" placeholder="Nhập mật khẩu" id="password" name="password">
            </div>
            <div class="input-box button">
                <button type="submit">Đăng nhập</button>
            </div>
        </form>

        <h3 class="change-link m-0 pt-3 w-100 text-center">Bạn chưa có tài khoản? <span id="register-link" class="link ms-1">Đăng ký ngay</span></h3>
        <h3 class="change-link m-0 pt-2 w-100 text-center"><a href="" class="link">Quên mật khẩu</a></h3>
    </div>
`;

const formSignUpHtml = `
    <div id="form-signup" class="form">
        <h2>Đăng ký</h2>

        <form id="form-register" action="#" class="mt-4">
            <div class="input-box">
                <span class="label-error"></span>
                <input type="text" placeholder="Nhập username" id="username" name="username">
            </div>
            <div class="input-box">
                <span class="label-error"></span>
                <input type="text" placeholder="Nhập email của bạn" id="email" name="email">
            </div>
            <div class="input-box">
                <span class="label-error"></span>
                <input type="password" placeholder="Nhập mật khẩu của bạn" id="password" name="password">
            </div>
            <div class="input-box">
                <span class="label-error"></span>
                <input type="password" placeholder="Xác nhận lại mật khẩu" id="repeat-password" name="repeat-password">
            </div>
            <div class="policy">
                <input type="checkbox" aria-label="checkbox" name="policy" required>
                <h3 class="mb-0">Tôi đồng ý với mọi <a href="#">điều khoản và điều kiện</a></h3>
            </div>
            <div class="input-box button">
                <button type="submit">Đăng ký ngay</button>
            </div>
        </form>

        <h3 class="change-link m-0 pt-3 w-100 text-center">Bạn đã có tài khoản? <span id="login-link" class="link">Đăng nhập</span></h3>
    </div>
`;

function openPopup(content){
    popupContent.innerHTML = content;
    popup.style.display = 'block';
}

function closePopup(){
    popupContent.innerHTML = '';
    popup.style.display = 'none';
}

function closePopupListener(){
    popupCloseButton.addEventListener('click', function(){
        closePopup();
    });
}

function changeToRegister(){
    openPopup(formSignUpHtml);
    const loginLink = document.getElementById('login-link');

    loginLink.addEventListener('click', function(){
        changeToLogin();
    });

    validateRegister();
    closePopupListener();
}

function changeToLogin(){
    openPopup(formSignInHtml);
    const registerLink = document.getElementById('register-link');

    registerLink.addEventListener('click', function(){
        changeToRegister();
    });

    validateLogin();
    closePopupListener();
}

function loginViews(){
    authenticationState = true;
    closePopup();
    userControls.classList.add('login');
}

function logoutViews(){
    authenticationState = false;
    userControls.classList.remove('login');
}

function setViewsByAuthenticationState(){
	if (authenticationState){
        loginViews();

        logoutButton.addEventListener('click', function(){
			console.log('logout button');
            logout();       // Permit action logout if user has been authenticated
        });
    } else {
        logoutViews();

        userButton.addEventListener('click', function(){
            changeToLogin();    // Permit action login if user was not authenticated
        });      
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
            if(status.success){
				authenticationState = true;
				setViewsByAuthenticationState();
			} else {
				console.log(status.message);
        	}
        })
        .catch(error => {
            console.error(error);
        });
    } else {
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

    fetch('/bookstore/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user),
    })
    .then(response => response.json())
	.then(status => {
		if (status.success){
			alert('Đăng ký thành công!');
            viewSignIn();
		} else {
			alert(`Đăng ký thất bại! ${status.message}`);
		}
	})
    .catch(error => {
        console.log(error);
    });
}

function login(user){

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
        if (status.success){
            alert('Đăng nhập thành công!');
            loginViews();
        } else {
            logoutViews();
            alert(`Đăng nhập thất bại! ${status.message}`);
        }
    })
    .catch(error => {
        console.log(error);
    })
}

function logout(){
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
        if(status.success){
            localStorage.removeItem('jwtToken');
            alert('Đăng xuất thành công!');
            logoutViews();
        } else {
            alert(`Đăng xuất thất bại! ${ status.message }.`);
            loginViews();
        }
    })
    .catch(error => {
        console.error(error);
    })
}