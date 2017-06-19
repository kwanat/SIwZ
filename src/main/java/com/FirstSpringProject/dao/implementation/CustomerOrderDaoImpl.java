package com.FirstSpringProject.dao.implementation;

import com.FirstSpringProject.dao.CustomerOrderDao;
import com.FirstSpringProject.model.CustomerOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sicluceatlux on 2017-03-19.
 * represents order data access object
 */
@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao {
	/**
	 * session factory
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * adding order
	 * @param customerOrder order
 	 */
	public void addCustomerOrder(CustomerOrder customerOrder){
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customerOrder);
		session.flush();
	}
	
}