<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
	<head>
		<title>Users</title>

		<jsp:include page="../header.jsp" />
	</head>

	<body>

	<!--////////////////////////////////////Container-->
	<section id="container">
		<div class="wrap-container clearfix">
			<div id="main-content">
				<div class="wrap-box t-center" ><!--Start Box-->
					<div class="header">
						<h2>Users</h2>
					</div>
					<div class="t-left" style="background: #fff; box-shadow: 2px 2px 5px 0px rgba(0,0,0,0.3); margin:20px;">
						<div class="row" >
							<div class="item-info">
								<table id="tableOfUsers">
									<thead>
									<tr class="t-center">
										<th class=" filterable sortable table-sortable:numeric"
											onclick="set_data_and_load('username', '')">
											Username</th>
										<th class=" filterable sortable table-sortable:numeric"
											onclick="set_data_and_load('email', '')">
											Email</th>
										<th class=" filterable sortable table-sortable:numeric"
											onclick="set_data_and_load('enabled', '')">
											Enabled</th>
									</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<button style="display: block;  margin: 0 auto;" onclick="load_new_page()">
		<img src="/images/arrow_down_40.png">
	</button>

	<jsp:include page="../footer.jsp" />

	<script src="/js/users.js"></script>

	</body>
</html>