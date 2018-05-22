document.addEventListener("DOMContentLoaded", on_load());

function on_load() {
    $('#txtedit').Editor();
}

function save_news() {

    console.log("saving news");

    var saveNewsRequestBody = {};
    saveNewsRequestBody["languageId"] = 1;
    saveNewsRequestBody["categoryId"] = 1;
    saveNewsRequestBody["userId"] = 1;
    saveNewsRequestBody["title"] = "js test news";
    saveNewsRequestBody["htmlText"] = $('#txtedit').Editor("getText");

    $.ajax({
        type: "POST",
        url: "/api/news",
        data: saveNewsRequestBody,
        dataType: 'json',
        success: function (data) {
            alert(data);
        },
        error: function (error) {
            console.log("Error: " + error.status);
        }
    });
}