package com.FirstSpringProject.model;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
/**
 * Created by sicluceatlux on 2017-03-18.
 * represents order
 */
@Entity public class CustomerOrder
		implements Serializable {
	/**
	 * GUID
	 */
	private static final long serialVersionUID = -8432272513657730874L;
	/**
	 * Order ID
	 */
	@Id
	@GeneratedValue
	private int customerOrderId;
	/**
	 * Cart
	 */
	@OneToOne
	@JoinColumn(name="cartId")
	private Cart cart;
	/**
	 * Customer
	 */
	@OneToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	/**
	 * billing address
	 */
	@OneToOne
	@JoinColumn(name="billingAddressId")
	private BillingAddress billingAddress;
	/**
	 * shipping address
	 */
	@OneToOne
	@JoinColumn(name="shippingAddressId")
	private ShippingAddress shipingAddress;
	
	/**
	 * getter for customer ID
	 * @return
	 */
	public int getCustomerOrderId() {
		return customerOrderId;
	}
	
	/**
	 * setter for customer ID
	 * @param customerOrderId
	 */
	public void setCustomerOrderId(int customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	
	/**
	 * getter for cart
	 * @return
	 */
	public Cart getCart() {
		return cart;
	}
	
	/**
	 * setter for cart
	 * @param cart
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
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
	 * getter for billing address
	 * @return billing address
	 */
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}
	
	/**
	 * setter for billing address
	 * @param billingAddress billing addres
	 */
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	/**
	 * getter for shipping address
	 * @return shipping address
	 */
	public ShippingAddress getShipingAddress() {
		return shipingAddress;
	}
	
	/**
	 * setter for shipping address
	 * @param shipingAddress shipping address
	 */
	public void setShipingAddress(ShippingAddress shipingAddress) {
		this.shipingAddress = shipingAddress;
	}
}
