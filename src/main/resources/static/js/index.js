document.addEventListener("DOMContentLoaded", set_data_and_load("newsId", ""));
document.addEventListener("DOMContentLoaded", get_categories());

function set_data_and_load(param, order) {
  clear_row($("#news-headers-row"));
  var dataForLoad = {};
  dataForLoad["page"] = 0;
  dataForLoad["size"] = 6;
  dataForLoad["sort"] = param + ',' + order;
  sessionStorage.setItem("dataForLoad", JSON.stringify(dataForLoad));
  get_news_headers();
}

function search_news_headers(param, order){
  clear_row($("#news-headers-row"));
  var dataForLoad = {};
  dataForLoad["page"] = 0;
  dataForLoad["size"] = 6;
  dataForLoad["sort"] = param + ',' + order;
  if($("#select-categories")[0].selectedIndex != 0){
    dataForLoad["tblAPICategoryEntity.categoryId"] = $("#select-categories")[0][
        $("#select-categories")[0].selectedIndex].id;
  }
  dataForLoad["sort"] = param + ',' + order;

  sessionStorage.setItem("dataForLoad", JSON.stringify(dataForLoad));
  get_news_headers();
}

function load_new_page() {
  var dataForLoad = JSON.parse(sessionStorage.getItem("dataForLoad"));
  dataForLoad["page"] = dataForLoad.page + 1;
  sessionStorage.setItem("dataForLoad", JSON.stringify(dataForLoad));
  get_news_headers();
}

function get_news_headers() {
  console.log("loading news_headers");

  $.ajax({
    type: "GET",
    url: "/api/news/headers",
    data: JSON.parse(sessionStorage.getItem("dataForLoad")),
    dataType: 'json',
    success: function (data) {
      if (data != "false") {
        //console.log(JSON.stringify(data));
        console.log(data);
        for (var i = 0; i < data.length; i++ ){
          $("#news-headers-row").append(
              '<div class="col-1-3">' +
                '<div class="wrap-col">' +
                  '<div class="item t-center">' +
                    '<div class="item-info">' +
                      '<a href="/news/' + data[i].newsId + '">' +
                          '<h3>' + data[i].title + '</h3></a>' +
                      '<p>Author: ' + data[i].createdBy.username + '</p>' +
                    '</div>' +
                  '</div>' +
                '</div>' +
              '</div>');
        }
      }
    },
    error: function (error) {
      console.log("Error: " + error.status);
    }
  });
}

function clear_row(row) {
  row.find('div').remove();
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