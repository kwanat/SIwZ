<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Contact</h1>

            <p class="lead">Contact us!</p>
        </div>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <br>
            <h3>Welcome:${pageContext.request.userPrincipal.name}</h3>
            <p>If You want to cancel your order You can contact us via contact form below. </p>
            <form:form action="${pageContext.request.contextPath}/contact/contactForm/addContactForm"
                       method="post"
                       commandName="contactForm">
                <div class="form-group">
                    <label for="contactFormSubject">Subject</label><form:errors path="contactFormSubject" cssStyle="color:#ff0000"/>
                    <form:input path="contactFormSubject" id="contactFormSubject" class="form-Control"/>
                </div>

                <div class="form-group">
                    <label for="contactFormContent">Content</label>
                    <form:textarea path="contactFormContent" id="contactFormContent" class="form-Control"/>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <form:input type="hidden" path="contactFormState" id="contactFormDate" class="form-Control"
                            value="Not Responded"/>
                <br>
                <input type="submit" value="submit" class="btn btn-default">
                <a href="<c:url value="/admin/contactFormsInventory" />" class="btn btn-default">Cancel</a>
            </form:form>
        </c:if>
    </div>