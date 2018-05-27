document.addEventListener("DOMContentLoaded", set_data_and_load("categoryId", ""));

function set_data_and_load(param, order) {
  clearTable($("#tableOfCategories")[0]);
  var dataForLoad = {};
  dataForLoad["page"] = 0;
  dataForLoad["size"] = 5;
  dataForLoad["sort"] = param + ',' + order;
  sessionStorage.setItem("dataForLoad", JSON.stringify(dataForLoad));
  get_categories();
}

function load_new_page() {
  var dataForLoad = JSON.parse(sessionStorage.getItem("dataForLoad"));
  dataForLoad["page"] = dataForLoad.page + 1;
  sessionStorage.setItem("dataForLoad", JSON.stringify(dataForLoad));
    get_categories();
}

function update_category_by_id(categoryId) {
  var dataForCategoryUpdate = {};
  dataForCategoryUpdate["categoryId"] = categoryId;
  dataForCategoryUpdate["categoryName"] = $("#" + categoryId)[0]
  .querySelector('.input-categoryName').value;

  $.ajax({
    type: "POST",
    url: "/api/categories/" + categoryId,
    data: JSON.stringify(dataForCategoryUpdate),
    dataType: 'json',
    contentType: "application/json; charset=utf-8",
    success: function (data) {
      console.log("category " + categoryId + " is successfully updated");
    },
    error: function (error) {
      console.log("Error: " + error.status);
    }
  });
}

function delete_category_by_id(categoryId) {
  console.log("deleting category " + categoryId);

  $.ajax({
    type: "DELETE",
    url: "/api/categories/" + categoryId,
    success: function (data) {
      console.log("category " + categoryId + " is successfully deleted");
      clearTable($("#tableOfCategories")[0]);
      var dataForLoad = JSON.parse(sessionStorage.getItem("dataForLoad"));
      dataForLoad["page"] = 0;
      sessionStorage.setItem("dataForLoad", JSON.stringify(dataForLoad));
      get_categories();
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
    data: JSON.parse(sessionStorage.getItem("dataForLoad")),
    dataType: 'json',
    success: function (data) {
      if (data != "false") {
        //console.log(JSON.stringify(data));
        console.log(data);
        for (var i = 0; i < data.length; i++ ){
          $("#tableOfCategories").append('<tr id=' + data[i].categoryId + '>'
              + '<td>' + data[i].categoryId + '</td>'
              + '<td> <input class="input-categoryName" value="' + data[i].categoryName + '"></td>'
              + '<td>'
              +   '<button class="button-category-update" '
              +     'onclick="update_category_by_id(' + data[i].categoryId + ')">'
              +       '<img src="/images/save_16x16.png">'
              +   '<button class="button-category-delete" '
              +     'onclick="delete_category_by_id(' + data[i].categoryId + ')">'
              +       '<img src="/images/trash_empty_16x16.png">'
              +   '</button>'
              + '</td>'

              + '</tr>');
        }
      }
    },
    error: function (error) {
      console.log("Error: " + error.status);
    }
  });
}

function clearTable(table) {
  while (table.getElementsByTagName('tr').length > 1){
    table.deleteRow(1);
  }
  
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
        set_data_and_load("categoryId", "");
      }
    },
    error: function (error) {
      console.log("Error: " + error.status);
    }
  });
}