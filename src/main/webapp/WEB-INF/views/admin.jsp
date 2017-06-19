<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>


<%@include file="/WEB-INF/views/templates/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator page</h1>

            <p class="lead">This is the administrator page!</p>
        </div>

        <c:if test="${pageContext.request.userPrincipal.name !=null}">
        <h2>
            Welcome:${pageContext.request.userPrincipal.name} | <a href="<c:url
                value="/j_spring_security_logout" />">Logout</a>
        </h2>
        </c:if>

        <br>

        <h3>
            <a href="<c:url value="/admin/customerManagement" />">Customer Management</a>
        </h3>

        <p>Here you can manage Customer List</p>


        <h3>
            <a href="<c:url value="/admin/contactFormsInventory" />">Contact Forms Management</a>
        </h3>
        <p>Here you can manage contact forms</p>
        <h3>
            <a href="<c:url value="/admin/responseFormsInventory" />">Response Forms Management</a>
        </h3>

        <p>Here you can manage response forms</p>
        <br>
        <br>

        <%@include file="/WEB-INF/views/templates/footer.jsp"%>
