package com.FirstSpringProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sicluceatlux on 2017-03-16.
 *	Represents Cart
 */
@Entity public class Cart
		implements Serializable {
	
	/**
	 * GUID
	 */
	private static final long serialVersionUID = 6436753309515076359L;
	/**
	 * Cart ID
	 */
	@Id
	@GeneratedValue
	private int cartId;
	/**
	 * list of cart items
	 */
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CartItem> cartItems;
	/**
	 * customer
	 */
	@OneToOne
	@JoinColumn(name = "customerId")
	@JsonIgnore
	private Customer customer;
	/**
	 * total value of items
	 */
	private double grandTotal;
	
	/**
	 * getter for cart ID
	 * @return cart ID
	 */
	public int getCartId() {
		return cartId;
	}
	
	/**
	 * setter for cart ID
	 * @param cartId cart ID
	 */
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	/**
	 * getter for cart Items
	 * @return
	 */
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	
	/**
	 * setter for cart items
	 * @param cartItems list of cart Items
	 */
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	/**
	 * getter for customer
	 * @return customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * setter for customer
	 * @param customer customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	/**
	 * getter for grand total
	 * @return grand total
	 */
	public double getGrandTotal() {
		return grandTotal;
	}
	
	/**
	 * setter for grand total
	 * @param grandTotal grand total
	 */
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
}
