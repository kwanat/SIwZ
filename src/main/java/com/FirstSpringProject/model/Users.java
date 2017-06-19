package com.FirstSpringProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by sicluceatlux on 2017-03-18.
 * represents user
 */
@Entity public class Users {
	/**
	 * user ID
	 */
	@Id
	@GeneratedValue
	private int usersId;
	/**
	 * username
	 */
	private String username;
	/**
	 * password
	 */
	private String password;
	
	/**
	 * enabled
	 */
	private boolean enabled;
	/**
	 * customer ID
	 */
	private int customerId;
	/**
	 * manufacturer ID
	 */
	private int manufacturerId;
	
	/**
	 * getter for customer ID
	 * @return customer ID
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * setter for customer ID
	 * @param username
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
	 * @param password
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
	 * @param enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	/**
	 * getter for customer ID
	 * @return customer ID
	 */
	public int getCustomerId() {
		return customerId;
	}
	
	/**
	 * setter for customer ID
	 * @param customerId customer ID
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	/**
	 * getter for user ID
	 * @return
	 */
	public int getUsersId() {
		return usersId;
	}
	
	/**
	 * setter fo user ID
	 * @param usersId
	 */
	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}
	
	/**
	 * getter for manufacturer ID
	 * @return
	 */
	public int getManufacturerId() {
		return manufacturerId;
	}
	
	/**
	 * setter for manufacturer
	 * @param manufacturerId
	 */
	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}
}
