function demo(page) {
  console.log("click");
  var size = 6;

  var data = {};
  // addIfNotEmpty(data, 'model.modelName', $('#filter_models').find('li a.selected').text());
  // addIfNotEmpty(data, 'model.make.makeName', $('#filter_makes').find('li a.selected').text());
  // addIfNotEmpty(data, 'transmission.transmissionName', $('#filter_transmission').find('li a.selected').text());
  data['page'] = page;
  data['userId'] = ["", "decs"];
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
      }
    }
  });

}