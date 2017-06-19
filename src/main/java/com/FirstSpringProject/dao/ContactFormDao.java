package com.FirstSpringProject.dao;

import com.FirstSpringProject.model.ContactForm;

import java.util.List;

/**
 * Created by sicluceatlux on 2017-05-26.
 */
public interface ContactFormDao {
	List<ContactForm> getContactFormList();
	ContactForm getContactFormById(int id);
	void addContactForm(ContactForm contactForm);
	void deleteContactForm(ContactForm contactForm);
}
