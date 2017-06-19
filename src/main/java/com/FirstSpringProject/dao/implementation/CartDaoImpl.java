package com.FirstSpringProject.dao.implementation;

import com.FirstSpringProject.dao.CartDao;
import com.FirstSpringProject.model.Cart;
import com.FirstSpringProject.service.CustomerOrderService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import org.springframework.transaction.annotation.Transactional;
import java.io.IOException;

/**
 * Created by sicluceatlux on 2017-03-19.
 * represents Cart Data Access Object
 */
@Repository
@Transactional
public class CartDaoImpl implements CartDao {
	/**
	 * session factory
	 */
	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * customer order service
	 */
	@Autowired
	private CustomerOrderService customerOrderService;
	
	/**
	 * getter for cart by ID
	 * @param cartId cart ID
	 * @return cart
	 */
	public Cart getCartById (int cartId){
		Session session = sessionFactory.getCurrentSession();
		return (Cart) session.get(Cart.class,cartId);
	}
	
	/**
	 * updating cart
	 * @param cart cart
	 */
	public void update(Cart cart){
		int cartId = cart.getCartId();
		double grandtotal= customerOrderService.getCustomerOrderGrandTotal(cartId);
		cart.setGrandTotal(grandtotal);
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cart);
	}
	
	/**
	 * validating cart
	 * @param cartId cart
	 * @return cart
	 * @throws IOException cart is null
	 */
	public Cart validate(int cartId) throws IOException{
		System.out.println("validating!!!!!");
		Cart cart=getCartById(cartId);
		if(cart==null||cart.getCartItems().size()==0){
			System.out.println("exception!!!!");
			throw new IOException(cartId+"");
		}
		
		update(cart);
		System.out.println("validated___________");
		return cart;
	}
	
}
