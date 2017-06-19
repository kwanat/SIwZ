package com.FirstSpringProject.controller.warehouseMaster;

import com.FirstSpringProject.model.Manufacturer;
import com.FirstSpringProject.model.Product;
import com.FirstSpringProject.model.Warehouse;
import com.FirstSpringProject.service.CustomerService;
import com.FirstSpringProject.service.ManufacturerService;
import com.FirstSpringProject.service.ProductService;
import com.FirstSpringProject.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sicluceatlux on 2017-03-19.
 */
@Controller @RequestMapping("/warehouseMaster") public class WarehouseMasterProduct {
	
	private Path path;
	
	@Autowired private ProductService productService;
	@Autowired private ManufacturerService manufacturerService;
	@Autowired private WarehouseService warehouseService;
	
	@RequestMapping("/product/addProduct")
	public String addProduct( Model model) {
		Product product = new Product();
		product.setProductCategory("Vegetable");
		product.setProductCondition("Fresh");
		product.setProductStatus("Active");
		model.addAttribute("product", product);
		
		Map<String,Warehouse> warehouses = new HashMap<>();
		for (Warehouse warehouse:
				warehouseService.getWarehouseList()) {
			warehouses.put(warehouse.getWarehouseName(),warehouse);
		}
		model.addAttribute("warehouses",warehouses);
		
		Map<String,Manufacturer> manufacturerList = new HashMap<>();
		for (Manufacturer manufacturer:
				manufacturerService.getAllManufacturers()) {
			if(manufacturer.getManufacturerName().isEmpty())
				continue;
			manufacturerList.put(manufacturer.getManufacturerName(),manufacturer);
		}
		model.addAttribute("manufacturerList",manufacturerList);
		return "addProduct";
	}
	
	@RequestMapping(value = "/product/addProduct", method = RequestMethod.POST)
	public String addProductPost(@Valid @ModelAttribute("product") Product product,
								 BindingResult result,
								 HttpServletRequest request,
								 Model model) {
		if (result.hasErrors()) {
			Map<Warehouse,String> warehouses = new HashMap<>();
			for (Warehouse warehouse:
					warehouseService.getWarehouseList()) {
				warehouses.put(warehouse,warehouse.getWarehouseName());
			}
			model.addAttribute("warehouses",warehouses);
			
			Map<Manufacturer,String> manufacturerList = new HashMap<>();
			for (Manufacturer manufacturer:
					manufacturerService.getAllManufacturers()) {
				if(manufacturer.getManufacturerName().isEmpty())
					continue;
				manufacturerList.put(manufacturer,manufacturer.getManufacturerName());
			}
			model.addAttribute("manufacturerList",manufacturerList);
			
			return "addProduct";
		}
		
		productService.addProduct(product);
//
//		Warehouse warehouse = warehouseService.getWarehouseById(Integer.parseInt(request.getAttribute("warehouse")
//				.toString()));
//		product.setWarehouse(warehouse);
		
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");
		
		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(path.toString()));
			}
			catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Product image saving failed.", e);
			}
		}
		return "redirect:/warehouseMaster/productInventory";
	}
	
	@RequestMapping("/product/editProduct/{id}") public String editProduct(@PathVariable("id") int id, Model model) {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		
		Map<String,Warehouse> warehouses = new HashMap<>();
		for (Warehouse warehouse:
				warehouseService.getWarehouseList()) {
			warehouses.put(warehouse.getWarehouseName(),warehouse);
		}
		model.addAttribute("warehouses",warehouses);
		
		Map<String,Manufacturer> manufacturerList = new HashMap<>();
		for (Manufacturer manufacturer:
				manufacturerService.getAllManufacturers()) {
			if(manufacturer.getManufacturerName().isEmpty())
				continue;
			manufacturerList.put(manufacturer.getManufacturerName(),manufacturer);
		}
		model.addAttribute("manufacturerList",manufacturerList);
		return "editProduct";
	}
	
	@RequestMapping(value = "/product/editProduct", method = RequestMethod.POST)
	public String editProductPost(@Valid @ModelAttribute("product") Product product,
								  Model model,
								  BindingResult result,
								  HttpServletRequest request) {
		if (result.hasErrors()) {
			return "editProduct";
		}
		Map<String,Warehouse> warehouses = new HashMap<>();
		for (Warehouse warehouse:
				warehouseService.getWarehouseList()) {
			warehouses.put(warehouse.getWarehouseName(),warehouse);
		}
		model.addAttribute("warehouses",warehouses);
		
		Map<String,Manufacturer> manufacturerList = new HashMap<>();
		for (Manufacturer manufacturer:
				manufacturerService.getAllManufacturers()) {
			if(manufacturer.getManufacturerName().isEmpty())
				continue;
			manufacturerList.put(manufacturer.getManufacturerName(),manufacturer);
		}
		model.addAttribute("manufacturerList",manufacturerList);
		
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");
		
		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(path.toString()));
			}
			catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Product image saving failed.", e);
			}
		}
		
		productService.editProduct(product);
		
		return "redirect:/warehouseMaster/productInventory";
	}
	
	@RequestMapping("/product/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request) {
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + id + ".png");
		
		if (Files.exists(path)) {
			try {
				Files.delete(path);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Product product = productService.getProductById(id);
		productService.deleteProduct(product);
		
		return "redirect:/warehouseMaster/productInventory";
	}
	
}