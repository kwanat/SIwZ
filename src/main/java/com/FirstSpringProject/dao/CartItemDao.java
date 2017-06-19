package com.FirstSpringProject.dao;

import com.FirstSpringProject.model.Cart;
import com.FirstSpringProject.model.CartItem;

/**
 * Created by sicluceatlux on 2017-03-19.
 */
public interface CartItemDao {
	void addCartItem(CartItem cartItem);
	
	void removeCartItem(CartItem cartItem);
	
	void removeAllCartItems(Cart cart);
	
	CartItem getCartItemByProductId(int productId);
}
