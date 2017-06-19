package com.FirstSpringProject.service.impl;


import com.FirstSpringProject.dao.CustomerOrderDao;
import com.FirstSpringProject.model.Cart;
import com.FirstSpringProject.model.CartItem;
import com.FirstSpringProject.model.CustomerOrder;
import com.FirstSpringProject.service.CartService;
import com.FirstSpringProject.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sicluceatlux on 2017-03-19.
 */
@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CartService cartService;

    public void addCustomerOrder(CustomerOrder customerOrder){

        customerOrderDao.addCustomerOrder(customerOrder);
    }

    public double getCustomerOrderGrandTotal(int cartId){

        double grandTotal=0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems){
            grandTotal += item.getTotalPrice();
        }

        return grandTotal;
    }
}
