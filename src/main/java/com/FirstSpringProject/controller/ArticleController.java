package com.FirstSpringProject.controller;

import com.FirstSpringProject.model.Article;
import com.FirstSpringProject.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

/**
 * Created by sicluceatlux on 2017-04-24.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	
	@RequestMapping("/viewArticle/{articleId}")
	public String viewArticle(@PathVariable int articleId, Model model) throws
																		IOException {
		Article article=articleService.getArticleById(articleId);
		model.addAttribute("article",article);
		
		return "viewArticle";
	}
	
	@RequestMapping("/articleList/all")
	public String getArticles(Model model) {
		
		List<Article> articles = articleService.getArticleList();
		model.addAttribute("articles", articles);
		
		return "articleList";
	}
	
	@RequestMapping("/articleList")
	public String getArticleByCategory(@RequestParam(value = "searchCondition") String searchCondition, Model model) {
		
		List<Article> articles = articleService.getArticleList();
		model.addAttribute("articles", articles);
		model.addAttribute("searchCondition", searchCondition);
		
		return "articleList";
		
	}
}
