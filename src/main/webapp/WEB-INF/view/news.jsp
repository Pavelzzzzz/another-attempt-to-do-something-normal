
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
	<jsp:include page="header.jsp" />

	<title>${news.getTitle()}</title>

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
							<sec:authorize access="hasRole('User') or hasRole('Admin')">
								<div class="col-1-2">
									<a class="button bt1" href="/editor/news_editor/${news.getNewsId()}">Update</a>
								</div>
								<div class="col-1-2">
									<a class="button bt1" onclick="delete_news_by_id(${news.getNewsId()})">Delete</a>
								</div>
							</sec:authorize>
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

	<script src="/js/news.js"></script>

	<jsp:include page="footer.jsp" />
