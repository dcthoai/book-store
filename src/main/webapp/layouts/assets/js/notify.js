const popupNotify = document.getElementById('notify');
const popupTitle = document.getElementById('notify-title');
const popupMessage = document.getElementById('notify-message');
const popupNotifyCloseButton = document.getElementById('notify-close-button');
var closeNotifyTimeOut;

function openPopupNotify(title, message, status){
    popupNotify.style.animation = 'appearNotify 0.75s ease forwards';
    popupNotify.className = '';
    popupNotify.classList.add(status);
    popupTitle.innerHTML = title;
    popupMessage.innerHTML = message;

    closeNotifyTimeOut = setTimeout(function(){
        closePopupNotify();
    }, 5000);
}

function closePopupNotify(){
    popupNotify.style.animation = 'hideNotify 0.75s ease forwards';
    
    setTimeout(function(){
		popupNotify.style.animation = '';
		popupNotify.className = '';
        popupTitle.innerHTML = '';
        popupMessage.innerHTML = '';
        
        clearTimeout(closeNotifyTimeOut);
	}, 750);
}

popupNotifyCloseButton.addEventListener('click', function(){
    const iconClose = popupNotifyCloseButton.querySelector('i.fa-xmark');
    iconClose.style.animation = 'closeNotify 0.5s ease forwards';
    closePopupNotify();
    
    setTimeout(function(){
        iconClose.style.animation = '';
    }, 500);
});