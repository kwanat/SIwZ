package com.FirstSpringProject.dao.implementation;

import com.FirstSpringProject.dao.ManufacturerDao;
import com.FirstSpringProject.model.Manufacturer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sicluceatlux on 2017-06-03.
 * represents manufacturer data access object
 */
@Repository
@Transactional
public class ManufacturerDaoImpl implements ManufacturerDao{
	/**
	 * session factory
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * getting manufacturer by ID
	 * @param manufacturerId manufacturer ID
	 * @return manufacturer
	 */
	@Override public Manufacturer getManufacturerById(int manufacturerId) {
		Session session = sessionFactory.getCurrentSession();
		return (Manufacturer) session.get(Manufacturer.class,manufacturerId);
	}
	
	/**
	 * getting list of all manufacturers
	 * @return list of all manufacturers
	 */
	@Override public List<Manufacturer> getAllManufacturers() {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Manufacturer");
		List<Manufacturer> manufacturerList = query.list();
		
		return manufacturerList;
	}
	
	/**
	 * getting manufacturer by name
	 * @param Name name
	 * @return manufacturer
	 */
	@Override public Manufacturer getManufacturerByName(String Name) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Manufacturer where manufacturerName = ?");
		query.setString(0,Name);
		
		return (Manufacturer)query.uniqueResult();
	}
}
