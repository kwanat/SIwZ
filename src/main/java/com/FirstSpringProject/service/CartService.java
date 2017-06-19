package com.FirstSpringProject.service;

import com.FirstSpringProject.model.Cart;

/**
 * Created by sicluceatlux on 2017-03-19.
 */
public interface CartService {

    Cart getCartById (int cartId);

    void update(Cart cart);
}
