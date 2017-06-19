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
            <h1>Warehouse Products Page</h1>

            <p class="lead">This is the warehouse products page!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${warehouse.warehouseProducts}" var="product">
                <tr>
                    <td><img src="<c:url value="/resources/images/${product.productId}.png" />"
                             alt="image" style="width:15%"/></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productCondition}</td>
                    <td>${product.productPrice} PLN</td>
                    <td><a href="<spring:url value="/warehouseMaster/warehouseInventory/product/viewProduct/${product.productId}" />">
                        <span class="glyphicon glyphicon-info-sign"></span></a>
                        <a href="<spring:url
                        value="/warehouseMaster/warehouseInventory/product/deleteProduct/${product.productId}" />">
                            <span class="glyphicon glyphicon-remove"></span></a>
                        <a href="<spring:url
                        value="/warehouseMaster/warehouseInventory/product/editProduct/${product.productId}" />">
                            <span class="glyphicon glyphicon-pencil"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <a href="<spring:url value="/warehouseMaster/warehouseInventory/warehouse/${warehouse.warehouseId}/product/addProduct" />"
           class="btn btn-primary">Add Product</a>

        <%@include file="/WEB-INF/views/templates/footer.jsp" %>
