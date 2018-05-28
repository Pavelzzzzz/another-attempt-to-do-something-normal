
	<jsp:include page="../header.jsp" />
	<title>Categories</title>

	<div class="bg-theme">
		<div class="filter zerogrid">
			<h2 class="t-center">Categories</h2>
			<div class="row">
				<div class="col-2-3">
					<div class="wrap-col">
						<span>Title :</span><br/>
						<input id="category-name" type="text" class="form-control" placeholder="Title"
							   autofocus="true"/>
					</div>
				</div>
				<div class="col-1-3">
					<div class="wrap-col">
						<br>
						<a class="button bt1" onclick="save_category()">Save</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--////////////////////////////////////Container-->
	<section id="container">
		<div class="wrap-container clearfix">
			<div id="main-content">
				<div class="wrap-box t-center" ><!--Start Box-->
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
										<th>Action</th>
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
		<img src="/images/arrow_down_40.png">
	</button>

	<script src="/js/editor/categories.js"></script>

	<jsp:include page="../footer.jsp" />
