package com.FirstSpringProject.dao.implementation;

import com.FirstSpringProject.dao.ProductDao;
import com.FirstSpringProject.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sicluceatlux on 2017-03-12.
 * represents poduct data access object
 */
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
	/**
	 * session factory
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * getting product by ID
	 * @param id product ID
	 * @return product
	 */
	public Product getProductById(int id){
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product)session.get(Product.class, id);
		session.flush();
		
		return product;
	}
	
	/**
	 * getting list of all products
	 * @return list of all products
	 */
	public List<Product> getProductList(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product");
		List<Product> productList = query.list();
		session.flush();
		
		return productList;
	}
	
	/**
	 * adding new product
	 * @param product product
	 */
	public void addProduct(Product product){
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
	}
	
	/**
	 * editing prooduct
	 * @param product product
	 */
	public void editProduct(Product product){
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
	}
	
	/**
	 * deleting product
	 * @param product product
	 */
	public void deleteProduct(Product product){
		Session session = sessionFactory.getCurrentSession();
		session.delete(product);
		session.flush();
	}
}