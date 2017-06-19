package com.FirstSpringProject.dao.implementation;

import com.FirstSpringProject.dao.CustomerDao;
import com.FirstSpringProject.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by sicluceatlux on 2017-03-19.
 * represents customer data access object
 */
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
	/**
	 * session factory
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * adding customer
	 * @param customer customer
	 */
	public void addCustomer(Customer customer){
		Session session = sessionFactory.getCurrentSession();
		
		customer.getBillingAddress().setCustomer(customer);
		customer.getShippingAddress().setCustomer(customer);
		
		session.saveOrUpdate(customer);
		session.saveOrUpdate(customer.getBillingAddress());
		session.saveOrUpdate(customer.getShippingAddress());
		session.saveOrUpdate(customer.getManufacturer());
		
		Users newUser = new Users();
		newUser.setUsername(customer.getUsername());
		newUser.setPassword(customer.getPassword());
		newUser.setEnabled(false);
		newUser.setCustomerId(customer.getCustomerId());
		newUser.setManufacturerId(customer.getManufacturer().getManufacturerId());
		
		Authorities newAuthority = new Authorities();
		newAuthority.setUsername(customer.getUsername());
		newAuthority.setAuthority("ROLE_USER");
		
		session.saveOrUpdate(newUser);
		session.saveOrUpdate(newAuthority);
		Cart newCart = new Cart();
		newCart.setCustomer(customer);
		customer.setCart(newCart);
		session.saveOrUpdate(customer);
		session.saveOrUpdate(newCart);
		
		session.flush();
	}
	
	/**
	 * getting customer by ID
	 * @param customerId customer ID
	 * @return customer
	 */
	public Customer getCustomerById (int customerId){
		Session session = sessionFactory.getCurrentSession();
		return (Customer) session.get(Customer.class,customerId);
	}
	
	/**
	 * getting list of all customers
	 * @return list of all customers
	 */
	public List<Customer> getAllCustomers(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer");
		List<Customer> customerList = query.list();
		
		return customerList;
	}
	
	/**
	 * getting customer by uername
	 * @param username username
	 * @return customer
	 */
	public Customer getCustomerByUsername(String username){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer where username = ?");
		query.setString(0,username);
		
		return (Customer)query.uniqueResult();
	}
	
	public void editCustomer(Customer customer){
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
		session.flush();
	}
	
}

