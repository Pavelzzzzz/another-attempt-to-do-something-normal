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

function get_categories() {
  console.log("loading categories");

  $.ajax({
    type: "GET",
    url: "/api/administration/categories",
    data: JSON.parse(sessionStorage.getItem("dataForLoad")),
    dataType: 'json',
    success: function (data) {
      if (data != "false") {
        //console.log(JSON.stringify(data));
        console.log(data);
        for (var i = 0; i < data.length; i++ ){
          $("#tableOfCategories").append('<tr>'
              + '<td>' + data[i].categoryId + '</td>'
              + '<td>' + data[i].categoryName + '</td>'
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