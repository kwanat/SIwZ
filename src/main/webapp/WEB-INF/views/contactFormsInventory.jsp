<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<script>
    $(document).ready(function() {
        var searchCondition = '${searchCondition}';

        $('.table').DataTable({
            "lengthMenu" : [[10,2,3,5,15,20,-1], [10,2,3,5,15,20,"All"]],
            "oSearch" : {"sSearch" : searchCondition}
        });
    });
</script>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Contact Forms</h1>

            <p class="lead">Here you can see all contact forms</p>
        </div>

        <table id="pages" class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Subject</th>
                <th>Added on</th>
                <th>State</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${contactForms}" var="contactForm">
                <tr>
                    <td>${contactForm.contactFormSubject}</td>
                    <td>${contactForm.contactFormDate}</td>
                    <td>${contactForm.contactFormState}</td>
                    <td><a href="<spring:url value="/admin/contactForm/viewContactForm/${contactForm.contactFormId}"
                    />">
                        <span class="glyphicon glyphicon-info-sign"></span></a>
                        <a href="<spring:url
                        value="/admin/contactFormsInventory/contactForm/deleteContactForm/${contactForm.contactFormId}" />">
                            <span class="glyphicon glyphicon-remove"></span></a>
                        <a href="<spring:url
                        value="/admin/responseFormsInventory/responseForm/addResponseForm/${contactForm.contactFormId}"
                        />">
                            <span class="glyphicon glyphicon-envelope"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <a href="<spring:url value="/admin" />" class="btn btn-primary">Back to the admin page</a>

<%@include file="/WEB-INF/views/templates/footer.jsp"%>