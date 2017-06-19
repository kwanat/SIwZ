<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>${contactForm.contactFormSubject}</h1>
        </div>

        <div class="container" ng-app="cartApp">
            <div>
                <div class="col-md-5">
                    <p>Added on: ${contactForm.contactFormDate}</p>
                    <p>${contactForm.contactFormContent}</p>
                    <br>
                    <a href="<spring:url
                        value="/admin/contactFormsInventory/contactForm/respondToContactForm/${contactForm.contactFormId}" />"
                       class="btn btn-primary">Respond</a>
                </div>
            </div>
        </div>
<%@include file="/WEB-INF/views/templates/footer.jsp" %>