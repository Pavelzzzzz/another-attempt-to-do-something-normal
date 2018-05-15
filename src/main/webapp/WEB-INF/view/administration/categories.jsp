
	<jsp:include page="../header.jsp" />
	<title>Categories</title>

	<!--////////////////////////////////////Container-->
	<section id="container">
		<div class="wrap-container clearfix">
			<div id="main-content">
				<div class="wrap-box t-center" ><!--Start Box-->
					<div class="header">
						<h4>Categories</h4>
					</div>
					<div class="t-left" style="background: #fff; box-shadow: 2px 2px 5px 0px rgba(0,0,0,0.3); margin:20px;">
						<%--<div class="row" >--%>
							<div class="item-info">
								<table id="tableOfCategories">
									<thead>
									<tr class="t-center">
										<th class=" filterable sortable table-sortable:numeric"
											onclick="set_data_and_load('categoryId', '')">
											CategoryId</th>
										<th class=" filterable sortable table-sortable:numeric"
											onclick="set_data_and_load('categoryName', '')">
											Name</th>
									</tr>
									</thead>
								</table>
							</div>
						<%--</div>--%>
					</div>
				</div>
			</div>
		</div>
	</section>

	<button style="display: block;  margin: 0 auto;" onclick="load_new_page()">
		<img src="/images/administration/arrow_down_40.png">
	</button>

	<script src="/js/administration/categories.js"></script>

	<jsp:include page="../footer.jsp" />
