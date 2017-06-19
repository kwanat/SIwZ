package com.FirstSpringProject.service.impl;

import com.FirstSpringProject.dao.CustomerDao;
import com.FirstSpringProject.model.Customer;
import com.FirstSpringProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sicluceatlux on 2017-03-19.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    public Customer getCustomerById(int customerId){
        return customerDao.getCustomerById(customerId);
    }

    public List<Customer> getAllCustomers(){
        return customerDao.getAllCustomers();
    }

    public Customer getCustomerByUsername(String username) {
        return customerDao.getCustomerByUsername(username);
    }
    
    public void editCustomer(Customer customer){
        customerDao.editCustomer(customer);
    }
}
