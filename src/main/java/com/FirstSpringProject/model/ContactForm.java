package com.FirstSpringProject.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sicluceatlux on 2017-05-26.
 * represents Contact Form
 */
@Entity
public class ContactForm implements Serializable{
	
	/**
	 * GUID
	 */
	private static final long serialVersionUID = -6355342476126435924L;
	/**
	 * contact form ID
	 */
	@Id
	@GeneratedValue
	private int contactFormId;
	@NotEmpty(message = "The Contact Form Subject must not be null.")
	/**
	 * subject
	 */
	private String contactFormSubject;
	@NotEmpty(message = "The article Contact Form Content must not be null.")
	/**
	 * content
	 */
	private String contactFormContent;
	/**
	 * state
	 */
	private String contactFormState;
	//@DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
	/**
	 * date of creation
	 */
	private String contactFormDate;
	
	/**
	 * customer
	 */
	@OneToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	/**
	 * getter for contact form ID
	 * @return contact form ID
	 */
	public int getContactFormId() {
		return contactFormId;
	}
	
	/**
	 * setter for contact form ID
	 * @param contactFormId ID of contact form
	 */
	public void setContactFormId(int contactFormId) {
		this.contactFormId = contactFormId;
	}
	
	/**
	 * getter for contact form subject
	 * @return subject
	 */
	public String getContactFormSubject() {
		return contactFormSubject;
	}
	
	/**
	 * setter for contact form subject
	 * @param contactFormSubject subject
	 */
	public void setContactFormSubject(String contactFormSubject) {
		this.contactFormSubject = contactFormSubject;
	}
	
	/**
	 * getter for content
	 * @return content
	 */
	public String getContactFormContent() {
		return contactFormContent;
	}
	
	/**
	 * setter for content
	 * @param contactFormContent content
	 */
	public void setContactFormContent(String contactFormContent) {
		this.contactFormContent = contactFormContent;
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
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	/**
	 * getter for creation date
	 * @return date of creation
	 */
	public String getContactFormDate() {
		return contactFormDate;
	}
	
	/**
	 * setter for creation date
	 * @param contactFormDate creation date
	 */
	public void setContactFormDate(String contactFormDate) {
		this.contactFormDate = contactFormDate;
	}
	
	/**
	 * getter for state
	 * @return state
	 */
	public String getContactFormState() {
		return contactFormState;
	}
	
	/**
	 * setter for state
	 * @param state state
	 */
	public void setContactFormState(String state) {
		this.contactFormState = state;
	}
}
