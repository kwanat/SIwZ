package com.FirstSpringProject.dao;

import com.FirstSpringProject.model.Article;

import java.util.List;

/**
 * Created by sicluceatlux on 2017-04-24.
 */
public interface ArticleDao {
	
	List<Article> getArticleList();
	Article getArticleById(int id);
	void addArticle(Article article);
	void editArticle(Article article);
	void deleteArticle(Article article);
}
