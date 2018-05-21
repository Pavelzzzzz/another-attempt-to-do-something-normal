<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<jsp:include page="header.jsp" />

<title>Login</title>

<!--////////////////////////////////////Container-->
<section id="container">
    <form method="POST" action="${contextPath}/login" class="form-signin">
        <div class="wrap-container clearfix">
            <div id="main-content">
                <div class="wrap-box t-center"><!--Start Box-->
                    <div class="zerogrid">
                        <div class="row">
                            <div id="contact_form" class="col-2-4">
                                <div class="registration-header">
                                    <h5>Log in</h5>
                                </div>
                                <form name="form1" id="ff">
                                    <div class="form-group ${error != null ? 'has-error' : ''}">
                                        <span>${message}</span>
                                        <input name="username" type="text" class="form-control" placeholder="Username"
                                               autofocus="true"/>
                                        <input name="password" type="password" class="form-control" placeholder="Password"/>
                                        <span>${error}</span>
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                                        <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</section>

<jsp:include page="footer.jsp" />