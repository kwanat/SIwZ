<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer Detail</h1>

            <p class="lead">Here is the detail information of the customer!</p>
        </div>

        <div class="container" ng-app="cartApp">
            <div>
                <div class="col-md-5">
                    <h1>${customer.customerName}</h1>
                    <p>${customer.username}</p>
                    <p><strong>Email</strong>:${customer.customerEmail}</p>
                    <p><strong>Phone</strong>:${customer.customerPhone}</p>
                    <p><strong>Password</strong>:${customer.password}</p>

                    <h3><strong>Manufacturer detail</strong></h3>
                    <p>${customer.manufacturer.manufacturerName}</p>
                    <p><strong>REGON</strong>:${customer.manufacturer.regon}</p>
                    <p><strong>NIP</strong>:${customer.manufacturer.nip}</p>

                    <h3><strong>Billing Address detail</strong>
                    </h3>
                    <p><strong>Street name</strong>:${customer.billingAddress.streetName}</p>
                    <p><strong>City</strong>:${customer.billingAddress.city}</p>
                    <p><strong>Apartment</strong>:${customer.billingAddress.apartmentNumber}</p>
                    <p><strong>State</strong>:${customer.billingAddress.state}</p>
                    <p><strong>Country</strong>:${customer.billingAddress.country}</p>
                    <p><strong>Zipcode</strong>:${customer.billingAddress.zipCode}</p>

                    <h3><strong>Shipping Address detail</strong>
                    </h3>
                    <p><strong>Street name</strong>:${customer.shippingAddress.streetName}</p>
                    <p><strong>City</strong>:${customer.shippingAddress.city}</p>
                    <p><strong>Apartment</strong>:${customer.shippingAddress.apartmentNumber}</p>
                    <p><strong>State</strong>:${customer.shippingAddress.state}</p>
                    <p><strong>Country</strong>:${customer.shippingAddress.country}</p>
                    <p><strong>Zipcode</strong>:${customer.shippingAddress.zipCode}</p>

                    <h4>Enabled: ${customer.enabled}</h4>

                    <br>

                </div>
            </div>
        </div>
<%@include file="/WEB-INF/views/templates/footer.jsp" %>