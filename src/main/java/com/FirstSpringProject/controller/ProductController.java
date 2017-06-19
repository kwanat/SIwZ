package com.FirstSpringProject.controller;

import com.FirstSpringProject.model.Product;
import com.FirstSpringProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

/**
 * Created by sicluceatlux on 2017-03-18.
 */
@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/viewProduct/{productId}")
	public String viewProduct(@PathVariable int productId, Model model) throws
																		IOException {
		Product product=productService.getProductById(productId);
		model.addAttribute("product",product);
		
		return "viewProduct";
	}
	
	@RequestMapping("/productList/all")
	public String getProducts(Model model) {
		
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		
		return "productList";
	}
	
	@RequestMapping("/productList")
	public String getProductByCategory(@RequestParam(value = "searchCondition") String searchCondition, Model model) {
		
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		model.addAttribute("searchCondition", searchCondition);
		
		return "productList";
		
	}
}