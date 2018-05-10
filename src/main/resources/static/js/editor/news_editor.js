document.addEventListener("DOMContentLoaded", on_load());

function on_load() {
    $('#txtedit').Editor();
}

function save_news() {
    $('#container').append(
        $('#txtedit').Editor("getText")
    );
}