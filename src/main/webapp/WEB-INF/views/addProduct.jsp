<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h2>Add Product</h2>
            <p class="lead">Fill the below information to add a product:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/warehouseMaster/product/addProduct"
                   method="post"
                   commandName="product" enctype="multipart/form-data">
        <div class="form-group">
            <label for="name">Name</label><form:errors path="productName" cssStyle="color:#ff0000"/>
            <form:input path="productName" id="name" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="category">Category</label>
            <label
                    class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="Vegetable"
            />Vegetable</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="Fruit"
            />Fruit</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="Grain"
            />Grain</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="Preserves"
            />Preserves</label>
        </div>

        <div class="form-group">
            <label for="description">Description</label>
            <form:textarea path="productDescription" id="description" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="price">Price</label><form:errors path="productPrice" cssStyle="color:#ff0000"/>
            <form:input path="productPrice" id="price" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="condition">Condition</label>
            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" value="fresh"
            />Fresh</label>
            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" value="expired"
            />Expired</label>
        </div>
        <div class="form-group">
            <label for="status">Status</label>
            <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status"
                                                             value="active"/>Active</label>
            <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status"
                                                             value="inactive"/>Inactive</label>
        </div>
        <div class="form-group">
            <label for="unitInStock">Unit In Stock</label><form:errors path="unitInStock" cssStyle="color:#ff0000"/>
            <form:input path="unitInStock" id="unitInStock" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="manufacturer">Manufacturer</label>
            <form:errors path="productManufacturer" cssStyle="color:#ff0000"/>
            <form:select path="productManufacturer" id="manufacturer" class="form-Control">
                <c:forEach items="${manufacturerList.keySet()}" var="manufacturer">
                    <form:option value="${manufacturer}" label="${manufacturer}" />
                </c:forEach>
                <%--<form:options items="${manufacturerList}" />--%>
            </form:select>
        </div>
        <div class="form-group">
            <label for="warehouse">Warehouse</label>
            <form:errors path="warehouse" cssStyle="color:#ff0000"/>
            <form:select path="warehouse" id="warehouse" class="form-Control">
                <c:forEach items="${warehouses.keySet()}" var="warehouse">
                    <form:option value="${warehouse}" label="${warehouse}" />
                </c:forEach>

                <%--<form:options items="${warehouses}" itemLabel="" />--%>
            </form:select>
        </div>
        <div class="form-group">
            <label class="control-label" for="productImage">Upload Picture</label>
            <form:input id="productImage" path="productImage" type="file" class="form:input-large"/>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/warehouseMaster/productInventory" />" class="btn btn-default">Cancel</a>
        </form:form>

<%@include file="/WEB-INF/views/templates/footer.jsp" %>