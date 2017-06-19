<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container-wrapper">
    <div class="login-container">
        <div id="login-box">
            <h2>Login with Username and password</h2>

            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>

            <form name="loginForm" action="<c:url value="/j_spring_security_check" />" method="post">
                <c:if test="${not empty error}">
                    <div class="error" style="color:#ff0000">${error}</div>
                </c:if>
                <div class="form-group">
                    <label for="username">User:</label>
                    <input type="text" id="username" name="username" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" class="form-control" />
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

                <input type="submit" value="Login" class="btn btn-default">


            </form>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/templates/footer.jsp"%>