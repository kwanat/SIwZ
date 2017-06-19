package com.FirstSpringProject.controller;

import com.FirstSpringProject.model.Article;
import com.FirstSpringProject.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by sicluceatlux on 2017-03-18.
 */
@Controller
public class HomeController {
	@Autowired private ArticleService articleService;
	
	@RequestMapping("/")
	public String home(Model model) {
		List<Article> articles = articleService.getArticleList().subList(0,3);
		model.addAttribute("articles", articles);
		return "home";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam(value="error", required = false) String error,@RequestParam(value="logout",required = false) String logout, Model model){
		if (error != null) {
			model.addAttribute("error", "Invalid username and password.");
		}
		
		if (logout !=null){
			model.addAttribute("msg", "You have been logged out successfully!");
		}
		
		return "login";
	}
}
