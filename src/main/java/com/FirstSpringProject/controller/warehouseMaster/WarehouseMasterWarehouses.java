package com.FirstSpringProject.controller.warehouseMaster;

import com.FirstSpringProject.model.Warehouse;
import com.FirstSpringProject.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by sicluceatlux on 2017-04-29.
 */
@Controller @RequestMapping("/warehouseMaster/warehouseInventory") public class WarehouseMasterWarehouses {
	
	@Autowired private WarehouseService warehouseService;
	
	@RequestMapping("/viewWarehouse/{warehouseId}")
	public String getWarehouseDetail(@PathVariable("warehouseId") int warehouseId, Model model) {
		Warehouse warehouse = warehouseService.getWarehouseById(warehouseId);
		model.addAttribute("warehouse", warehouse);
		return "viewWarehouse";
	}
	
	@RequestMapping("/addWarehouse") public String addWarehouse(Model model) {
		Warehouse warehouse = new Warehouse();
		model.addAttribute("warehouse", warehouse);
		
		return "addWarehouse";
	}
	
	@RequestMapping(value = "/addWarehouse", method = RequestMethod.POST)
	public String addWarehousePost(@Valid @ModelAttribute("warehouse") Warehouse warehouse,
								   BindingResult result,
								   HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addWarehouse";
		}
		
		warehouseService.addWarehouse(warehouse);
		
		return "redirect:/warehouseMaster/warehouseInventory";
	}
	
	@RequestMapping("/editWarehouse/{id}")
	public String editWarehouse(@PathVariable("id") int id, Model model) {
		Warehouse warehouse = warehouseService.getWarehouseById(id);
		
		
		model.addAttribute("warehouse", warehouse);
		
		return "editWarehouse";
	}
	
	@RequestMapping(value = "/editWarehouse", method = RequestMethod.POST)
	public String editWarehousePost(@Valid @ModelAttribute("warehouse") Warehouse warehouse,
									BindingResult result,
									HttpServletRequest request) {
		if (result.hasErrors()) {
			return "editWarehouse";
		}
		
		warehouseService.editWarehouse(warehouse);
		
		return "redirect:/warehouseMaster/warehouseInventory";
	}
	
	@RequestMapping("/deleteWarehouse/{id}")
	public String deleteWarehouse(@PathVariable int id, Model model, HttpServletRequest request) {
		
		Warehouse warehouse = warehouseService.getWarehouseById(id);
		warehouseService.deleteWarehouse(warehouse);
		
		return "redirect:/warehouseMaster/warehouseInventory";
	}
}
