<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Respond to contact form</h1>

            <p class="lead">Use form below to send response</p>
        </div>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <br>
            <h3>Welcome:${pageContext.request.userPrincipal.name}</h3>
            <form:form
                    action="${pageContext.request.contextPath}/admin/responseFormsInventory/responseForm/addResponseForm/${contactForm.contactFormId}"
                    method="post"
                    commandName="responseForm">

                <div class="form-group">
                    <label for="responseFormSubject">Subject</label><form:errors path="responseFormSubject"
                                                                                cssStyle="color:#ff0000"/>
                    <form:input path="responseFormSubject" id="responseFormSubject" class="form-Control"/>
                </div>

                <div class="form-group">
                    <label for="responseFormContent">Content</label>
                    <form:textarea path="responseFormContent" id="responseFormContent" class="form-Control"/>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <form:input type="hidden" path="responseFormDate" id="responseFormDate" class="form-Control" value=""/>
                <br>
                <input type="submit" value="submit" class="btn btn-default">
                <a href="<c:url value="/admin/responseFormsInventory" />" class="btn btn-default">Cancel</a>
            </form:form>
        </c:if>
    </div>