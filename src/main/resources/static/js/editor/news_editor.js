document.addEventListener("DOMContentLoaded", on_load());
document.addEventListener("DOMContentLoaded", get_categories());

function on_load() {
    $('#text-edit').Editor();
}

function save_news() {

    console.log("saving news");

    var saveNewsRequestBody = {};
    saveNewsRequestBody["languageId"] = 1;
    saveNewsRequestBody["categoryId"] = $("#select-categories")[0][
        $("#select-categories")[0].selectedIndex].id;
    saveNewsRequestBody["userId"] = 1;
    saveNewsRequestBody["title"] = $("#news-title")[0].value;
    saveNewsRequestBody["htmlText"] = $('#text-edit').Editor("getText");

    $.ajax({
        type: "POST",
        url: "/api/editor/news",
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

function get_categories() {
  console.log("loading categories");

  $.ajax({
    type: "GET",
    url: "/api/categories",
    dataType: 'json',
    success: function (data) {
      if (data != "false") {
        //console.log(JSON.stringify(data));
        console.log(data);
        for (var i = 0; i < data.length; i++ ){
          $("#select-categories").append('<option ' +
              'id="' + data[i].categoryId + '">' +
              data[i].categoryName +
              '</option>');
        }
      }
    },
    error: function (error) {
      console.log("Error: " + error.status);
    }
  });
}

function save_category() {
  console.log("save new category");

  var saveCategoryRequestBody = {};
  saveCategoryRequestBody["categoryName"] = $("#category-name")[0].value;

  $.ajax({
    type: "POST",
    url: "/api/categories",
    data: saveCategoryRequestBody,
    dataType: 'json',
    success: function (data) {
      if (data != "false") {
        //console.log(JSON.stringify(data));
        console.log(data);
        clearSelect($("#select-categories")[0]);
        $("#category-name")[0].value = null;
        get_categories();
      }
    },
    error: function (error) {
      console.log("Error: " + error.status);
    }
  });
}

function clearSelect(select) {
  while (select.options.length > 0) {
    select.remove(0);
  }
}