package com.FirstSpringProject.controller.admin;

import com.FirstSpringProject.model.ContactForm;
import com.FirstSpringProject.model.Customer;
import com.FirstSpringProject.model.ResponseForm;
import com.FirstSpringProject.service.ContactFormService;
import com.FirstSpringProject.service.CustomerService;
import com.FirstSpringProject.service.ResponseFormService;
import com.FirstSpringProject.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

/**
 * Created by sicluceatlux on 2017-04-29.
 */
@Controller
@RequestMapping("/admin")
public class AdminHome {
	@Autowired private CustomerService customerService;
	@Autowired private ContactFormService contactFormService;
	@Autowired private ResponseFormService responseFormService;
	@RequestMapping
	public String adminPage(){
		return "admin";
	}
	
	@RequestMapping("/customerManagement")
	public String customerManagement(Model model){
		List<Customer> customerList = customerService.getAllCustomers();
		model.addAttribute("customerList", customerList);
		return "customerManagement";
	}
	
	@RequestMapping("/contactFormsInventory")
	public String contactFormInventory(Model model){
		List<ContactForm> contactForms = contactFormService.getContactFormList();
		model.addAttribute("contactForms", contactForms);
		return "contactFormsInventory";
	}
	
	@RequestMapping("/responseFormsInventory")
	public String responseFormInventory(Model model){
		List<ResponseForm> responseForms = responseFormService.getResponseFormList();
		model.addAttribute("responseForms", responseForms);
		return "responseFormsInventory";
	}
	
	@RequestMapping("/contactForm/viewContactForm/{contactFormId}")
	public String contactFormView(Model model, @PathVariable(value ="contactFormId") int contactFormId)throws
																									   IOException {
		ContactForm contactForm = contactFormService.getContactFormById(contactFormId);
		model.addAttribute("contactForm",contactForm);
		
		return "viewContactForm";
	}
	
	@RequestMapping("/responseForm/viewResponseForm/{responseFormId}")
	public String responseFormView(Model model, @PathVariable(value ="responseFormId") int responseFormId)throws
																									   IOException {
		ResponseForm responseForm = responseFormService.getResponseFormById(responseFormId);
		model.addAttribute("responseForm",responseForm);
		
		return "viewResponseForm";
	}
}
