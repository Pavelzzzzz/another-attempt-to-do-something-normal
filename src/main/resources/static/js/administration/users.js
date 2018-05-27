document.addEventListener("DOMContentLoaded", set_data_and_load("userId", ""));

function set_data_and_load(param, order) {
  clearTable($("#tableOfUsers")[0]);
  var dataForLoad = {};
  dataForLoad["page"] = 0;
  dataForLoad["size"] = 5;
  dataForLoad["sort"] = param + ',' + order;
  sessionStorage.setItem("dataForLoad", JSON.stringify(dataForLoad));
  get_users();
}

function load_new_page() {
  var dataForLoad = JSON.parse(sessionStorage.getItem("dataForLoad"));
  dataForLoad["page"] = dataForLoad.page + 1;
  sessionStorage.setItem("dataForLoad", JSON.stringify(dataForLoad));
  get_users();
}

function update_user_by_id(userId) {
  var dataForUserUpdate = {};
  dataForUserUpdate["userId"] = userId;
  dataForUserUpdate["username"] = $("#" + userId)[0]
    .querySelector('.td-username').innerText;
  dataForUserUpdate["email"] = $("#" + userId)[0]
  .querySelector('.input-email').value;
  var authorities = [];
  if ($("#" + userId)[0].querySelector('.select-admin').selectedIndex == 0){
    authorities.push("Admin");
  }
  if ($("#" + userId)[0].querySelector('.select-user').selectedIndex == 0){
    authorities.push("User");
  }
  dataForUserUpdate["authorities"] = authorities;
  if($("#" + userId)[0].querySelector('.select-enabled').selectedIndex == 0){
    dataForUserUpdate["enabled"] = true;
  } else {
    dataForUserUpdate["enabled"] = false;
  }

  $.ajax({
    type: "POST",
    url: "/api/administration/users/" + userId,
    data: JSON.stringify(dataForUserUpdate),
    dataType: 'json',
    contentType: "application/json; charset=utf-8",
    success: function (data) {
      console.log("user " + userId + " is successfully updated");
    },
    error: function (error) {
      console.log("Error: " + error.status);
    }
  });
}

function delete_user_by_id(userId) {
  console.log("deleting user " + userId);

  $.ajax({
    type: "DELETE",
    url: "/api/administration/users/" + userId,
    success: function (data) {
      console.log("user " + userId + " is successfully deleted");
      clearTable($("#tableOfUsers")[0]);
      var dataForLoad = JSON.parse(sessionStorage.getItem("dataForLoad"));
      dataForLoad["page"] = 0;
      sessionStorage.setItem("dataForLoad", JSON.stringify(dataForLoad));
      get_users();
    },
    error: function (error) {
      console.log("Error: " + error.status);
    }
  });
}

function get_users() {
  console.log("loading users");

  var selectTrueFalseEnding =
      "<option>true</option>"
      + "<option selected='selected'>false</option>"
      + "</select>";

  $.ajax({
    type: "GET",
    url: "/api/administration/users",
    data: JSON.parse(sessionStorage.getItem("dataForLoad")),
    dataType: 'json',
    success: function (data) {
      if (data != "false") {
        //console.log(JSON.stringify(data));
        console.log(data);
        for (var i = 0; i < data.length; i++ ){
          var authoritiesForCurrentUser = {"Admin": false, "User": false};
          data[i].authorities.forEach(
              function authorities_processing(currentValue, index, array){
                authoritiesForCurrentUser[currentValue] = true;
          });
          $("#tableOfUsers").append('<tr id=' + data[i].userId + '>'
              + '<td class="td-username">' + data[i].username + '</td>'
              + '<td> <input class="input-email" type="email" value="' + data[i].email + '"></td>'
              + '<td> <select class="select-enabled"></select></td>'
              + '<td> <select class="select-admin"></select></td>'
              + '<td> <select class="select-user"></select></td>'
              + '<td>'
              + '<button class="button-user-update" '
              +   'onclick="update_user_by_id(' + data[i].userId + ')">'
              +     '<img src="/images/save_16x16.png">'
              +   '</button>'
              + '<button class="button-user-delete" '
              +   'onclick="delete_user_by_id(' + data[i].userId + ')">'
              +     '<img src="/images/trash_empty_16x16.png">'
              +   '</button>'
              + '</td>'
              + '</tr>');
          $("#" + data[i].userId )[0].querySelector('.select-enabled').add(
              new Option("true", "", false, data[i].enabled));
          $("#" + data[i].userId )[0].querySelector('.select-enabled').add(
              new Option("false", "", false, !data[i].enabled));
          $("#" + data[i].userId )[0].querySelector('.select-admin').add(
              new Option("true", "", false, authoritiesForCurrentUser["Admin"]));
          $("#" + data[i].userId )[0].querySelector('.select-admin').add(
              new Option("false", "", false, !authoritiesForCurrentUser["Admin"]));
          $("#" + data[i].userId )[0].querySelector('.select-user').add(
              new Option("true", "", false, authoritiesForCurrentUser["User"]));
          $("#" + data[i].userId )[0].querySelector('.select-user').add(
              new Option("false", "", false, !authoritiesForCurrentUser["User"]));
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