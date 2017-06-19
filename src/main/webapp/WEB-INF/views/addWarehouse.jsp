<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/templates/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h2>Add Warehouse</h2>
            <p class="lead">Fill the below information to add a warehouse:</p>
        </div>

        <form:form
                action="${pageContext.request.contextPath}/warehouseMaster/warehouseInventory/addWarehouse"
                   method="post"
                   commandName="warehouse" enctype="form-data">
        <div class="form-group">
            <label for="warehouseName">Name: </label><form:errors path="warehouseName" cssStyle="color:#ff0000" />
            <form:input path="warehouseName" id="warehouseName" class="form-Control" />
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/warehouseMaster/warehouseInventory" />" class="btn btn-default">Cancel</a>
        </form:form>

<%@include file="/WEB-INF/views/templates/footer.jsp"%>