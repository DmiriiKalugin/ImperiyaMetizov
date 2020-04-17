const email = document.getElementById('mail');
const name = document.getElementById('name');
const number = document.getElementById('number');
const error = document.querySelector('.error');
const clName = document.querySelector('.name');
const clEmail = document.querySelector('.email');
const clNumber = document.querySelector('.number');
const btnSubmit = document.getElementById('btn-submit')

name.addEventListener("input", function(event){
    if (name.validity.valid){
        clName.innerHTML = "";
        error.className = "error"; 
    }
},false);

email.addEventListener("input", function (event) {
    if (email.validity.valid) {
        clEmail.innerHTML = "";
        error.className = "error"; 
    }
}, false);

btnSubmit.addEventListener("click", function (event) {
    
    if (name.value == "") {
        clName.innerHTML = "это обязательное поле";
        error.className = "error active";
        event.preventDefault();
    }  else {
        clName.innerHTML = ""; 
        error.className = "error";
    }

    if (!name.validity.valid) {
        clName.innerHTML = "количество символов менее 2. введите коректное имя";
        error.className = "error active";

        event.preventDefault();
    }

    if (email.value == "") {
        clEmail.innerHTML = "это обязательное поле";
        error.className = "error active";

        event.preventDefault();
    }  else {
        clEmail.innerHTML = ""; 
        error.className = "error";
    }

    if (!email.validity.valid) {
        clEmail.innerHTML = "Некорректный email. Введите корректный адрес электронной почты.";
        error.className = "error active";

        event.preventDefault();
    }

    if (!number.validity.valid) {
        clNumber.innerHTML = "Некорректный номер, номер должен содержать 11 цифр.";
        error.className = "error active";

        event.preventDefault();
    }
} , false);

