package com.FirstSpringProject.service;

import com.FirstSpringProject.model.CustomerOrder;

/**
 * Created by sicluceatlux on 2017-03-19.
 */
public interface CustomerOrderService {

    void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderGrandTotal(int cartId);
}
