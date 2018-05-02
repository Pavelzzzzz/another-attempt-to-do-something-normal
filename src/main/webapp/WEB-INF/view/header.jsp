<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html lang="en"> 
	<head>

		<!-- Basic Page Needs
  ================================================== -->
		<meta charset="utf-8">

		<!-- Mobile Specific Metas
  ================================================== -->
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    
		<!-- CSS
  ================================================== -->
		<link rel="stylesheet" href="/css/style.css">

	</head>
	<body>
	<div class="wrap-body">

		<!--////////////////////////////////////Header-->
		<header class="bg-theme">
			<div class="wrap-header zerogrid">
				<div class="row">
					<div id="cssmenu">
						<ul>
							<li class='active'><a href="/">Home</a></li>
							<sec:authorize access="hasRole('Admin')">
								<li class='active'><a href="administration/users">Users</a></li>
							</sec:authorize>
							<li><a href="single.html">About</a></li>
							<li><a href="contact.html">Contact</a></li>
						</ul>
					</div>
					<a href='/' class="logo"><img src="/images/logo.png" /></a>
				</div>
			</div>

		</header>

	</div>

	<script src="/js/jquery-latest.min.js"></script>
	<script src="/js/script.js"></script>

	</body>

</html>