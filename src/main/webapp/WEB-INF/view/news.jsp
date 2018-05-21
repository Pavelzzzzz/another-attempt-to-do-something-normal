
	<jsp:include page="header.jsp" />

	<title>${news.getTitle()}</title>

	<%--<div class="bg-theme">--%>
		<%--<div class="filter zerogrid">--%>
			<%--<h2 class="t-center">FIND CAR THAT YOU LOVE</h2>--%>
			<%--<div class="row">--%>
				<%--<div class="col-1-4">--%>
					<%--<div class="wrap-col">--%>
						<%--<span>Make :</span><br/>--%>
						<%--<select>--%>
							<%--<option>--ALL--</option>--%>
							<%--<option>Honda</option>--%>
							<%--<option>Infiniti</option>--%>
							<%--<option>Jeep</option>--%>
							<%--<option>Mercedes-Benz</option>--%>
							<%--<option>Volvo</option>--%>
						<%--</select>--%>
					<%--</div>--%>
				<%--</div>--%>
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
				<%--<div class="col-1-4">--%>
					<%--<div class="wrap-col">--%>
						<%--<br>--%>
						<%--<a href="#" class="button bt1">Search</a>--%>
					<%--</div>--%>
				<%--</div>--%>
			<%--</div>--%>
		<%--</div>--%>
	<%--</div>--%>

	<!--////////////////////////////////////Container-->
	<section id="container">
		<div class="wrap-container clearfix">
			<div id="main-content">
				<div class="zerogrid">
					<div class="row t-center">
						<div class="header col-2-3">
							<div class="news-header">
								<h4>${news.getTitle()}</h4>
							</div>
						</div>
						<div id="sidebar" class="col-1-3">
							<div class="wrap-col">
								<!---- Start Widget ---->
								<div class="widget">
									<div class="wid-header-information">
										<h6>Information</h6>
									</div>
									<div class="wid-content-information">
										<p>Author:  ${news.getCreatedBy().getUsername()}</p>
										<p>Renewed:  ${news.getUpdatedAt()}</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="t-center" ><!--Start Box-->
							<div class="t-left" style="background: #fff; box-shadow: 2px 2px 5px 0px rgba(0,0,0,0.3); margin:20px;">
								<div class="row" >
									<div class="item-news">
										${news.getHtmlArchitecture()}
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>



	<jsp:include page="footer.jsp" />
