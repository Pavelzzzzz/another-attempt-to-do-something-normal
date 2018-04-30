document.addEventListener("DOMContentLoaded", get_users(0));

function get_users(page) {
  console.log("click");
  var size = 1;
  var data = {};
  data['page'] = page;
  data['size'] = size;

  $.ajax({
    type: "GET",
    url: "api/users",
    data: data,
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