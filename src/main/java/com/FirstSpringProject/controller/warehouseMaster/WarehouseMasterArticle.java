package com.FirstSpringProject.controller.warehouseMaster;

import com.FirstSpringProject.model.Article;
import com.FirstSpringProject.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.System.currentTimeMillis;

/**
 * Created by sicluceatlux on 2017-04-24.
 */
@Controller
@RequestMapping("/warehouseMaster/articleInventory")
public class WarehouseMasterArticle {
	
	private Path path;
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/article/addArticle")
	public String addArticle(Model model){
		Date date = new Date();
		Article article = new Article(date.toString());
		
		model.addAttribute("article", article);
		
		return "addArticle";
	}
	
	@RequestMapping(value="/article/addArticle", method = RequestMethod.POST)
	public String addArticlePost(@Valid @ModelAttribute("article") Article article,
								 BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()){
			return "addArticle";
		}
		
		articleService.addArticle(article);
		
		MultipartFile articleImage = article.getArticleImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\article\\"+article.getArticleId()+".png");
		
		if (articleImage != null && !articleImage.isEmpty()){
			try {
				articleImage.transferTo(new File(path.toString()));
			} catch (Exception e){
				e.printStackTrace();
				throw new RuntimeException("Article image saving failed.", e);
			}
		}
		return "redirect:/warehouseMaster/articleInventory";
	}
	
	@RequestMapping("/article/editArticle/{id}")
	public String editArticle(@PathVariable("id") int id, Model model){
		Article article = articleService.getArticleById(id);
		
		
		model.addAttribute("article", article);
		
		return "editArticle";
	}
	
	@RequestMapping(value="/article/editArticle", method = RequestMethod.POST)
	public String editArticlePost(@Valid @ModelAttribute("article") Article article,
								  BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()){
			return "editArticle";
		}
		
		
		MultipartFile articleImage = article.getArticleImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\article\\"+article.getArticleId()+".png");
		
		if (articleImage != null && !articleImage.isEmpty()){
			try {
				articleImage.transferTo(new File(path.toString()));
			} catch (Exception e){
				e.printStackTrace();
				throw new RuntimeException("Article image saving failed.", e);
			}
		}
		
		articleService.editArticle(article);
		
		return "redirect:/warehouseMaster/articleInventory";
	}
	
	@RequestMapping("/article/deleteArticle/{id}")
	public String deleteArticle(@PathVariable int id,Model model,HttpServletRequest request){
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory+ "\\WEB-INF\\resources\\images\\article\\"+id+".png");
		
		if(Files.exists(path)){
			try{
				Files.delete(path);
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		Article article = articleService.getArticleById(id);
		articleService.deleteArticle(article);
		
		return "redirect:/warehouseMaster/articleInventory";
	}
}
