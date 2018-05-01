document.addEventListener("DOMContentLoaded", set_data_and_load("userId", ""));

function set_data_and_load(param, order) {
  clearTable($("#tableOfUsers")[0]);
  var dataForLoad = {};
  dataForLoad["page"] = 0;
  dataForLoad["size"] = 5;
  dataForLoad[param + "%" + order] = null;
  sessionStorage.setItem("dataForLoad", JSON.stringify(dataForLoad));
  get_users()
}

function load_new_page() {
  var dataForLoad = JSON.parse(sessionStorage.getItem("dataForLoad"));
  dataForLoad["page"] = dataForLoad.page + 1;
  sessionStorage.setItem("dataForLoad", JSON.stringify(dataForLoad));
  get_users();
}

function get_users() {
  console.log("loading users");

  $.ajax({
    type: "GET",
    url: "api/users",
    data: JSON.parse(sessionStorage.getItem("dataForLoad")),
    dataType: 'json',
    success: function (data) {
      if (data !== "false") {
        //console.log(JSON.stringify(data));
        console.log(data);
        for (var i = 0; i < data.length; i++ ){
          $("#tableOfUsers").append('<tr>'
              + '<td>' + data[i].username + '</td>'
              + '<td>' + data[i].email + '</td>'
              + '<td>' + data[i].enabled + '</td>'
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