package com.FirstSpringProject.service.impl;

import com.FirstSpringProject.dao.CartDao;
import com.FirstSpringProject.model.Cart;
import com.FirstSpringProject.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sicluceatlux on 2017-03-19.
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    public Cart getCartById(int cartId){
        return cartDao.getCartById(cartId);
    }

    public void update(Cart cart){
        cartDao.update(cart);
    }
}
