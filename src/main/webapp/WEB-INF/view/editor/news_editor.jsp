    <jsp:include page="../header.jsp" />

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>News editor</title>


    <link href="/css/editor/editor.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
     <![endif]-->

    <div class="bg-theme">
        <div class="filter zerogrid">
            <h2 class="t-center">News editor</h2>
            <div class="row">
                <div class="col-1-3 f-right">
                    <div class="col-2-3">
                        <div class="wrap-col">
                            <span>Category name :</span><br/>
                            <input id="category-name" type="text" class="form-control" placeholder="Category name"
                                   autofocus="true"/>
                        </div>
                    </div>
                    <div class="col-1-3">
                        <div class="wrap-col">
                            <br/>
                            <a class="button bt1" onclick="save_category()">Save</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-2-3">
                    <div class="wrap-col">
                        <span>Title :</span><br/>
                        <input id="news-title" type="text" class="form-control" placeholder="Title"
                               autofocus="true"/>
                    </div>
                </div>
                <div class="col-1-3">
                    <div class="wrap-col">
                        <span>Categories :</span><br/>
                        <select id="select-categories">
                        </select>
                    </div>
                </div>
            </div>
        </div>
    </div>

  <section id="container">
      <div class="wrap-container clearfix">
          <div id="main-content">
              <div class="wrap-box t-center" ><!--Start Box-->
                  <div class="item-edit t-left">
                      <div class="row">
                          <div class="item-info item-info-edit">
                              <textarea id="text-edit"></textarea>
                          </div>
                          <a id="button-save" class="button bt1" onclick="save_news()">Save</a>
                      </div>
                  </div>
              </div>
          </div>
      </div>

  </section>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/js/editor/editor.js"></script>

    <script src="/js/editor/news_editor.js"></script>

    <jsp:include page="../footer.jsp" />

