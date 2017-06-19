<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h2>Edit Article</h2>
            <p class="lead">Fill the below information to edit an Article:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/warehouseMaster/warehouseInventory/editWarehouse"
                   method="post" commandName="warehouse">
            <form:hidden path="warehouseId" value="${warehouse.warehouseId}"/>
        <div class="form-group">
            <label for="warehouseName">Name: </label><form:errors path="warehouseName" cssStyle="color:#ff0000"/>
            <form:input path="warehouseName" id="warehouseName" class="form-Control" value="${warehouse.warehouseName}"/>
        </div>

        <br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/warehouseMaster/articleInventory" />" class="btn btn-default">Cancel</a>
        </form:form>

<%@include file="/WEB-INF/views/templates/footer.jsp" %>