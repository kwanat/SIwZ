<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>


<%@include file="/WEB-INF/views/templates/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Warehouse Master page</h1>

            <p class="lead">This is the warehouse master page!</p>
        </div>

        <c:if test="${pageContext.request.userPrincipal.name !=null}">
        <h2>
            Welcome:${pageContext.request.userPrincipal.name} | <a href="<c:url
                value="/j_spring_security_logout" />">Logout</a>
        </h2>
        </c:if>

        <h3>
            <a href="<c:url value="/warehouseMaster/warehouseInventory" />">Warehouse Inventory</a>
        </h3>

        <p>Here you can view, check and modify the Warehouses</p>

        <br>

        <h3>
            <a href="<c:url value="/warehouseMaster/articleInventory" />">Article Inventory</a>
        </h3>

        <p>Here you can view, check and modify the Articles</p>

        <br>

        <h3>
            <a href="<c:url value="/warehouseMaster/productInventory" />">Product Inventory</a>
        </h3>

        <p>Here you can view, check and modify all of the Products</p>
        <br>
        <br>

        <%@include file="/WEB-INF/views/templates/footer.jsp"%>
