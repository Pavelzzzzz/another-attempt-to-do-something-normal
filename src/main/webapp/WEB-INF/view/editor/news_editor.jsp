
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>News editor</title>

    <jsp:include page="../header.jsp" />

    <!-- Bootstrap -->
    <%--<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
    <link href="/css/editor/editor.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->


  <section id="container">
      <div class="wrap-container clearfix">
          <div id="main-content">
              <div class="wrap-box t-center" ><!--Start Box-->
                  <div class="header">
                      <h2>News editor</h2>
                  </div>
                  <div class="t-left" style="background: #fff; box-shadow: 2px 2px 5px 0px rgba(0,0,0,0.3); margin:20px;">
                      <div class="row" >
                          <%--<div class="item-info" style="margin: 0 25px 10px;">--%>
                              <%--<textarea id="txtedit"></textarea>--%>
                          <%--</div>--%>
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

      <script>
        $('#txtedit').Editor();
      </script>

      <jsp:include page="../footer.jsp" />

