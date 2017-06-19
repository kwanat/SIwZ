package com.FirstSpringProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sicluceatlux on 2017-03-16.
 */
@Entity public class CartItem
		implements Serializable {
	
	/**
	 * GUID
	 */
	private static final long serialVersionUID = -3859888783517288880L;
	
	/**
	 * ID of cart item
	 */
	@Id
	@GeneratedValue
	private int cartItemId;
	/**
	 * cart
	 */
	@ManyToOne
	@JoinColumn(name="cartId")
	@JsonIgnore
	private Cart cart;
	/**
	 * product
	 */
	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;
	/**
	 * guantity
	 */
	private int quantity;
	/**
	 * total price quantity * product price
	 */
	private double totalPrice;
	
	/**
	 * getter for cart Item ID
	 * @return cart item ID
	 */
	public int getCartItemId() {
		return cartItemId;
	}
	
	/**
	 * setter for cart item ID
	 * @param cartItemId cart tem ID
	 */
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	
	/**
	 * getter for cart
	 * @return cart
	 */
	public Cart getCart() {
		return cart;
	}
	
	/**
	 * setter for cart
	 * @param cart cart
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	/**
	 * getter for cart
	 * @return cart
	 */
	public Product getProduct() {
		return product;
	}
	
	/**
	 * getter for product
	 * @param product product
 	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	
	/**
	 * getter for quantity
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * setter for quantity
	 * @param quantity quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * getter for total price
	 * @return total price
	 */
	public double getTotalPrice() {
		return totalPrice;
	}
	
	/**
	 * setter for total price
	 * @param totalPrice total price
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public CartItem() {
		this.quantity = 1;
	}

}
