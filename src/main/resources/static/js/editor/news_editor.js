document.addEventListener("DOMContentLoaded", on_load());

function on_load() {
  $('#text-edit').Editor();
  get_categories();
  var newsId = window.location.pathname.substring(20);
  if (newsId.length > 0){
    console.log("loading news " + newsId);
    $.ajax({
      type: "GET",
      url: "/api/editor/news/" + newsId,
      dataType: 'json',
      success: function (data) {
        if (data != "false") {
          //console.log(JSON.stringify(data));
          console.log(data);
          sessionStorage.setItem("news", JSON.stringify(data));
          $("#news-title")[0].value = data.title;
          $('#text-edit').Editor("setText", data.htmlArchitecture);
          var options = $("#select-categories")[0].getElementsByTagName('option');
          for(var i = 0; i < options.length; i++){
            if (options[i].id == data.categoryId){
              $("#select-categories")[0].selectedIndex = i;
              break;
            }
          }
          $('#button-save')[0].onclick = function () {
            update_news();
          }
        }
      },
      error: function (error) {
        console.log("Error: " + error.status);
      }
    });
  }
}

function save_news() {

    console.log("saving news");

    var saveNewsRequestBody = {};
    saveNewsRequestBody["languageId"] = 1;
    saveNewsRequestBody["categoryId"] = $("#select-categories")[0][
        $("#select-categories")[0].selectedIndex].id;
    saveNewsRequestBody["title"] = $("#news-title")[0].value;
    saveNewsRequestBody["htmlText"] = $('#text-edit').Editor("getText");

    $.ajax({
        type: "POST",
        url: "/api/editor/news",
        data: saveNewsRequestBody,
        dataType: 'json',
        success: function (data) {
          console.log("news " + data + " saved");
          window.location.replace("/news/"+data);
        },
        error: function (error) {
            console.log("Error: " + error.status);
        }
    });
}

function update_news() {

  console.log("updating news");

  var newsId = JSON.parse(sessionStorage.getItem("news")).newsId;
  var saveNewsRequestBody = {};
  saveNewsRequestBody["newsId"] = newsId;
  saveNewsRequestBody["languageId"] = JSON.parse(sessionStorage.getItem("news")).language.languageId;
  saveNewsRequestBody["categoryId"] = $("#select-categories")[0][
      $("#select-categories")[0].selectedIndex].id;
  saveNewsRequestBody["title"] = $("#news-title")[0].value;
  saveNewsRequestBody["htmlText"] = $('#text-edit').Editor("getText");

  $.ajax({
    type: "POST",
    url: "/api/editor/news/" + newsId,
    data: saveNewsRequestBody,
    dataType: 'json',
    success: function (data) {
      console.log("news " + data + " updated");
      window.location.replace("/news/"+data);
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
    async :false,
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