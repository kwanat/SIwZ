package com.FirstSpringProject.controller.admin;

import com.FirstSpringProject.model.*;
import com.FirstSpringProject.service.CartItemService;
import com.FirstSpringProject.service.CartService;
import com.FirstSpringProject.service.CustomerService;
import com.FirstSpringProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sicluceatlux on 2017-03-19.
 */
@Controller
@RequestMapping("/rest/cart")
public class CartResources {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/{cartId}")
	public @ResponseBody
	Cart getCartById(@PathVariable(value="cartId") int cartId){
		return cartService.getCartById(cartId);
	}
	
	@RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value= HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable(value = "productId") int productId, @AuthenticationPrincipal User activeUser){
		
		System.out.println("11111111");
		Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
		Cart cart = customer.getCart();
		Product product = productService.getProductById(productId);
		List<CartItem> cartItems = cart.getCartItems();
		
		System.out.println("22222222");
		
		for(int i=0; i<cartItems.size(); i++){
			if(product.getProductId()==cartItems.get(i).getProduct().getProductId()){
				CartItem cartItem = cartItems.get(i);
				cartItem.setQuantity(cartItem.getQuantity()+1);
				cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
				cartItemService.addCartItem(cartItem);
				return;
			}
		}
		System.out.println("33333333");
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
		cartItem.setCart(cart);
		cartItemService.addCartItem(cartItem);
		System.out.println("444444444");
	}
	
	@RequestMapping(value = "/remove/{productId}",method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable(value = "productId") int productId){
		CartItem cartItem = cartItemService.getCartItemByProductId(productId);
		cartItemService.removeCartItem(cartItem);
	}
	
	@RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void clearCart(@PathVariable(value = "cartId") int cartId){
		Cart cart = cartService.getCartById(cartId);
		cartItemService.removeAllCartItems(cart);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload.")
	public void handleClientErrors(Exception e){}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error buzhaobin.")
	public void handleServerErrors(Exception e){}
}
