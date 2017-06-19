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
            <h1>All Products</h1>

            <p class="lead">Checkout all the awesome products available now!</p>
        </div>

        <table id="pages" class="table table-striped table-hover">
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
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><img src="<c:url value="/resources/images/${product.productId}.png" />"
                             alt="image" style="width:30%" /></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productCondition}</td>
                    <td>${product.productPrice} PLN</td>
                    <td><a href="<spring:url value="/product/viewProduct/${product.productId}" />">
                        <span class="glyphicon glyphicon-info-sign"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

<%@include file="/WEB-INF/views/templates/footer.jsp"%>