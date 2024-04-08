
document.addEventListener('DOMContentLoaded', function () {
    const token = localStorage.getItem('jwtToken');

    if(token){
        fetch(`/bookstore/authenticate`, {
            method: 'POST',
            headers: {
                'Authorization': `Bearer ${token}`
            }
        })
        .then(response => response.json())
        .then(status => {
            if(status.success){
                console.log('user is logged in');
            } else {
                console.log('use is not logged in');
            }
        })
        .catch(error => {
            console.error(error);
        });
    } else {
        console.log('Not found token! User is not logged in.');
    }
});