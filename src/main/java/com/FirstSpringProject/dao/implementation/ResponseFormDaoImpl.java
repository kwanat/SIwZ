package com.FirstSpringProject.dao.implementation;

import com.FirstSpringProject.dao.ResponseFormDao;
import com.FirstSpringProject.model.ResponseForm;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by sicluceatlux on 2017-05-26.
 * represents response form data access object
 */
@Repository
@Transactional
public class ResponseFormDaoImpl implements ResponseFormDao{
	/**
	 * session factory
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * getting list of all response forms
	 * @return list of all response forms
	 */
	@Override public List<ResponseForm> getResponseFormList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ResponseForm order by responseFormDate desc");
		List<ResponseForm> ResponseFormList = query.list();
		session.flush();
		
		return ResponseFormList;	}
	
	/**
	 * getting response form by ID
	 * @param id response form ID
	 * @return response form
	 */
	@Override public ResponseForm getResponseFormById(int id) {
		Session session = sessionFactory.getCurrentSession();
		ResponseForm theArticle = (ResponseForm) session.get(ResponseForm.class, id);
		session.flush();
		
		return theArticle;
	}
	
	/**
	 * adding new response form
	 * @param responseForm response form
	 */
	@Override public void addResponseForm(ResponseForm responseForm) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(responseForm);
		session.flush();
	}
	
	/**
	 * deleting response form
	 * @param responseForm response form
	 */
	@Override public void deleteResponseForm(ResponseForm responseForm){
		Session session = sessionFactory.getCurrentSession();
		session.delete(responseForm);
		session.flush();
	}
	
}
