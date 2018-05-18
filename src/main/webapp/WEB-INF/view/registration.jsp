<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<jsp:include page="header.jsp" />

<title>Registration</title>

<!--////////////////////////////////////Container-->
<section id="container">
	<form:form method="POST" modelAttribute="userForm" class="form-signin">
		<div class="wrap-container clearfix">
			<div id="main-content">
				<div class="wrap-box t-center"><!--Start Box-->
					<div id="contact_form">
						<div class="registration-header">
							<h5>Registration</h5>
						</div>
						<form name="form1" id="ff">

							<spring:bind path="username">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<form:input type="text" path="username" class="form-control" name="username" id="username" placeholder="Enter username" required="required" autofocus="true"></form:input>
									<form:errors path="username"></form:errors>
								</div>
							</spring:bind>

							<spring:bind path="email">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<form:input type="email" path="email" class="form-control" name="email" id="email" placeholder="Enter email" required="required"></form:input>
									<form:errors path="email"></form:errors>
								</div>
							</spring:bind>

							<spring:bind path="password">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<form:input type="password" path="password" class="form-control" name="password" id="password" placeholder="Enter password" required="required"></form:input>
									<form:errors path="password"></form:errors>
								</div>
							</spring:bind>

							<spring:bind path="passwordConfirm">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<form:input type="password" path="passwordConfirm" class="form-control" name="password" id="password2" placeholder="Confirm your password" required="required"></form:input>

									<form:errors path="passwordConfirm"></form:errors>
								</div>
							</spring:bind>
							<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
								<%--<input class="sendButton" type="submit" value="Sign up">--%>
						</form>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</section>

<jsp:include page="footer.jsp" />