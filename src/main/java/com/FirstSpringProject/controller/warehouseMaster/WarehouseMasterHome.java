package com.FirstSpringProject.controller.warehouseMaster;

import com.FirstSpringProject.model.Article;
import com.FirstSpringProject.model.Product;
import com.FirstSpringProject.model.Warehouse;
import com.FirstSpringProject.service.ArticleService;
import com.FirstSpringProject.service.ProductService;
import com.FirstSpringProject.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by sicluceatlux on 2017-03-18.
 */
@Controller
@RequestMapping("/warehouseMaster")
public class WarehouseMasterHome {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private WarehouseService warehouseService;
	
	
	@RequestMapping
	public String warehouseMasterPage(){
		return "warehouseMaster";
	}
	
	
	@RequestMapping("/articleInventory")
	public String articleInventory(Model model){
		List<Article> articles = articleService.getArticleList();
		model.addAttribute("articles",articles);
		
		return "articleInventory";
	}
	
	@RequestMapping("/warehouseInventory")
	public String warehouseInventory(Model model){
		List<Warehouse> warehouses = warehouseService.getWarehouseList();
		model.addAttribute("warehouses",warehouses);
		
		return "warehouseInventory";
	}
	
	@RequestMapping("/productInventory")
	public String productInventory(Model model){
		List<Product> products = productService.getProductList();
		model.addAttribute("products",products);
		
		return "productInventory";
	}

}