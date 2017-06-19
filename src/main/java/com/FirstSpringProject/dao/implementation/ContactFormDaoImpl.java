package com.FirstSpringProject.dao.implementation;

import com.FirstSpringProject.dao.ContactFormDao;
import com.FirstSpringProject.model.ContactForm;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sicluceatlux on 2017-05-26.
 * represents contact dorm data access object
 */
@Repository
@Transactional
public class ContactFormDaoImpl implements ContactFormDao {
	/**
	 * session factory
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * getting contact form list
	 * @return list of all contact forms
	 */
	@Override public List<ContactForm> getContactFormList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ContactForm order by contactFormDate desc");
		List<ContactForm> contactFormList = query.list();
		session.flush();
		
		return contactFormList;	}
	
	/**
	 * getting contact form by ID
	 * @param id contact form ID
	 * @return contact form
	 */
	@Override public ContactForm getContactFormById(int id) {
		Session session = sessionFactory.getCurrentSession();
		ContactForm theArticle = (ContactForm) session.get(ContactForm.class, id);
		session.flush();
		
		return theArticle;
	}
	
	/**
	 * adding contact form
	 * @param contactForm contact form
	 */
	@Override public void addContactForm(ContactForm contactForm) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(contactForm);
		session.flush();
	}
	
	/**
	 * deleting contact form
	 * @param contactForm
	 */
	@Override public void deleteContactForm(ContactForm contactForm){
		Session session = sessionFactory.getCurrentSession();
		session.delete(contactForm);
		session.flush();
	}
}
