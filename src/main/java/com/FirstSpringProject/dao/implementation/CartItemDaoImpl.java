package com.FirstSpringProject.dao.implementation;

import com.FirstSpringProject.dao.CartItemDao;
import com.FirstSpringProject.model.Cart;
import com.FirstSpringProject.model.CartItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by sicluceatlux on 2017-03-19.
 * represents cart item data access object
 */
@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {
	/**
	 * session factory
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * adding new cart item
	 * @param cartItem cartitem
	 */
	public void addCartItem(CartItem cartItem){
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
		session.flush();
	}
	
	/**
	 * removing cart item
	 * @param cartItem cart item
	 */
	public void removeCartItem(CartItem cartItem){
		Session session = sessionFactory.getCurrentSession();
		session.delete(cartItem);
		session.flush();
	}
	
	/**
	 * removing all cart items
	 * @param cart cart
	 */
	public void removeAllCartItems(Cart cart){
		List<CartItem> cartItems = cart.getCartItems();
		for (CartItem item:cartItems){
			removeCartItem(item);
		}
	}
	
	/**
	 * getting cart item by product ID
	 * @param productId product ID
	 * @return cart item
	 */
	public CartItem getCartItemByProductId(int productId){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CartItem where productId=?");
		query.setInteger(0,productId);
		session.flush();
		
		return (CartItem) query.uniqueResult();
	}
}

