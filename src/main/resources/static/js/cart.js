const table = document.querySelector("#table-list");
const modal = document.querySelector(".modal");
const close = document.querySelector(".close");

table.addEventListener('click', toggleModal);

close.addEventListener('click', toggleModal);

function toggleModal(event) {
//    modal.classList.toggle("is-open");
    event.preventDefault();
    console.log("button");
}
