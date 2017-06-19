package com.FirstSpringProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * Created by sicluceatlux on 2017-03-18.\
 * represents shipping address
 */
@Entity public class ShippingAddress
		implements Serializable {
	
	/**
	 * GUID
	 */
	private static final long serialVersionUID = 829963026083667444L;
	/**
	 * Shipping address ID
	 */
	@Id
	@GeneratedValue
	private int shippingAddressId;
	/**
	 * name of the street
	 */
	private String streetName;
	/**
	 * number of the apartment
	 */
	private String apartmentNumber;
	/**
	 * city name
	 */
	private String city;
	/**
	 * state name
	 */
	private String state;
	/**
	 * name of the country
	 */
	private String country;
	/**
	 * zipcode
	 */
	private String zipCode;
	/**
	 * customer tho which address is assigned
	 */
	@OneToOne
	private Customer customer;
	
	/**
	 * getter for shipping address ID
	 * @return shipping address ID
	 */
	public int getShippingAddressId() {
		return shippingAddressId;
	}
	
	/**
	 * setter for shipping address ID
	 * @param shippingAddressId
	 */
	public void setShippingAddressId(int shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}
	
	/**
	 * getter for street name
	 * @return street name
	 */
	public String getStreetName() {
		return streetName;
	}
	
	/**
	 * setter for street name
	 * @param streetName name of the street
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	/**
	 * getter for apartment number
	 * @return apartment number
	 */
	public String getApartmentNumber() {
		return apartmentNumber;
	}
	
	/**
	 * setter for apartment number
	 * @param apartmentNumber
	 */
	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	
	/**
	 * geter for city name
	 * @return city name
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * setter for city name
	 * @param city city name
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * getter for state name
	 * @return state name
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * setter for state name
	 * @param state state name
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * getter for country name
	 * @return country name
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * setter for country name
	 * @param country country name
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * getter for zipcode
	 * @return zipcode
	 */
	public String getZipCode() {
		return zipCode;
	}
	
	/**
	 * setter for zipcode
	 * @param zipCode zipcode
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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
	 * overridden toString() method
	 * @return string representation of Shipping Address
	 */
	@Override
	public String toString() {
		return "ShippingAddress{" +
				"streetName='" + streetName + '\'' +
				", apartmentNumber='" + apartmentNumber + '\'' +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", country='" + country + '\'' +
				", zipCode='" + zipCode + '\'' +
				", customer=" + customer +
				'}';
	}
}
