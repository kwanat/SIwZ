package com.FirstSpringProject.controller.admin;

import com.FirstSpringProject.model.Customer;
import com.FirstSpringProject.service.CustomerService;
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
import java.io.IOException;

/**
 * Created by sicluceatlux on 2017-06-08.
 */
@Controller
@RequestMapping("admin/customerManagement")
public class AdminCustomerManagement {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/editCustomer/{id}") public String editCustomer(@PathVariable("id") int id, Model model) {
		Customer customer = customerService.getCustomerById(id);
		model.addAttribute("customer", customer);
		
		return "editCustomer";
	}
	
	@RequestMapping(value = "/editCustomer", method = RequestMethod.POST)
	public String editCustomerPost(@Valid @ModelAttribute("customer") Customer customer,
								  BindingResult result) {
		if (result.hasErrors()) {
			return "editCustomer";
		}
		
		customerService.editCustomer(customer);
		
		return "redirect:/admin/customerManagement";
	}
	
	@RequestMapping("/viewCustomer/{customerId}")
	public String viewProduct(@PathVariable int customerId, Model model) {
		Customer customer=customerService.getCustomerById(customerId);
		model.addAttribute("customer",customer);
		
		return "viewCustomer";
	}
	
}
