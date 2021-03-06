<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Edit Customer</h1>
            <p class="lead">Modify the information below:</p>
        </div>
        <h3>Basic Info</h3>
        <form:form action="${pageContext.request.contextPath}/admin/customerManagement/editCustomer" method="post"
                   commandName="customer">
            <form:hidden path="customerId" value="${customer.customerId}"/>
            <form:hidden path="cart.cartId" value="${customer.cart.cartId}"/>
        <div class="form-group">
            <label for="name">Name</label><br><form:errors cssStyle="color: red" path="customerName"/>
            <form:input path="customerName" id="name" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="email">Email</label><br><span style="color: red">${emailMsg}</span><form:errors
                cssStyle="color: red" path="customerEmail"/>
            <form:input path="customerEmail" id="email" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="phone">Phone</label>
            <form:input path="customerPhone" id="phone" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="username">Username</label><br><form:errors cssStyle="color: red" path="username"/>
            <span style="color: red">${usernameMsg}</span>
            <form:input path="username" id="username" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="password">Password</label><br><form:errors cssStyle="color: red" path="password"/>
            <form:password path="password" id="password" value="${customer.password}" class="form-Control"/>
        </div>

        <h3>Manufacturer Info</h3>

        <div class="form-group">
            <label for="manufacturerName">Manufacturer Name</label><br>
            <form:input path="manufacturer.manufacturerName" id="manufacturerName" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="manufacturerRegon">Manufacturer REGON</label><br>
            <form:input path="manufacturer.regon" id="manufacturerRegon" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="manufacturerNip">Manufacturer NIP</label><br>
            <form:input path="manufacturer.nip" id="manufacturerNip" class="form-Control"/>
        </div>

        <h3>Billing Address</h3>

        <div class="form-group">
            <label for="billingStreet">Street Name</label>
            <form:input path="billingAddress.streetName" id="billingStreet" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="billingApartmentNumber">Apartment Number</label>
            <form:input path="billingAddress.apartmentNumber" id="billingApartmentNumber" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="billingCity">City</label>
            <form:input path="billingAddress.city" id="billingCity" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="billingState">State</label>
            <form:input path="billingAddress.state" id="billingState" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="billingCountry">Country</label>
            <form:input path="billingAddress.country" id="billingCountry" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="billingZip">Zipcode</label>
            <form:input path="billingAddress.zipCode" id="billingZip" class="form-Control"/>
        </div>

        <h3>Shipping Address</h3>

        <div class="form-group">
            <label for="shippingStreet">Street Name</label>
            <form:input path="shippingAddress.streetName" id="shippingStreet" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="shippingApartmentNumber">Apartment Number</label>
            <form:input path="shippingAddress.apartmentNumber" id="shippingApartmentNumber" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="shippingCity">City</label>
            <form:input path="shippingAddress.city" id="shippingCity" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="shippingState">State</label>
            <form:input path="shippingAddress.state" id="shippingState" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="shippingCountry">Country</label>
            <form:input path="shippingAddress.country" id="shippingCountry" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="shippingZip">Zipcode</label>
            <form:input path="shippingAddress.zipCode" id="shippingZip" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="enabled">Enabled</label>
            <form:select path="enabled" id="enabled" class="form-Control">
                <form:option value="true" label="true"/>
                <form:option value="false" label="false"/>
            </form:select>
        </div>

        <br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/" />" class="btn btn-default">Cancel</a>
        </form:form>

<%@include file="/WEB-INF/views/templates/footer.jsp" %>