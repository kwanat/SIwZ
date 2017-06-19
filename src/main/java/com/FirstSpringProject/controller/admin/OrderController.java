package com.FirstSpringProject.controller.admin;

import com.FirstSpringProject.model.Cart;
import com.FirstSpringProject.model.Customer;
import com.FirstSpringProject.model.CustomerOrder;
import com.FirstSpringProject.service.CartService;
import com.FirstSpringProject.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sicluceatlux on 2017-03-19.
 */
@Controller
public class OrderController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CustomerOrderService customerOrderService;
	
	@RequestMapping("/order/{cartId}")
	public String createOrder(@PathVariable(value = "cartId")int cartId){
		
		CustomerOrder customerOrder = new CustomerOrder();
		Cart cart= cartService.getCartById(cartId);
		customerOrder.setCart(cart);
		
		Customer customer = cart.getCustomer();
		customerOrder.setCustomer(customer);
		//System.out.println("customerId = "+ customer.getCustomerId());
		customerOrder.setBillingAddress(customer.getBillingAddress());
		customerOrder.setShipingAddress(customer.getShippingAddress());
		
		customerOrderService.addCustomerOrder(customerOrder);
		
		return "redirect:/checkout?cartId="+cartId;
	}
}
