package com.FirstSpringProject.dao.implementation;

import com.FirstSpringProject.dao.ArticleDao;
import com.FirstSpringProject.model.Article;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sicluceatlux on 2017-04-24.
 * represents Article Data Access Object
 */
@Repository
@Transactional
public class ArticleDaoImpl implements ArticleDao {
	
	/**
	 * sessionFactory
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * getter for article list
	 * @return list of all articles
	 */
	@Override public List<Article> getArticleList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Article order by articleDate desc");
		List<Article> articleList = query.list();
		session.flush();
		
		return articleList;	}
	
	/**
	 * getter for artice
	 * @param id article ID
	 * @return article
	 */
	@Override public Article getArticleById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Article theArticle = (Article) session.get(Article.class, id);
		session.flush();
		
		return theArticle;
	}
	
	/**
	 * adding article to article list
	 * @param article article to be added
	 */
	@Override public void addArticle(Article article) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(article);
		session.flush();
	}
	
	/**
	 * editing article
	 * @param article article
	 */
	@Override public void editArticle(Article article) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(article);
		session.flush();
	}
	
	/**
	 * deleting article
	 * @param article article
	 */
	@Override public void deleteArticle(Article article) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(article);
		session.flush();
	}
}
