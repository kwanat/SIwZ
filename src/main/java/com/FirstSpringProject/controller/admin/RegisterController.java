package com.FirstSpringProject.controller.admin;

import com.FirstSpringProject.model.*;
import com.FirstSpringProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by sicluceatlux on 2017-03-19.
 */
@Controller
public class RegisterController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/register")
	public String registerCustomer(Model model){
		
		
		Customer customer = new Customer();
		Manufacturer manufacturer = new Manufacturer();
		BillingAddress billingAddress = new BillingAddress();
		ShippingAddress shippingAddress = new ShippingAddress();
		customer.setBillingAddress(billingAddress);
		customer.setShippingAddress(shippingAddress);
		customer.setManufacturer(manufacturer);
		model.addAttribute("customer", customer);
		
		return "registerCustomer";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerCustomerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult result,
									   Model model){
		if(result.hasErrors()){
			return "registerCustomer";
		}
		
		List<Customer> customers = customerService.getAllCustomers();
		
		for(int i = 0; i < customers.size(); i++) {
			if (customer.getCustomerEmail().equals(customers.get(i).getCustomerEmail())){
				model.addAttribute("emailMsg", "Email already exists in database!");
				return "registerCustomer";
			}
			if (customer.getUsername().equals(customers.get(i).getUsername())){
				model.addAttribute("usernameMsg", "Username is already taken!");
				return "registerCustomer";
			}
		}

		customer.setEnabled(false);
		customerService.addCustomer(customer);
		
		return "registerCustomerSuccess";
	}
}

