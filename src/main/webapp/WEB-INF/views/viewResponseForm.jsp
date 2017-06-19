<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>${responseForm.responseFormSubject}</h1>
        </div>

        <div class="container" ng-app="cartApp">
            <div>
                <div class="col-md-5">
                    <p>Added on: ${responseForm.responseFormDate}</p>
                    <p>${responseForm.responseFormContent}</p>
                    <br>
                </div>
            </div>
        </div>
<%@include file="/WEB-INF/views/templates/footer.jsp" %>