package com.FirstSpringProject.service.impl;

import com.FirstSpringProject.dao.ContactFormDao;
import com.FirstSpringProject.dao.implementation.ContactFormDaoImpl;
import com.FirstSpringProject.model.ContactForm;
import com.FirstSpringProject.service.ContactFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sicluceatlux on 2017-05-26.
 */
@Service
public class ContactFormServiceImpl implements ContactFormService {
	@Autowired private ContactFormDao contactFormDao;
	
	@Override public List<ContactForm> getContactFormList() {
		return contactFormDao.getContactFormList();
	}
	
	@Override public ContactForm getContactFormById(int id) {
		return contactFormDao.getContactFormById(id);
	}
	
	@Override public void addContactForm(ContactForm contactForm) {
		contactFormDao.addContactForm(contactForm);
	}
	
	@Override public void deleteContactForm(ContactForm contactForm) {
		contactFormDao.deleteContactForm(contactForm);
	}
}
