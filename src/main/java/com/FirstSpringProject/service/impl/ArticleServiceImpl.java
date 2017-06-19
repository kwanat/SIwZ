package com.FirstSpringProject.service.impl;

import com.FirstSpringProject.dao.ArticleDao;
import com.FirstSpringProject.model.Article;
import com.FirstSpringProject.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sicluceatlux on 2017-04-24.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired private ArticleDao articleDao;
	
	
	@Override public List<Article> getArticleList() {
		return articleDao.getArticleList();
	}
	
	@Override public Article getArticleById(int id) {
		return articleDao.getArticleById(id);
	}
	
	@Override public void addArticle(Article article) {
		articleDao.addArticle(article);
	}
	
	@Override public void editArticle(Article article) {
		articleDao.editArticle(article);
	}
	
	@Override public void deleteArticle(Article article) {
		articleDao.deleteArticle(article);
	}
}
