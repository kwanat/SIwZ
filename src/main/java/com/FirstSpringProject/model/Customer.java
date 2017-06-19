package com.FirstSpringProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sicluceatlux on 2017-03-18.
 * Represents Customer
 */
@Entity public class Customer
		implements Serializable {
	/**
	 * GUID
	 */
	private static final long serialVersionUID = 5138768437160627444L;
	/**
	 * Customer ID
	 */
	@Id
	@GeneratedValue
	private int customerId;
	/***
	 * Customer name
	 */
	@NotEmpty( message = "The customer name must not be null.")
	private String customerName;
	/***
	 * Customer email
	 */
	@NotEmpty(message = "The customer email must not be null.")
	private String customerEmail;
	/**
	 * Customer phone
	 */
	private String customerPhone;
	/**
	 * Customer username
	 */
	@NotEmpty (message = "The customer username must not be null.")
	private String username;
	/**
	 * Customer password
	 */
	@NotEmpty (message ="The customer password must not be null.")
	private String password;
	/**
	 * Customer enabled
	 */
	//@NotEmpty(message = "Your account is not confirmed. Please await for confirmation from our staff.")
	private boolean enabled;
	/**
	 * Customer Billing Address
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="billingAddressId")
	private BillingAddress billingAddress;
	/**
	 * Customer shipping address
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="shippingAddressId")
	private ShippingAddress shippingAddress;
	/**
	 * Customer cart
	 */
	@OneToOne
	@JoinColumn(name = "cartId")
	@JsonIgnore
	private Cart cart;
	/**
	 * Manufacturer
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "manufacturerId")
	private Manufacturer manufacturer;
	
	/**
	 * getter for customer ID
	 * @return customer ID
	 */
	public int getCustomerId() {
		return customerId;
	}
	
	/**
	 * setter for customer ID
	 * @param customerId
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	/**
	 * getter for customer name
	 * @return customer name
	 */
	public String getCustomerName() {
		return customerName;
	}
	
	/**
	 * setter for customer name
	 * @param customerName customer name
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	/**
	 * getter for customer email
	 * @return customer email
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}
	
	/**
	 * setter for customer email
	 * @param customerEmail
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	/**
	 * getter for customer phone
	 * @return customer phone
	 */
	public String getCustomerPhone() {
		return customerPhone;
	}
	
	/**
	 * setter for customer phone
	 * @param customerPhone customer phone
	 */
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	
	/**
	 * getter for customer username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * setter for customer username
	 * @param username username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * getter for password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * setter for password
	 * @param password password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * getter for enabled
	 * @return enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}
	
	/**
	 * setter for enabled
	 * @param enabled enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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
	 * @param billingAddress billing address
	 */
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	/**
	 * getter for shipping address
	 * @return shipping address
	 */
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}
	
	/**
	 * setter for shipping addres
	 * @param shippingAddress shipping addres
	 */
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
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
	 * getter for manufacturer
	 * @return manufacturer
	 */
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	
	/**
	 * setter for manufacturer
	 * @param manufacturer manufacturer
	 */
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
}
