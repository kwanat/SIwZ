<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Contact</h1>

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <h3>Thank you for contacting us. Monitor your e-mail not to miss a reply!</h3>
            </c:if>
        </div>
    </div>