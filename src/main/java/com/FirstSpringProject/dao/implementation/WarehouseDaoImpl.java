package com.FirstSpringProject.dao.implementation;

import com.FirstSpringProject.dao.WarehouseDao;
import com.FirstSpringProject.model.Warehouse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sicluceatlux on 2017-04-29.
 * represents warehouse data access object
 */
@Repository @Transactional public class WarehouseDaoImpl
		implements WarehouseDao {
	/**
	 * session factory
	 */
	@Autowired private SessionFactory sessionFactory;
	
	/**
	 * getting warehouse by ID
	 * @param warehouseId warehouse ID
	 * @return warehouse
	 */
	@Override public Warehouse getWarehouseById(int warehouseId) {
		Session session = sessionFactory.getCurrentSession();
		return (Warehouse) session.get(Warehouse.class, warehouseId);
	}
	
	/**
	 * getting warehouse by name
	 * @param warehouseName
	 * @return warehouse
	 */
	@Override public Warehouse getWarehouseByName(String warehouseName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Warehouse where warehouseName = ?");
		query.setString(0, warehouseName);
		
		return (Warehouse) query.uniqueResult();
	}
	
	/**
	 * getting the list of all warehouses
	 * @return list of all warehouses
	 */
	@Override public List<Warehouse> getWarehouseList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Warehouse");
		List<Warehouse> articleList = query.list();
		session.flush();
		
		return articleList;
	}
	
	/**
	 * editing warehouse
	 * @param warehouse warehouse
	 */
	@Override public void editWarehouse(Warehouse warehouse) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(warehouse);
		session.flush();
	}
	
	/**
	 * adding new warehouse
	 * @param warehouse warehouse
	 */
	@Override public void addWarehouse(Warehouse warehouse) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(warehouse);
		session.flush();
	}
	
	/**
	 * deleting warehouse
	 * @param warehouse warehouse
	 */
	@Override public void deleteWarehouse(Warehouse warehouse) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(warehouse);
		session.flush();
	}
}
