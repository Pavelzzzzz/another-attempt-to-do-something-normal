
function delete_news_by_id(newsId) {
  console.log("deleting news " + newsId);

  $.ajax({
    type: "DELETE",
    url: "/api/editor/news/" + newsId,
    success: function (data) {
      console.log("news " + newsId + " is successfully deleted");
      window.location.replace("/");
    },
    error: function (error) {
      console.log("Error: " + error.status);
    }
  });
}