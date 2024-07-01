
function login(user){
	fetch(BASE_URL + '/admin/login', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(user)
	})
	.then(response => {
		const authorizationHeader = response.headers.get('Authorization');
	    
	    if(authorizationHeader){
			const token = authorizationHeader.split(' ')[1];
			localStorage.setItem('AdminToken', token);
		} else {
			console.error("Missing Authorization header in response.");
		}
	    
	    return response.json();
	})
	.then(status => {
		if (status.success){
			openPopupNotify('Đăng nhập thành công', '', 'success');
			
			setTimeout(() => {
				window.location.href = BASE_URL + '/admin/dashboard';
			}, 1000);
		} else {
			openPopupNotify('Thất bại', status.message, 'error');
		}
	})
	.catch(error => {
        openPopupNotify('Thất bại', 'Rất tiếc khi có lỗi, vui lòng thử lại sau.', 'error');
		console.error(error);
	})
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

validateLogin();