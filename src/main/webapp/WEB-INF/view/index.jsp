
	<jsp:include page="header.jsp" />

	<title>Home</title>

	<div class="bg-theme">
		<div class="filter zerogrid">
			<h2 class="t-center">Find the news that interests you</h2>
			<div class="row">
				<div class="col-1-3 f-right">
					<div class="col-1-2">
						<div class="wrap-col">
							<span>Categories :</span><br/>
							<select id="select-categories">
								<option>--ALL--</option>
							</select>
						</div>
					</div>
					<div class="col-1-2">
						<div class="wrap-col">
							<br>
							<a class="button bt1" onclick="search_news_headers('newsId', '')">Search</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--////////////////////////////////////Container-->
	<section id="container">
		<div class="wrap-container clearfix">
			<div id="main-content">
				<div class="wrap-box"><!--Start Box-->
					<div class="zerogrid">
						<div class="header">
							<h2>NEWS</h2>
						</div>
						<div id="news-headers-row"  class="row">

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<button style="display: block;  margin: 0 auto;" onclick="load_new_page()">
		<img src="/images/arrow_down_40.png">
	</button>

	<script src="/js/index.js"></script>

	<jsp:include page="footer.jsp" />
