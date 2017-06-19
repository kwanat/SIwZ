<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<script>
    $(document).ready(function() {

        $('.table').DataTable({
            "lengthMenu" : [[10,3,5,15,20,-1], [10,3,5,15,20,"All"]]
        });
    });
</script>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Inventory Page</h1>

            <p class="lead">This is the product inventory page!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Name</th>
                <th>E-mail</th>
                <th>Username</th>
                <th>Phone</th>
                <th>Enabled</th>
                <th>Modify</th>
            </tr>
            </thead>
            <c:forEach items="${customerList}" var="customer">
                <tr>
                    <td>${customer.customerName}</td>
                    <td>${customer.customerEmail}</td>
                    <td>${customer.username}</td>
                    <td>${customer.customerPhone}</td>
                    <td>${customer.enabled}</td>
                    <td><a href="<spring:url value="/admin/customerManagement/viewCustomer/${customer.customerId}" />">
                        <span class="glyphicon glyphicon-info-sign"></span></a>
                        <a href="<spring:url value="/admin/customerManagement/editCustomer/${customer.customerId}" />">
                            <span class="glyphicon glyphicon-pencil"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br><br>

        <%@include file="/WEB-INF/views/templates/footer.jsp"%>
