<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>

<script>
    $(document).ready(function () {

        $('.table').DataTable({
            "lengthMenu": [[10, 3, 5, 15, 20, -1], [10, 3, 5, 15, 20, "All"]]
        });
    });
</script>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Warehouse Inventory Page</h1>

            <p class="lead">This is the warehouse inventory page!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Warehouse ID</th>
                <th>Warehouse name</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${warehouses}" var="warehouse">
                <td>${warehouse.warehouseId}</td>
                    <td>${warehouse.warehouseName}</td>
                    <td><a href="<spring:url value="/viewWarehouse/${warehouse.warehouseId}" />">
                        <span class="glyphicon glyphicon-info-sign"></span></a>
                        <a href="<spring:url
                        value="/warehouseMaster/warehouseInventory/deleteWarehouse/${warehouse.warehouseId}"
                        />">
                            <span class="glyphicon glyphicon-remove"></span></a>
                        <a href="<spring:url value="/warehouseMaster/warehouseInventory/editWarehouse/${warehouse.warehouseId}" />">
                            <span class="glyphicon glyphicon-pencil"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="<spring:url value="/warehouseMaster/warehouseInventory/addWarehouse" />"
           class="btn btn-primary">Add
            Warehouse</a>

        <%@include file="/WEB-INF/views/templates/footer.jsp" %>
