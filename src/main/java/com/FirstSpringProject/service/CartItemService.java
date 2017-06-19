package com.FirstSpringProject.service;

import com.FirstSpringProject.model.Cart;
import com.FirstSpringProject.model.CartItem;

/**
 * Created by sicluceatlux on 2017-03-19.
 */
public interface CartItemService {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int productId);
}
