
	<jsp:include page="header.jsp" />

	<title>Home</title>

	<div class="bg-theme">
		<div class="filter zerogrid">
			<h2 class="t-center">Find the news that interests you</h2>
			<div class="row">
				<div class="col-1-4">
					<div class="wrap-col">
						<span>Categories :</span><br/>
						<select id="select-categories">
							<option>--ALL--</option>
						</select>
					</div>
				</div>
				<%--<div class="col-1-4">--%>
					<%--<div class="wrap-col">--%>
						<%--<span>Modal :</span><br/>--%>
						<%--<select>--%>
							<%--<option>--ALL--</option>--%>
							<%--<option>Aston martin</option>--%>
							<%--<option>Audi</option>--%>
							<%--<option>Bentley</option>--%>
							<%--<option>Bmw</option>--%>
							<%--<option>Cadillac</option>--%>
							<%--<option>Chevrolet</option>--%>
							<%--<option>Citroen</option>--%>
							<%--<option>Dacia</option>--%>
							<%--<option>Dodge</option>--%>
							<%--<option>Ferrari</option>--%>
							<%--<option>Ford</option>--%>
							<%--<option>Gmc</option>--%>
							<%--<option>Hyundai</option>--%>
							<%--<option>Jaguar</option>--%>
							<%--<option>Lexus</option>--%>
						<%--</select>--%>
					<%--</div>--%>
				<%--</div>--%>
				<%--<div class="col-1-4">--%>
					<%--<div class="wrap-col">--%>
						<%--<span>Price :</span><br/>--%>
						<%--<select>--%>
							<%--<option>--ALL--</option>--%>
							<%--<option>0-1000</option>--%>
							<%--<option>1000-5000</option>--%>
							<%--<option>5000-10000</option>--%>
						<%--</select>--%>
					<%--</div>--%>
				<%--</div>--%>
				<div class="col-1-4">
					<div class="wrap-col">
						<br>
						<a class="button bt1" onclick="search_news_headers('newsId', '')">Search</a>
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
		<img src="/images/administration/arrow_down_40.png">
	</button>

	<script src="/js/index.js"></script>

	<jsp:include page="footer.jsp" />
