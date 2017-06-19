package com.FirstSpringProject.service;

import com.FirstSpringProject.model.Customer;

import java.util.List;

/**
 * Created by sicluceatlux on 2017-03-19.
 */
public interface CustomerService {
    void addCustomer (Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);
    
    void editCustomer(Customer customer);
}
