package com.FirstSpringProject.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sicluceatlux on 2017-05-26.
 */
@Entity public class ResponseForm
		implements Serializable {
	
	/**
	 * GUID
	 */
	private static final long serialVersionUID = -2132090426844896621L;
	/**
	 * Response form ID
	 */
	@Id @GeneratedValue private int responseFormId;
	/**
	 * Subject
	 */
	@NotEmpty(message = "The Response Form Subject must not be null.") private String responseFormSubject;
	/**
	 * Content
	 */
	@NotEmpty(message = "The article Response Form Content must not be null.") private String responseFormContent;
	//@DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
	/**
	 * Creation date
	 */
	private String responseFormDate;
	
	/**
	 * Contact Form
	 */
	@OneToOne @JoinColumn(name = "contactFormId") private ContactForm contactForm;
	/**
	 * Customer
	 */
	@OneToOne @JoinColumn(name = "customerId") private Customer customer;
	/**
	 * User
	 */
	@OneToOne @JoinColumn(name = "userId") private Users user;
	
	/**
	 * getter for response form ID
	 *
	 * @return response form ID
	 */
	public int getResponseFormId() {
		return responseFormId;
	}
	
	/**
	 * setter for response form ID
	 *
	 * @param responseFormId ID of response form
	 */
	public void setResponseFormId(int responseFormId) {
		this.responseFormId = responseFormId;
	}
	
	/**
	 * getter for response form subject
	 *
	 * @return subject
	 */
	public String getResponseFormSubject() {
		return responseFormSubject;
	}
	
	/**
	 * setter for response form subject
	 *
	 * @param responseFormSubject subject
	 */
	public void setResponseFormSubject(String responseFormSubject) {
		this.responseFormSubject = responseFormSubject;
	}
	
	/**
	 * getter for content
	 *
	 * @return content
	 */
	public String getResponseFormContent() {
		return responseFormContent;
	}
	
	/**
	 * setter for content
	 *
	 * @param responseFormContent content
	 */
	public void setResponseFormContent(String responseFormContent) {
		this.responseFormContent = responseFormContent;
	}
	
	
	/**
	 * getter for creation date
	 *
	 * @return date of creation
	 */
	public String getResponseFormDate() {
		return responseFormDate;
	}
	
	/**
	 * setter for creation date
	 *
	 * @param responseFormDate creation date
	 */
	public void setResponseFormDate(String responseFormDate) {
		this.responseFormDate = responseFormDate;
	}
	
	/**
	 * getter for user
	 * @return user
	 */
	public Users getUser() {
		return user;
	}
	
	/**
	 * setter for user
	 * @param user user
	 */
	public void setUser(Users user) {
		this.user = user;
	}
	
	/**
	 * getter for contact form
	 * @return contact form
	 */
	public ContactForm getContactForm() {
		return contactForm;
	}
	
	/**
	 * getter setter for contact Form
	 * @param contactForm contact form
	 */
	public void setContactFormForm(ContactForm contactForm) {
		this.contactForm = contactForm;
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
	 * setter for contact form
	 * @param contactForm contact form
	 */
	public void setContactForm(ContactForm contactForm) {
		this.contactForm = contactForm;
	}
}
